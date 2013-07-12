$(function() {

    var w = $(window);
    var oldH = 0;
    var oldW = 0;
    var bgBox = $('#bg-box');
    var rootBox = $('#root-box');
    var siteContent = $('#site-content');
    var siteHeader = $('#site-header');

    function grow() {
        var newH = w.height();
        var newW = w.width();

        if (newH != oldH || newW != oldW) {
          var h = newH < rootBox.height() ? rootBox.height() : newH;
          bgBox.css({position: 'absolute', height: h, width: newW});
          siteContent.css({height: h - siteHeader.height()});
          oldH = h;
          oldW = newW;
        }
    }

    w.resize(function() {
      setTimeout(grow, 500);
    });

    grow();
})
