String.prototype.format = function(args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if(args[key]!=undefined){
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        } else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    //var reg = new RegExp("({[" + i + "]})", "g");//这个在索引大于9时会有问题，谢谢何以笙箫的指出
                    var reg= new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
}

function alertMsg(msg, option, callback) {
    //<div id="alert" class="alert alert-success" role="alert">上传成功！</div>
    var ele = $(document.createElement("div"));
    ele.addClass("alert");

    if (option) {
        ele.addClass(option);
    } else {
        ele.addClass("alert-success");
    }

    ele.attr("role", "alert");
    ele.html(msg);
    $("#tips").html(ele);
    setTimeout(function () {
        ele.fadeOut();
        if (callback) {
            callback();
        }
    }, 2000);
}

var Queue = function(len) {
    this.maxSize = len;
    this.size = 0;
    this.data = [];

    this.clear = function () {
        this.data = [];
        this.size = 0;
    }

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