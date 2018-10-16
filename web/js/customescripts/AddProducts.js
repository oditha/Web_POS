//Generate New Barcode

$("#generateBarcode").click(function () {


    $.ajax({

        method: "POST",
        url: "genBarcode",
        success: function (responseText) {

            $("#barcode").val(responseText);

        }

    });

});

$(document).ready(function () {


    // Load Units

    loadUnitss();

    // Load Departments

    $.ajax({

        method: "POST",
        url: "LoadDepartmentsProducts",
        success: function (responseText) {


            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var department = value.department;
                var iddepartment = value.iddepartment;
                // alert(department);

                $("#department").append($("<option></option>", {

                    value: iddepartment,
                    text: department

                }));

            });

            $('#department').selectpicker('refresh');

        }


    });

});

// load categories when department selected

$("#department").change(function () {

    var id = $("#department").find(":selected").val();

    $.ajax({

        method: "POST",
        url: "loadCategoryByDepartment",
        data: {idDepartment: id},
        success: function (responseText) {


            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var idCate = value.id;
                var catename = value.name;
                // alert(department);

                $("#category").append($("<option></option>", {

                    value: idCate,
                    text: catename

                }));

            });

            $('#category').selectpicker('refresh');

        }


    });


});

// Open Add Unit Modal----------

$("#addUnit").click(function () {


    swal({

        // closeOnClickOutside: false,
        // closeOnEsc: false,
        confirmButtonColor: "#1f91f3",
        buttons: {

            cancel: true,
            confirm: "Save",

        },
        content: {
            element: "input",
            attributes: {
                placeholder: "Type Unit Name",
                type: "text",
            },
        },
        dangerMode: true,
    }).then(function (isConfirm) {

        var value = isConfirm;

        if (isConfirm) {

            if (value !== "") {

                $.ajax({


                    method: "POST",
                    url: "saveUnit",
                    data: {unitName: value},
                    success: function (responseText) {

                        if (responseText === "done") {

                            loadUnitss();
                            swal("Success", "Data saved successfully", "success");

                        } else {


                            swal("Error", "Data not saved successfully", "error");

                        }

                    }

                });

            }
        }
        //

    })


});

// Load Messureunit from db

function loadUnitss() {

    $.ajax({

        method: "POST",
        url: "loadUnits",
        success: function (responseText) {

            var json = JSON.parse(responseText);

            $.each(json, function (key, value) {


                var idUnit = value.unitid;
                var unitName = value.unitname;
                // alert(department);

                $("#messuringunit").append($("<option></option>", {

                    value: idUnit,
                    text: unitName

                }));

            });

            $('#messuringunit').selectpicker('refresh');

        }


    });

}


//Generate Product Code

$("#productName").keyup(function () {

    var randomNumber = generateNumber();

    var text = $("#productName").val()

    if (text.indexOf(" ") != -1) {

        var split = text.split(" ");

        if (split[1] === "") {

        } else {

            var pcdoenew = "";

            $.each(split, function (key, value) {

                var code = value.substring(0, 1);
                pcdoenew += code;

            })

            $("#productcode").val(pcdoenew.toUpperCase() + randomNumber);


        }


    } else {

        var code = text.substring(0, 2).toUpperCase();

        var pcode = code + randomNumber;

        $("#productcode").val(pcode);

    }


});

// Generate Random Number

function generateNumber() {

    var min = 11111;
    var max = 99999

    return Math.floor(Math.random() * (max - min + 1) + min);

}

// Save Poducts

$("#saveBtn").click(function () {

// validate required fields

    var valid = true;

    $.each($("#productform input.required"), function (index, value) {

        if (!$(value).val()) {

            valid = false;
        }
    });

    var selectvalid = true;


    $.each($("#productform select"), function (index, value) {

        if ($(value).val() === "Select") {

            selectvalid = false;

        }

    })


    if (valid && selectvalid) {


        $.ajax({

            method: "POST",
            url: "saveProducts",
            data: $("#productform").serialize(),
            success: function (responseText) {

                if ((responseText === "done")) {

                    $("#productform")[0].reset();

                    swal("Success", "Data saved successfully", "success")
                    $('.myselect').selectpicker('refresh')
                    // $(".myselect")[0].selectedIndex = 0;

                } else {

                    swal("Error", "Data not saved successfully", "error")

                }

            }

        })


    } else {

        swal("Warning", "Fill required field mark with star(*)", "info");

    }

})