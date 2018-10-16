//Startup
$(document).ready(function () {

    loadUsers()

});


// Load Avaliable Users
function loadUsers() {

}

//Save user

$("#saveBtn").click(function () {

    var data = $("#userFrame").serialize();
    var valid = true;

    $.each($("#userFrame input.required"), function (index, value) {

        if (!$(value).val()) {
            valid = false;
        }
    });

    if (valid){

        $.ajax({

            method: "POST",
            url: "saveUser",
            data: data,
            success: function (responseText) {

                if (responseText === "done"){


                    swal("Success", "Data has been saved successfully" , "success").then(function (value) {

                        loadUsers();
                        $("#userFrame")[0].reset();
                        $("#nic").focus();


                    });


                } else {

                    swal("Error", "Data not saved successfully" , "error");


                }

            }

        });

    } else {

        swal("Fill All fields")

    }


});