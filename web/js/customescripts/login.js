//-------------------Load Modal------------------
if (typeof jQuery === "undefined") {
    throw new Error("jQuery plugins need to be before this file");
}

$(document).ready(function () {


    $.ajax({

        method: "POST",
        url: "CheckStartup",
        success: function (response) {

            if (response === "navb") {

                $('#start').modal({

                    backdrop: 'static',
                    keyboard: false


                });

            }

        }


    });


});

// --- Save startup-------------

$(document).ready(function () {

    $("#savesetup").click(function () {

        var data = $("#StartUpForm").serialize();

        $.ajax({

            url: "SaveCompanyStartup",
            method: "POST",
            data: data,
            success: function (responsetext) {

                if (responsetext === "done") {
                    $('#start').modal('hide');
                    // swal("Success", "Company Setup Complete. You may login to system.", "success");
                    $("#username").focus();

                }

            }


        });

    });


});

//----------------Login to system ------------

//
// $("#signin").click(function () {
//
//
//     var data = $("#sign_in").serialize();
//     alert(data)
//     $.ajax({
//
//         url: "UserLogin",
//         method: "POST",
//         data: data,
//         success: function (responsetext) {
//
//             alert(responsetext)
//
//             if (responsetext==="done") {
//
//                 alert("OK")
//                 window.location.replace("dashboard");
//
//             }
//
//         }
//
//
//     });
//
//
// });

