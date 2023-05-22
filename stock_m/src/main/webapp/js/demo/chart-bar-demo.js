   
        function search() {
        var start_date = document.getElementById('start-date-input').value;
        console.log(start_date);
        var end_date = document.getElementById('end-date-input').value;
        console.log(end_date);
    //window.location.href = `./finance/filtered_data?start_date=${start_date}&end_date=${end_date}`;}
        showSaledResult(start_date, end_date);
        }

    
   

    

   

        function resetSearch(){location.assign("${pageContext.request.contextPath}/finance/orders")};

        

        $(function(){$("input[type='radio'][name='date']").on("change", function() {
            var dateRange = $(this).val();
            var startDate = "";
            var endDate = "";

            // dateRange에 따라 startDate와 endDate값을 설정합니다.
            switch (dateRange) {
                case "today":
                    startDate = new Date();
                    endDate = new Date();
                    break;
                case "1month":
                    startDate = new Date();
                    startDate.setMonth(startDate.getMonth() - 1);
                    endDate = new Date();
                    break;
                case "3month":
                    startDate = new Date();
                    startDate.setMonth(startDate.getMonth() - 3);
                    endDate = new Date();
                    break;
                case "1year":
                    startDate = new Date();
                    startDate.setFullYear(startDate.getFullYear() - 1);
                    endDate = new Date();
                    break;
            }

            var startYear = startDate.getFullYear();
            var startMonth = startDate.getMonth() + 1 < 10 ? "0" + (startDate.getMonth() + 1) : startDate.getMonth() + 1;
            var startDateNum = startDate.getDate() < 10 ? "0" + startDate.getDate() : startDate.getDate();
            var endYear = endDate.getFullYear();
            var endMonth = endDate.getMonth() + 1 < 10 ? "0" + (endDate.getMonth() + 1) : endDate.getMonth() + 1;
            var endDateNum = endDate.getDate() < 10 ? "0" + endDate.getDate() : endDate.getDate();

            var startDateStr = startYear + "-" + startMonth + "-" + startDateNum;
            var endDateStr = endYear + "-" + endMonth + "-" + endDateNum;

            showSaledResult(startDateStr, endDateStr);
        });
        });

        function showSaledResult(start, end) {
			$.ajax({
            url: "/company/getsdate",
            data: {
                "start-date": start,
                "end-date": end},
                type: "GET",
            }).done(function(response) {
			    	 var wholeData = response;
			    	 updateChart(wholeData);
			    	 
			    	});
             
            
       
        }

       -
        //$("#saled").empty();
        //$("#saled").append(table_data);
        

    
    
// Set new default font family and font color to mimic Bootstrap's default styling
//Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
//Chart.defaults.global.defaultFontColor = '#858796';

function number_format(number, decimals, dec_point, thousands_sep) {
  // *     example: number_format(1234.56, 2, ',', ' ');
  // *     return: '1 234,56'
  number = (number + '').replace(',', '').replace(' ', '');
  var n = !isFinite(+number) ? 0 : +number,
    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
    s = '',
    toFixedFix = function(n, prec) {
      var k = Math.pow(10, prec);
      return '' + Math.round(n * k) / k;
    };
  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
  if (s[0].length > 3) {
    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
  }
  if ((s[1] || '').length < prec) {
    s[1] = s[1] || '';
    s[1] += new Array(prec - s[1].length + 1).join('0');
  }
  return s.join(dec);
}

// Bar Chart Example
//var= ${}
function updateChart(wholeData) {
  var ctx = document.getElementById('myChart');
  var months = Object.keys(wholeData.totalData);
//var ctx = document.getElementById("myBarChart");
//var sellData = document.getElementById("totalselllist").value;
//var purchasesData = [5312, 6251, 7841];
//var revenueData = [6251, 7841, 9821];
console.log(wholeData);
console.log(wholeData.totalData);
console.log(wholeData.buyData);
console.log(wholeData.filteredData);
console.log(months);
var myBarChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels:months,
    datasets: [{
      label: "sell",
      backgroundColor: "#4e73df",
      hoverBackgroundColor: "#2e59d9",
      borderColor: "#4e73df",
      data: Object.values(wholeData.filteredData),
    },
    {
      label: "buy",
      backgroundColor: "#4e73df",
      hoverBackgroundColor: "#2e59d9",
      borderColor: "#4e73df",
      data:  Object.values(wholeData.buyData),
    },
    {
      label: "profit",
      backgroundColor: "#4e73df",
      hoverBackgroundColor: "#2e59d9",
      borderColor: "#4e73df",
      data:  Object.values(wholeData.totalData),
    }],
  },
  options: {
    maintainAspectRatio: false,
    layout: { 
      padding: {
        left: 10,
        right: 25,
        top: 25,
        bottom: 0
      }
    },
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false,
          drawBorder: false
        },
        ticks: {
          maxTicksLimit: 6
        },
        maxBarThickness: 25,
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 15000,
          maxTicksLimit: 5,
          padding: 10,
          // Include a dollar sign in the ticks
          callback: function(value, index, values) {
            return '$' + number_format(value);
          }
        },
        gridLines: {
          color: "rgb(234, 236, 244)",
          zeroLineColor: "rgb(234, 236, 244)",
          drawBorder: false,
          borderDash: [2],
          zeroLineBorderDash: [2]
        }
      }],
    },
    legend: {
      display: false
    },
    tooltips: {
      titleMarginBottom: 10,
      titleFontColor: '#6e707e',
      titleFontSize: 14,
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
      callbacks: {
        label: function(tooltipItem, chart) {
          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
          return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
        }
      }
    },
  }
});
}