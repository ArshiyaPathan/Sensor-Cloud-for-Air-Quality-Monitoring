$(document).ready(function () {
$(".daterangepicker-fields").daterangepicker({
  forceUpdate: true,
  callback: function(startDate, endDate, period){
    var title = startDate.format('L') + ' – ' + endDate.format('L');
    $(this).val(title)
  }
});})
