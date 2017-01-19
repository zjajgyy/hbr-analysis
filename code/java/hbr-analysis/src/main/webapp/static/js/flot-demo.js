
var q;
var globalData = new Queue(5000);
initGraph();

function initGraph() {

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
        // if (!q.isEmpty()) {
        //
        // }
        series[0].data = fetchData();
        if (series[0].data.length > 0) {
            plot.setData(series);
            plot.draw();
        }
    }, 5);

}




