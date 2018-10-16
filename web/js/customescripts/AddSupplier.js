// Save Supplier

$("#saveBtn").click(function () {

// validate required fields

    var valid = true;

    $.each($("#supplierForm input.required"), function (index, value) {

        if (!$(value).val()) {
            valid = false;
        }
    });


    if (valid){

        $.ajax({

            method:"POST",
            url:"saveSupplier",
            data: $("#supplierForm").serialize(),
            success: function (responseText) {

                if (responseText==="DONE"){

                    $("#supplierForm")[0].reset();
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