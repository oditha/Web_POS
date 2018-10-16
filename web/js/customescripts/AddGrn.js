// Startup Functions

$(document).ready(function () {

    $("#grntotal").val(0)

    loadSuppliers();
    loadProducts();

    //Init DataTable
    // var t = $('#grntable').DataTable({
    //
    //     "paging": false,
    //     "search": false
    //
    // });
})

$(function () {
    $('#grntable').editableTableWidget();
});

//load Suppliers
function loadSuppliers() {

    $.ajax({

        method: "POST",
        url: "loadSuppliers",
        success: function (responseText) {

            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var supname = value.supname;
                var supid = value.supid;
                // alert(department);

                $("#selectsupplier").append($("<option></option>", {

                    value: supid,
                    text: supname

                }));

            });

            $('#selectsupplier').selectpicker('refresh');

        }

    });

}

//Load Products


function loadProducts() {

    $.ajax({

        method: "POST",
        url: "loadProducts",
        success: function (responseText) {

            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var productname = value.productname;
                var productid = value.productid;
                var unitprice = value.unitpricee;
                var unit = value.unitt;
                // alert(department);

                $("#selectproduct").append($("<option></option>", {

                    value: productid,
                    text: productname,
                    unitprice: unitprice,
                    unit: unit


                }));

            });

            $('#selectproduct').selectpicker('refresh');

        }

    });

}

// load products records

$("#selectproduct").change(function () {

    var unitprice = $("#selectproduct").find(":selected").attr("unitprice");
    var unit = $("#selectproduct").find(":selected").attr("unit");

    $("#unitprice").val(unitprice);
    $("#Unit").val(unit);

    $("#quantity").val("1");
    $("#quantity").focus();
});

// Add to table

$("#quantity").keyup(function (e) {


    var qty = $("#quantity").val()
    var price = $("#unitprice").val()
    var pname = $("#selectproduct").find(":selected").text();
    var pid = $("#selectproduct").find(":selected").val();

    var total = qty * price
    var key = e.which;

    var grntotal = $("#grntotal").val();
    var settotal = parseFloat(grntotal) + parseFloat(total);

    // alert(settotal)
    var set = settotal.toFixed(2);

    $("#grntotal").val(set);

    if (key === 13) {


        if (qty !== "") {

            $('#grntable').append('<tr id="' + pid + '">' +
                '<td id="' + pid + '">' + pname + '</td>' +
                '<td class="text-right">' + price + '</td>' +
                '<td class="text-center">' + qty + '</td>' +
                '<td class="text-right">' + total.toFixed(2) + '</td>' +
                '<td class="text-center"><button type="button" id="' + pid + '" onclick="removeRow(this.id)" class="btn btn-danger waves-effect">' +
                '                                    <i class="material-icons">remove_circle</i>' +
                '                                </button></td>' +
                '</tr>');


            $("#selectproduct").focus();

        } else {

            swal("Enter Quantity").then(function (value) {


                $("#quantity").focus();

            });


        }

    }


})

// Remove row

function removeRow(rowid) {

    var seletor = "#" + rowid

    var total = $(seletor).closest("tr").find('td:eq(3)').text();

    var before = $("#grntotal").val();

    $("#grntotal").val((parseFloat(before)-parseFloat(total)).toFixed(2))

    $(seletor).remove();

}

// Date Picker

$("#grndate").daterangepicker({

    locale: {
        format: 'YYYY-MM-DD'
    },
    singleDatePicker: true,
    showDropdowns: true,


});


// Save GRN

$("#saveBtn").click(function () {

    var table = $("table tbody");
    jsonObject = [];


    table.find("tr").each(function (i) {


        var $tds = $(this).find("td");

        idproduct = $tds.eq(0).attr("id");
        qty = $tds.eq(2).text();
        unitprice = $tds.eq(1).text();
        total = $tds.eq(3).text();


        item = {};
        item ["idproduct"] = idproduct;
        item ["qty"] = qty;
        item ["unitprice"] = unitprice;
        item ["total"] = total;
        // alert(item)
        //get sum of html column
        jsonObject.push(item);


    });

    var tabaledata = JSON.stringify(jsonObject);

    // alert(tabaledata)

    var idSupplier = $("#selectsupplier").find(":selected").val();
    var grnno = $("#grnno").val();
    var grndate = $("#grndate").val();
    var grntotal = $("#grntotal").val();
    var paid = $("#paidamount").val()
    var paytype = $("#paidby").val();

    $.ajax({

        method:"POST",
        url:"saveGrn",
        data:{tabledata:tabaledata,idSupplier:idSupplier, grnno:grnno, grndate:grndate,grntotal:grntotal,paid:paid, paytype:paytype},
        success:function (responseText) {

            if (responseText === "done"){

                swal("Success", "Data saved successfully", "success")

            } else {

                swal("Error", "Data not saved successfully", "error")

            }

        }

    })

})



































































