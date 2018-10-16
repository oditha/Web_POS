// Startup

// Startup

$(document).ready(function () {

    loadUsers();
    loadWorks();

});


$("#datestart").daterangepicker({


    locale: {
        format: 'YYYY-MM-DD'
    },
    "startDate": "2018/08/01",
    showDropdowns: true,

});

//Load Users

function loadUsers() {

    $.ajax({

        method: "POST",
        url: "loadUsers",
        success: function (responseText) {

            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var username = value.username;
                var iduser = value.iduser;
                // alert(department);

                $("#user").append($("<option></option>", {

                    value: iduser,
                    text: username

                }));

            });

            $('#user').selectpicker('refresh');

        }

    });

}

//Load Currnt Month Works

function loadWorks() {

    $.ajax({

        method: "POST",
        url: "loadWorks",
        success: function (responseText) {


            $("#workstable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'user'},
                    {data: 'date'},
                    {data: 'orderId'},
                    {data: 'account'},
                    {data: 'type'},
                    {data: 'updateNo'},


                ],
                responsive: true,
                "order": [[2, "asc"]],
                "autoWidth": false

            });

        }

    })

}

// Filter Works

$("#filterBtn").click(function () {

    var data = $("#worksForm").serialize();


    $.ajax({

        method: "POST",
        url: "filterWorks",
        data: data,
        success: function (responseText) {


            $("#workstable").DataTable({
                destroy: true,
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(responseText),
                columns: [

                    {data: 'user'},
                    {data: 'date'},
                    {data: 'orderId'},
                    {data: 'account'},
                    {data: 'type'},
                    {data: 'updateNo'},


                ],
                responsive: true,
                "order": [[2, "asc"]],
                "autoWidth": false

            });


        }

    })

});