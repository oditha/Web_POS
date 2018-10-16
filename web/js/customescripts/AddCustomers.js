// Save Supplier

$("#saveBtn").click(function () {

// validate required fields

    var valid = true;

    $.each($("#customerForm input.required"), function (index, value) {

        if (!$(value).val()) {
            valid = false;
        }
    });


    if (valid){

        $.ajax({

            method:"POST",
            url:"saveCustomer",
            data: $("#customerForm").serialize(),
            success: function (responseText) {

                if (responseText==="done"){

                    $("#customerForm")[0].reset();
                    swal("Success", "Data saved successfully", "success");

                } else {

                    swal("Error", "Data not saved successfully", "error");

                }

            }

        });

    } else {

        swal("Fill required fields")

    }


})