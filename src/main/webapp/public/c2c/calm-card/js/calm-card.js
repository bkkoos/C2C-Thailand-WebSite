$(function($) {

    function displayCard() {
        var current = $(".card:visible"), id, card, fade;
        if (current.length) {
            id = $(this).attr('href');
            card = $(id);
        } else {
            card = $(".card:hidden:first");
            id = "#" + card.attr("id");
        }
        var img = $(id + "-img");
        var currentImg =  $("#" + current.attr("id") + "-img");
        function fadeIn() {
            img.fadeIn("slow");
            card.fadeIn("slow");
        }

        if (current.length) {
            currentImg.fadeOut("slow", fadeIn);
            current.fadeOut("slow");
        } else {
            fadeIn();
        }

    };

    $(".slide").click(displayCard);

    var carouselBox = $("#carousel-box");
    var carousel = $("#carousel");
    var auto = { enabled: true, direction:"next", interval: 3000 };
    var autoDisable = { enabled: false };

    carousel.rcarousel({
        width: carouselBox.width(),
        height: 120,
        visible: 4,
        step: 1,
        orientation: "vertical",
        margin: 0,
        auto: auto
    })

    $(window).resize(function() {
        carousel.rcarousel({ auto: autoDisable, width: carouselBox.width() });
        setTimeout( function() {carousel.rcarousel({auto: auto})}, 2000);
    })

    displayCard();
});
