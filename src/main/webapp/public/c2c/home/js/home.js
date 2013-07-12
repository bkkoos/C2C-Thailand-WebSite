$(function() {
  $("#calm-card .carousel").rcarousel({
      width: 240,
      height: 120,
      visible: 1,
      step: 1,
      orientation: "horizontal",
      margin: 0,
      auto: { enabled: true, direction:"next", interval: 3500 }
  });

  $("#calm-3-mins .carousel").rcarousel({
      width: 280,
      height: 280,
      visible: 1,
      step: 1,
      orientation: "vertical",
      margin: 0,
      auto: { enabled: true, direction:"next", interval: 3000 }
  });

    /* init Isotope */
  var box = $("#present");
  box.isotope({
    itemSelector: ".isotope-item",
    masonry: {
      columnWidth: 100
    }
  });
});
