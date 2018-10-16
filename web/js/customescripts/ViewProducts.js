// Startup functions

$(document).ready(function () {

    // Load Departments
    loadDepartments();
    // Load Categories;
    loadCategories()

    // Load Products
    loadAllProducts();

    //Load Units
    loadUnitss();

    // Update Product
    $("#update").click(function () {

        var data = $("#productForm").serialize();
        
        swal({
            title: 'Are you sure?',
            text: "This will update Item details !",
            type: 'warning',
            icon: "warning",
            buttons: true,
            dangerMode: true,

        }).then(function (isConfirm) {
            if (isConfirm) {


                $.ajax({

                    method: "POST",
                    url: "updateProduct",
                    data: data,
                    success: function (responseText) {


                        if (responseText === "done") {

                            loadAllProducts();
                            swal("Deleted!", "Your item Updated.", "success");

                        }else {

                            swal("Try again!", "Something went wrong.", "error");

                        }

                    }


                })


            } else {

                // swal("Cancelled", "Item not Updated", "error");

            }
        })



    });

    // Update Product
    $("#delete").click(function () {

        var data = $("#productForm").serialize();


        swal({
            title: 'Are you sure?',
            text: "This will Delete item !",
            type: 'warning',
            icon: "warning",
            buttons: true,
            dangerMode: true,

        }).then(function (isConfirm) {
            if (isConfirm) {


                $.ajax({

                    method: "POST",
                    url: "deleteProduct",
                    data: data,
                    success: function (responseText) {


                        if (responseText === "done") {

                            loadAllProducts();
                            swal("Deleted!", "Your item Delete.", "success");

                        }else {

                            swal("Try again!", "Something went wrong.", "error");

                        }

                    }


                })


            } else {

                // swal("Cancelled", "Item not Updated", "error");

            }
        })



    });

})

function loadDepartments() {

    $.ajax({

        method: "POST",
        url: "LoadDepartmentsProducts",
        success: function (responseText) {


            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var department = value.department;
                var iddepartment = value.iddepartment;
                // alert(department);

                $("#department").append($("<option></option>", {

                    value: iddepartment,
                    text: department

                }));

                $("#departmentm").append($("<option></option>", {

                    value: iddepartment,
                    text: department

                }));

            });

            $('#department').selectpicker('refresh');
            $('#departmentm').selectpicker('refresh');

        }


    });
}

function loadCategories() {

    $.ajax({

        method: "POST",
        url: "loadCategories",
        success: function (responseText) {


            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var name = value.name;
                var idcat = value.idcat;
                // alert(department);

                $("#category").append($("<option></option>", {

                    value: idcat,
                    text: name

                }));

                $("#categorym").append($("<option></option>", {

                    value: idcat,
                    text: name

                }));

            });

            $('#category').selectpicker('refresh');
            $('#categorym').selectpicker('refresh');


        }


    });

}

function loadAllProducts() {

    $.ajax({

        url: "loadAllProducts",
        method: "POST",
        success: function (responseText) {

            //
            // if ($.fn.dataTable.isDataTable('#productTable')) {
            //     table = $('#productTable').DataTable({});
            //     table.destroy();
            // }


            $("#productTable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'num'},
                    {data: 'pname'},
                    {data: 'category'},
                    {data: 'department'},
                    {data: 'sellingprice'},
                    {data: 'button'},


                ],
                responsive: true

            });

        }


    });


}


// Filter By Department

$("#department").change(function () {

    var department = $("#department").find(":selected").val();

    $.ajax({

        method: "post",
        url: "productFilter",
        data: {type: "department", term: department},
        success: function (responseText) {

            $("#productTable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'num'},
                    {data: 'pname'},
                    {data: 'category'},
                    {data: 'department'},
                    {data: 'sellingprice'},
                    {data: 'button'},


                ],
                responsive: true

            });

        }


    });

});

// Filter By Category

$("#category").change(function () {

    var category = $("#category").find(":selected").val();

    $.ajax({

        method: "post",
        url: "productFilter",
        data: {type: "category", term: category},
        success: function (responseText) {


            $("#productTable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'num'},
                    {data: 'pname'},
                    {data: 'category'},
                    {data: 'department'},
                    {data: 'sellingprice'},
                    {data: 'button'},


                ],
                responsive: true

            });

        }


    });

});

// Filter By Type

$("#type").change(function () {

    var type = $("#type").find(":selected").text();

    $.ajax({

        method: "post",
        url: "productFilter",
        data: {type: "type", term: type},
        success: function (responseText) {

            $("#productTable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'num'},
                    {data: 'pname'},
                    {data: 'category'},
                    {data: 'department'},
                    {data: 'sellingprice'},
                    {data: 'button'},


                ],
                responsive: true

            });

        }


    });

});

// Reset Search

$("#loadAll").click(function () {

    loadAllProducts();

});

// View Products Details

function viewProducts(idProduts, productsname) {

    $.ajax({

        url: "viewProducts",
        method: "POST",
        data: {idproduts: idProduts},
        success: function (responseText) {


            var json = JSON.parse(responseText)

            $("#productcode").val(json.pcode);
            $("#barcode").val(json.barcode);

            $('#departmentm').selectpicker('val', json.department);
            $('#categorym').selectpicker('val', json.category);
            $('#messuringunit').selectpicker('val', json.units);

            $("#categorym").val();
            $("#productName").val(json.pname);
            $("#unitprice").val(json.unitprice);
            $("#sellingprice").val(json.sellprice);
            $("#specialprice").val(json.spcprice);
            $("#stock").val(json.stock);

            $("#reorderlevel").val(json.reorder);
            $("#addby").text(json.addby)
            $("#idproduct").val(json.idproduct)


            if (json.typee === "SERVICE") {

                $("#typee").text("Service");

            } else {

                $("#typee").text("Product");
                $("#typee").removeClass("bg-indigo");
                $("#typee").addClass("bg-purple");

            }


            $("#status").text("Active")


            $("#ViewProducts").modal();
            $("#ViewProducts").find('.modal-title').text(productsname);
        }

    });


}



// Load Units

function loadUnitss() {

    $.ajax({

        method: "POST",
        url: "loadUnits",
        success: function (responseText) {

            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var idUnit = value.unitid;
                var unitName = value.unitname;
                // alert(department);

                $("#messuringunit").append($("<option></option>", {

                    value: idUnit,
                    text: unitName

                }));

            });

            $('#messuringunit').selectpicker('refresh');

        }


    });

}



