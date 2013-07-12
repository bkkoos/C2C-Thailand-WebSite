$(function(){

    /* init Isotope */
  var box = $("#calm-3-mins");
  box.isotope({
    itemSelector: ".c-3-mins-item",
    masonry: {
      columnWidth: 20
    }
  });

  var player;

  var fancybox = $(".fancybox").fancybox({
    openEffect: "elastic",
    closeEffect: "elastic",
    autoSize: true,
    scrolling: "no",
    afterShow: function() {
      var id = $(this).attr("href") + " .flowplayer"
      player = flowplayer($(id));
      player.play();
    },
    afterClose: function() {
      player.stop();
    }
  });

});

