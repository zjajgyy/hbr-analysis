var Queue = function(len) {
  this.maxSize = len;
  this.size = 0;
  this.data = [];
  
  
  this.isFull = function() {
    return this.size >= this.maxSize;
  }
  
  this.isEmpty = function() {
    return this.size <= 0;
  }
  
  
  this.pop = function() {
    if (!this.isEmpty()) {
      var front = this.data[0];
      this.data = this.data.slice(1);
      this.size --;
      return front;
    } else {
      return null;
    }
  }
  
  this.push = function(obj) {
    if(!this.isFull()) {
      this.data.push(obj);
      this.size ++;
      return this;
    } else {
      return null;
    }
  }
  
  
}


var q;
var globalData = new Queue(5000);

$(function() {

    var container = $("#flot-line-chart-moving");

    // Determine how many data points to keep based on the placeholder's initial size;
    // this gives us a nice high-res plot while avoiding more than one point per pixel.

    var maximum = container.outerWidth() / 2 || 300;
    q = new Queue(maximum);

    function fetchData() {
      
      if(!q.isEmpty() && !globalData.isEmpty()) {
        q.pop();
      }
      
      while(!q.isFull() && !globalData.isEmpty()) {
        q.push(globalData.pop());
        //q.push(1990);
      }

//        if (data.length) {
//            data = data.slice(1);
//        }
//
//        while (data.length < maximum) {
//            var previous = data.length ? data[data.length - 1] : 50;
//            var y = previous + Math.random() * 10 - 5;
//            data.push(y < 500 ? 500 : y > 5000 ? 5000 : y);
//        }
//
        // zip the generated y values with the x values
        var res = [];
        for (var i = 0; i < q.size; ++i) {
            res.push([i*2, q.data[i]])
        }

        return res;
    }

    series = [{
        data: fetchData(),
        lines: {
            fill: false
        }
    }];


    var plot = $.plot(container, series, {
        grid: {
            color: "#999999",
            tickColor: "#D4D4D4",
            borderWidth:0,
            minBorderMargin: 20,
            labelMargin: 10,
            backgroundColor: {
                colors: ["#ffffff", "#ffffff"]
            },
            margin: {
                top: 8,
                bottom: 20,
                left: 20
            },
            markings: function(axes) {
                var markings = [];
                var xaxis = axes.xaxis;
                for (var x = Math.floor(xaxis.min); x < xaxis.max; x += xaxis.tickSize * 2) {
                    markings.push({
                        xaxis: {
                            from: x,
                            to: x + xaxis.tickSize
                        },
                        color: "#fff"
                    });
                }
                return markings;
            }
        },
        colors: ["#1ab394"],
        xaxis: {
            tickFormatter: function() {
                return "";
            }
        },
        yaxis: {
            min: 0,
            max: 5000
        },
        legend: {
            show: true
        }
    });

    // Update the random dataset at 25FPS for a smoothly-animating chart
    setInterval(function() {
      series[0].data = fetchData();
      if (series[0].data.length > 0) {
        plot.setData(series);
        plot.draw();
      }
      
    }, 200);

});


setInterval(function() {
  
  var str = "1975,1981,2293,1996,1975,2038,1978,2283,2218,2283,2013,1975,1975,1975,1986,1975,1986,2013,2013,1975,2076,2189,2013,2283,2076,1986,1975,1978,1975,1975,2038,2013,2189,2293,2273,2076,1975,2039,2189,2038,2013,1978,2076,2128,2283,2038,2128,2218,1975,2128,2189,2039,2283,2283,1975,1975,1975,1975,2128,2283,1975,2013,2038,1981,2189,2039,2283,2218,2293,2038,2128,1975,2293,1975,1975,2293,1975,1978,1975,2273,2039,2293,2038,2218,2038,2013,2189,1996,1986,1981,2283,2189,2128,1975,1986,1975,1996,1975,2038,2243,1996,1975,2013,1975,1975,1975,1975,2218,2013,1975,2218,2038,1975,2293,2243,2039,2039,2039,1981,1996,2243,1996,2038,2189,1975,2273,2128,2293,1975,2218,2283,2273,1986,2283,1975,2273,2283,1975,1996,1975,2283,2039,2039,2039,2189,1975,1975,2076,1975,1975,1975,1975,2013,1978,1975,2038,1975,2039,1986,2273,1975,1978,2128,1975,2076,1981,2273,1975,1986,1975,2273,2039,2039,1978,2013,1986,2076,1975,2128,2293,1975,2218,1975,1975,2038,2243,2218,2128,1975,2038,2128,2038,2243,1975,1975,1975,2189,2293,1986,2038,1981,2189,2038,2076,2128,2038,1975,2293,1975,2128,2243,1975,1981,1996,2013,2189,1975,1996,2076,1981,2283,1975,1975,2243,2243,1975,2013,2189,2273,2293,2243,1986,2218,2273,2189,2293,2293,2283,1981,1978,1975,1975,2293,2273,1975,1975,2273,2243,2076,2128,1975,1981,2293,1996,1975,2038,1978,2283,2218,2283,2013,1975,1975,1975,1986,1975,1986,2013,2013,1975,2076,2189,2013,2283,2076,1986,1975,1978,1975,1975,2038,2013,2189,2293,2273,2076,1975,2039,2189,2038,2013,1978,2076,2128,2283,2038,2128,2218,1975,2128,2189,2039,2283,2283,1975,1975,1975,1975,2128,2283,1975,2013,2038,1981,2189,2039,2283,2218,2293,2038,2128,1975,2293,1975,1975,2293,1975,1978,1975,2273,2039,2293,2038,2218,2038,2013,2189,1996,1986,1981,2283,2189,2128,1975,1986,1975,1996,1975,2038,2243,1996,1975,2013,1975,1975,1975,1975,2218,2013,1975,2218,2038,1975,2293,2243,2039,2039,2039,1981,1996,2243,1996,2038,2189,1975,2273,2128,2293,1975,2218,2283,2273,1986,2283,1975,2273,2283,1975,1996,1975,2283,2039,2039,2039,2189,1975,1975,2076,1975,1975,1975,1975,2013,1978,1975,2038,1975,2039,1986,2273,1975,1978,2128,1975,2076,1981,2273,1975,1986,1975,2273,2039,2039,1978,2013,1986,2076,1975,2128,2293,1975,2218,1975,1975,2038,2243,2218,2128,1975,2038,2128,2038,2243,1975,1975,1975,2189,2293,1986,2038,1981,2189,2038,2076,2128,2038,1975,2293,1975,2128,2243,1975,1981,1996,2013,2189,1975,1996,2076,1981,2283,1975,1975,2243,2243,1975,2013,2189,2273,2293,2243,1986,2218,2273,2189,2293,2293,2283,1981,1978,1975,1975,2293,2273,1975,1975,2273,2243,2076,2128";
  
  var arr = str.split(",");
  if (!globalData.isFull()) {
    for(var i = 0; i < arr.length; ++i) {
      globalData.push(parseInt(arr[i]));
    }
  }
  
}, 100);




