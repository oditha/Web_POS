// Startup Functions

$(document).ready(function () {

    $("#grntotal").val(0)

    loadCustomers();
    loadProducts();
    genInvoiceNo()

})

$(function () {
    $('#grntable').editableTableWidget();
});


//Generate Invoice no

function genInvoiceNo() {


    $.ajax({

        method: "POST",
        url: "genInvoiceNo",
        success: function (responseText) {


            $("#grnno").val(responseText);

        }


    })

}


//load Suppliers
function loadCustomers() {

    $.ajax({

        method: "POST",
        url: "loadCustomers",
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
    $("#paidamount").val(set);
    $("#nettotal").val(set);

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

    var set = (parseFloat(before) - parseFloat(total)).toFixed(2)

    $("#grntotal").val(set)
    $("#paidamount").val(set);
    $("#nettotal").val(set);

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
        itemname = $tds.eq(0).text();
        qty = $tds.eq(2).text();
        unitprice = $tds.eq(1).text();
        total = $tds.eq(3).text();


        item = {};
        item ["idproduct"] = idproduct;
        item ["itemname"] = itemname;
        item ["qty"] = qty;
        item ["unitprice"] = unitprice;
        item ["total"] = total;

        //get sum of html column
        jsonObject.push(item);


    });

    var tabaledata = JSON.stringify(jsonObject);

    var idSupplier = $("#selectsupplier").find(":selected").val();
    var grnno = $("#grnno").val();
    var grndate = $("#grndate").val();
    var grntotal = $("#grntotal").val();
    var paid = $("#paidamount").val()
    // var paytype = $("#paidby").val();
    var discount = $("#discount").val();
    var netttotal = $("#nettotal").val();


    $.ajax({

        method: "POST",
        url: "saveInvoice",
        data: {
            tabledata: tabaledata,
            idSupplier: idSupplier,
            grnno: grnno,
            grndate: grndate,
            grntotal: grntotal,
            paid: paid,
            paytype: "CASH",
            discount: discount,
            netttotal: netttotal,
        },
        success: function (responseText) {

            if (responseText === "done") {

                swal("Success", "Data saved successfully", "success").then(function (value) {


                    $("#invoiceForm")[0].reset();
                    genInvoiceNo();
                    $("#grndate").daterangepicker({

                        locale: {
                            format: 'YYYY-MM-DD'
                        },
                        singleDatePicker: true,
                        showDropdowns: true,


                    });
                    $('#grntable tbody').remove();

                });

            } else {

                swal("Error", "Data not saved successfully", "error");

            }

        }

    })

})

// Paid Amount validations

$("#paidamount").keyup(function () {

    var paid = $("#paidamount").val();
    var total = $("#nettotal").val()

    if (paid > total){

        swal("Info", "Paid amount can not be greater than net total", "info").then(function (value) {

            $("#paidamount").val(total);

        });

    }


});



































































