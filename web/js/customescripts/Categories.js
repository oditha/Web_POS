// Load All Departments

$(document).ready(function () {

    //load all categories

    $.fn.loadCategories();

    $.ajax({

        method: "POST",
        url: "loadDepartmentscate",
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

            });

            $('#department').selectpicker('refresh');

        }


    });

});

// Save Category


$("#saveBtn").click(function () {
    // alert("START")
    var form = $("#categoryForm").serialize();

    $.ajax({

        method: "POST",
        url: "saveCategory",
        data: form,
        success: function (responseText) {

            // alert(responseText)

            if (responseText === "done") {

                $.fn.loadCategories();
                swal("success", "Data saved successfully!", "success");
                $("#categoryForm")[0].reset();
                $("#categorycode").focus();

            } else {

                swal("error", "Data not saved successfully!", "error");
            }

        }

    });

});

// Validate Category code

$("#categorycode").keyup(function () {

    var text = $("#categorycode").val();

    if (text.length >= 2) {

        $.ajax({

            url: "validateCategory",
            method: "POST",
            data: {categorycode: text},
            success: function (responseText) {

                if (responseText === "avb") {

                    swal("warning", "Try new Category code!", "warning");


                }

            }

        })

    }

});


// load all categoris


$.fn.loadCategories = function () {

    $.ajax({

        method: "POST",
        url: "loadCategories",
        success: function (responseText) {

            if ($.fn.dataTable.isDataTable('#categoryTable')) {
                table = $('#categoryTable').DataTable({});
                table.destroy();
            }


            $("#categoryTable").DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'num'},
                    {data: 'code'},
                    {data: 'name'},
                    {data: 'type'},
                    {data: 'department'},
                    {data: 'addby'},
                    {data: 'button'},

                ],
                responsive: true

            });

        }


    });

}

// Delete Category

function deletec(idcategory) {

    swal({
        title: 'Are you sure?',
        text: "It will permanently deleted !",
        type: 'warning',
        icon: "warning",
        buttons: true,
        dangerMode: true,

    }).then(function (isConfirm) {
        if (isConfirm) {


            $.ajax({

                method: "POST",
                url: "deleteCategories",
                data: {idcategory: idcategory},
                success: function (resposeText) {


                    if (resposeText === "done") {

                        $.fn.loadCategories();
                        swal("Deleted!", "Your item deleted.", "success");

                    }else {

                        swal("Try again!", "Something went wrong.", "error");

                    }

                }


            })


        } else {

            swal("Cancelled", "Category not deleted", "error");

        }
    })

}
