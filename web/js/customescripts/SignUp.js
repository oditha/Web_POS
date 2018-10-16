//Get Url PArameters

function GetURLParameter(sParam) {

    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');

    for (var i = 0; i < sURLVariables.length; i++) {

        var sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] == sParam) {

            return sParameterName[1];

        }

    }

}

// Save User

$("#signin").click(function () {

    var valid = true;

    $.each($("#sign_in input.required"), function (index, value) {

        if (!$(value).val()) {
            valid = false;
        }
    });

    if (valid) {


        var id = GetURLParameter("id");
        var company = GetURLParameter("company");
        var type = GetURLParameter("type");
        var uname = $("#username").val();
        var pass = $("#password").val();
        var pass2 = $("#password2").val();

        // alert(type)

        if (pass === pass2) {

            $.ajax({

                method: "POST",
                url: "register",
                data: {iduser: id, username: uname, password: pass, company: company, type: type},
                success: function (responseText) {


                    if (responseText === "done") {

                        swal("Success", "User Created. Click to login", "success").then(function (value) {

                            window.location.replace("login");

                        });


                    } else {

                        swal("Error", "Something went wrong", "error");

                    }


                }

            });

        } else {

            swal("Password not matched");

        }
    } else {

        swal("Fill all fields");

    }

});