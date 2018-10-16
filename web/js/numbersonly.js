$('input[type=tel]').keypress(function (e) {

    this.value = this.value.replace(/[^0-9]/g, '');


});


$(document).ready(function () {

    $('.spinnumber').keypress(function (e) {


        // Allow: backspace, delete, tab, escape, enter, ctrl+A and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
            // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) ||
            // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
            // let it happen, don't do anything
            return;
        }

        var charValue = String.fromCharCode(e.keyCode)
            , valid = /^[0-9]+$/.test(charValue);

        if (!valid) {
            e.preventDefault();
        }


    });

});