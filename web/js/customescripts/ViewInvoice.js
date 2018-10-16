//start up functions

$(document).ready(function () {

    loadSuppliers();
    loadGrn();

})

// Date Range picker

$("#datestart").daterangepicker({


    locale: {
        format: 'YYYY-MM-DD'
    },
    "startDate": "2018/08?01",
    showDropdowns: true,

});

//load Suppliers
function loadSuppliers() {

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

// Load All GRNS

function loadGrn() {


    $.ajax({

        method: "POST",
        url: "loadAllInvoice",
        success: function (responseText) {

            $("#grntable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'grnno'},
                    {data: 'supplier'},
                    {data: 'grndate'},
                    {data: 'total'},
                    {data: 'button'},


                ],
                "columnDefs": [
                    {className: "text-right", "targets": [3]}
                ],
                responsive: true,
                "order": [[2, "desc"]]

            });

        }

    })

}

// View Grn Model

function viewGrn(idGrn, supplierName) {

    $.ajax({

        method: "POST",
        url: "viewInvoiceRecord",
        data: {idInvoice: idGrn},
        success: function (responseText) {

            // alert(responseText)

            if (responseText !== "ERROR") {


                var split = responseText.split("$$");

                var datasplit = split[0];
                var itemssplit = split[1];
                var paymentssplit = split[2];


                var data = JSON.parse(datasplit);

                $("#grnid").text(data.grnid);
                $("#date").text(data.date);
                $("#supplier").text(data.supplier);
                $("#total").text(data.total);
                $("#createby").text(data.createby);
                $("#grntotal").text(data.total);
                $("#totalpaid").text(data.totalpaid);
                $("#outstanding").text(data.outstanding);


                $("#producttable").DataTable({
                    destroy: true,
                    dom: 'Bfrtip',
                    buttons: [
                        'excel', 'pdf', 'print',
                    ],
                    data: JSON.parse(itemssplit.trim()),
                    columns: [

                        {data: 'item'},
                        {data: 'price'},
                        {data: 'qty'},
                        {data: 'total'},

                    ],
                    "columnDefs": [
                        {className: "text-right", "targets": [3]}
                    ],
                    responsive: true,
                    "order": [[0, "asc"]],
                    "autoWidth": false

                });


                $("#paymentTable").DataTable({
                    destroy: true,
                    dom: 'Bfrtip',
                    buttons: [
                        'excel', 'pdf', 'print',
                    ],
                    data: JSON.parse(paymentssplit.trim()),
                    columns: [

                        {data: 'date'},
                        {data: 'type'},
                        {data: 'amount'},
                        {data: 'addBy'},

                    ],
                    "columnDefs": [
                        {className: "text-right", "targets": [2]}
                    ],
                    responsive: true,
                    "order": [[0, "desc"]],
                    "autoWidth": false

                });


                $("#viewGrn").modal();


            } else {

                swal("Error", "Something went wrong, Try again", "error");

            }

        }

    })

}


// Filtering

$("#filterBtn").click(function () {

    var selected = $("#selectsupplier").find(":selected").val();
    var dates = $("#datestart").val();
    var type = "FILTER";

    if (selected === "All Suppliers") {

        type = "ALL";

    }

    $.ajax({


        method:"POST",
        url:"filterGrn",
        data:{type:type, idSupplier: selected, dates: dates},
        success:function (responseText) {

            $("#grntable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'supplier'},
                    {data: 'grnno'},
                    {data: 'grndate'},
                    {data: 'total'},
                    {data: 'button'},


                ],
                "columnDefs": [
                    {className: "text-right", "targets": [3]}
                ],
                responsive: true,
                "order": [[2, "desc"]]

            });

        }

    });

});


// Refersh Serch

$("#resetBtn").click(function () {

    loadGrn();

})