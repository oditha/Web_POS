if (typeof jQuery === "undefined") {
    throw new Error("jQuery plugins need to be before this file");
}

$(document).ready(function () {

    $("#updateno").prop("readonly", true);


    try {
        $("#stockrecord").click(function () {

            $("#stockModal").modal({

                backdrop: 'static',
                keyboard: false

            });

        });
    } catch (e) {
        alert(e);
    }


});

//Masked Input ============================================================================================================================
var $demoMaskedInput = $('.demo-masked-input');

//Date
$demoMaskedInput.find('.date').inputmask('dd/mm/yyyy', {placeholder: '__/__/____'});

//Time
$demoMaskedInput.find('.time12').inputmask('hh:mm t', {placeholder: '__:__ _m', alias: 'time12', hourFormat: '12'});
$demoMaskedInput.find('.time24').inputmask('hh:mm', {placeholder: '__:__ _m', alias: 'time24', hourFormat: '24'});

//Date Time
$demoMaskedInput.find('.datetime').inputmask('d/m/y h:s', {
    placeholder: '__/__/____ __:__',
    alias: "datetime",
    hourFormat: '24'
});

//Mobile Phone Number
$demoMaskedInput.find('.mobile-phone-number').inputmask('+99 (999) 999-99-99', {placeholder: '+__ (___) ___-__-__'});
//Phone Number
$demoMaskedInput.find('.phone-number').inputmask('+99 (999) 999-99-99', {placeholder: '+__ (___) ___-__-__'});

//Dollar Money
// $demoMaskedInput.find('.money-dollar').inputmask();
//Euro Money
$demoMaskedInput.find('.money-euro').inputmask('99,99 â‚¬', {placeholder: '__,__ â‚¬'});

//IP Address
$demoMaskedInput.find('.ip').inputmask('999.999.999.999', {placeholder: '___.___.___.___'});

//Credit Card
$demoMaskedInput.find('.credit-card').inputmask('9999 9999 9999 9999', {placeholder: '____ ____ ____ ____'});

//Email
$demoMaskedInput.find('.email').inputmask({alias: "email"});

//Serial Key
$demoMaskedInput.find('.key').inputmask('****-****-****-****', {placeholder: '____-____-____-____'});
//===========================================================================================================================================

// Spinner Number Only

$(document).ready(function () {

    $('.spinnumber').keypress(function (e) {


        var keyCode = (e.which) ? e.which : event.keyCode
        return !(keyCode > 31 && (keyCode < 48 || keyCode > 57));


    });

});


//Open Works Model

$("#works").click(function () {

    $("#worksModel").modal({

        backdrop: 'static',
        keyboard: false

    });

});

//Save Works

$("#saveWorks").click(function () {

    var order = $("#orderno").val();

    if (order !== "") {


        $.ajax({

            method: "POST",
            url: "saveWorks",
            data: $("#worksForm").serialize(),
            success: function (responseText) {


                if (responseText === "done") {

                    swal("Success", "Data saved Successfully", "success");
                    $("#worksModel").modal('toggle');
                } else {

                    swal("Error", "Data saved Successfully", "error");

                }

            }

        });

    } else {

        swal("Fill required fields");

    }
});


//Gen Order no for sl works


$("#account").change(function () {

    var select = $("#account").find(":selected").text();

    if (select === "Sri_Lanka") {

        $.ajax({

            method: "POST",
            url: "genOrderNo",
            success: function (responseText) {

                $("#orderno").val(responseText)


            }

        })

    } else {

        $("#orderno").val("")


    }

});

//desable modoficaation for new ordrs

$("#type").change(function () {

    var select = $("#type").find(":selected").text();

    if (select === "New Order") {

        $("#updateno").prop("readonly", true);

    } else {

        $("#updateno").prop("readonly", false);


    }

})