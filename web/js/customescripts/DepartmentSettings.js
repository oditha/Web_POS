//Save Department


$.fn.Save = function () {

    var data = $("#departmentname").val();

    if (data === "") {

        swal("error", "Fill required fields!", "error");


    } else {

        $.ajax({

            url: "SaveDepartment",
            method: "POST",
            data: {departmentname: data},
            success: function (ResposeText) {


                try {

                    $("#departmentname").val("");
                    $.fn.LoadAll();
                    swal("success", "Data saved successfully!", "success");

                } catch (e) {
                    // alert(e)
                }


            }


        });

    }


}

$("#SaveBtn").click(function () {

    $.fn.Save();

});

$("#departmentname").keyup(function (event) {

    var keycode = (event.keyCode ? event.keyCode : event.which);
    if (keycode == '13') {

        $.fn.Save();

    }


});


//Load All Departments

$.fn.LoadAll = function () {

    $.ajax({

        url: "LoadDepartments",
        method: "POST",
        success: function (ResponseText) {

            if ($.fn.dataTable.isDataTable('.table')) {
                table = $('.table').DataTable({

                    responsive: true

                });
                table.destroy();
            }


            $(".table").DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'excel', 'pdf', 'print',
                ],
                data: JSON.parse(ResponseText),
                columns: [

                    {data: 'id'},
                    {data: 'department'},
                    {data: 'company'},
                    {data: 'button'},

                ],
                responsive: true

            });


        }


    });

}

$(document).ready(function () {

    $.fn.LoadAll();

    $("#update").click(function () {

        $.fn.upadte();
    });

    $("#delete").click(function () {


        $.fn.delete();
    });


});

//Open Model

function loadmodel(departmentname, departmentid) {


    $("#IdDepartment").val(departmentid);
    $("#department_name").val(departmentname);
    $("#departmentModal").modal();


}


// Update Record

$.fn.upadte = function () {


    var deparment = $("#department_name").val();
    var deparmentid = $("#IdDepartment").val();

    $.ajax({

        url: "UpdateDepartment",
        method: "POST",
        data: {departmentname: deparment, idDepartment: deparmentid},
        success: function (ResponseText) {

            if (ResponseText === "done") {

                $.fn.LoadAll();
                $("#departmentModal").modal("hide");
                swal("success", "Data saved successfully!", "success");

            }


        }

    });

}

// Delete Record

$.fn.delete = function () {


    var deparment = $("#department_name").val();
    var deparmentid = $("#IdDepartment").val();

    $.ajax({

        url: "DeleteDepartment",
        method: "POST",
        data: {departmentname: deparment, idDepartment: deparmentid},
        success: function (ResponseText) {

            if (ResponseText === "done") {

                $.fn.LoadAll();
                $("#departmentModal").modal("hide");
                swal("success", "Data Deleted successfully!", "success");

            }


        }

    });

}