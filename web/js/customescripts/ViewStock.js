// Load Stock

$(document).ready(function () {

    $.ajax({

        method:"POST",
        url:"viewStock",
        success:function (responseText) {

            $("#stockTable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'item'},
                    {data: 'category'},
                    {data: 'department'},
                    {data: 'qty'},
                    {data: 'price'},


                ],
                responsive: true

            });


        }

    });

});