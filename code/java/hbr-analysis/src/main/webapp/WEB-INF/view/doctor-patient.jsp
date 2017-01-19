<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>病人实时心率监控 | 心率分析系统</title>
      <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/static/css/font-awesome.css" rel="stylesheet">

      <link href="<%=request.getContextPath()%>/static/css/animate.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet">
    
    <style type="text/css">
      .user-info > span {
        width: 100px;
        font-size: 1.3em;
        display: inline-block;
      }
      
      .user-exponent > span {
        width: 200px !important;
      }
    </style>
    
  </head>

<body class="pace-done">
  <div class="pace  pace-inactive">
    <div class="pace-progress" data-progress-text="100%" data-progress="99" style="transform: translate3d(100%, 0px, 0px);">
      <div class="pace-progress-inner"></div>
    </div>
    <div class="pace-activity"></div>
  </div>
  
  <div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element" style="text-align: center;">
                      <span>
                        <img alt="image" class="img-circle" src="<%=request.getContextPath()%>/static/img/profile_small.jpg">
                      </span>
                      <a data-toggle="dropdown" class="dropdown-toggle" href="http://webapplayers.com/inspinia_admin-v2.6.2.1/graph_flot.html#">
                          <span class="clear">
                            <span class="block m-t-xs">
                              <strong class="font-bold">${name}</strong>
                            </span>
                          </span>
                      </a>
                    </div>
                    <div class="logo-element">IN+</div>
                </li>

            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg" style="min-height: 1295px;">
    <div class="row border-bottom">
    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
      <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#">
          <i class="fa fa-bars"></i>
      </a>
    </div>
    <ul class="nav navbar-top-links navbar-right">
        <li>
            <span class="m-r-sm text-muted welcome-message">${name}，欢迎进入心率分析系统~</span>
        </li>
        <li class="dropdown">
            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="http://webapplayers.com/inspinia_admin-v2.6.2.1/graph_flot.html#">
                <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="http://webapplayers.com/inspinia_admin-v2.6.2.1/mailbox.html">
                        <div>
                            <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="http://webapplayers.com/inspinia_admin-v2.6.2.1/profile.html">
                        <div>
                            <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                            <span class="pull-right text-muted small">12 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="http://webapplayers.com/inspinia_admin-v2.6.2.1/grid_options.html">
                        <div>
                            <i class="fa fa-upload fa-fw"></i> Server Rebooted
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <div class="text-center link-block">
                        <a href="http://webapplayers.com/inspinia_admin-v2.6.2.1/notifications.html">
                            <strong>See All Alerts</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </div>
                </li>
            </ul>
        </li>

        <li>
            <a href="/hbr/user/logout">
                <i class="fa fa-sign-out"></i> 退出
            </a>
        </li>
    </ul>
      </nav>
      </div>
      
      <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>病人实时心率监控</h2>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">

            <div id="tips"></div>

          <div class="row">
            <div class="col-lg-12">
              <div class="ibox float-e-margins">
                        <div class="ibox-title">
                          <div class="user-info">
                            <span>
                              <i class="fa fa-user"></i>&nbsp;&nbsp;
                              <span id="patient-name" class="text-navy">张三</span>
                            </span>

                            <span>
                              <span>性别：</span>
                              <span id="patient-gender">男</span>
                            </span>

                            <span>
                              <span>年龄：</span>
                              <span id="patient-age">20</span>
                            </span>
                          </div>
<!--
                          <div class="ibox-tools">
                              <a class="collapse-link">
                                  <i class="fa fa-chevron-up"></i>
                              </a>
                              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                  <i class="fa fa-wrench"></i>
                              </a>
                              <ul class="dropdown-menu dropdown-user">
                                  <li><a href="#">Config option 1</a>
                                  </li>
                                  <li><a href="#">Config option 2</a>
                                  </li>
                              </ul>
                              <a class="close-link">
                                  <i class="fa fa-times"></i>
                              </a>
                          </div>
-->
                        </div>
                        <div class="ibox-content" style="display: block;">
                          <div class="flot-chart" style="height: 400px;">
                            <div class="flot-chart-content" id="flot-line-chart-moving"></div>
                          </div>
                          <div class="user-info user-exponent text-center">
                            <span>
                              <span>SD1：</span>
                              <span id="patient-sd1" class="label label-warning">0</span>
                            </span>
                            <span>
                              <span>SD2：</span>
                              <span id="patient-sd2" class="label label-warning">0</span>
                            </span>
                            <span>
                              <span>健康状况：</span>
                              <span id="patient-status" class="label label-primary">健康</span>
                            </span>
                            <span>
                              <span>更新于：</span>
                              <span id="last-update">现在</span>
                            </span>
                          </div>
                        </div>
                    </div>
            
            </div>
          </div>
          
        </div>
        <div class="footer">
            <div class="pull-right">
                
            </div>
            <div>
                <strong>Copyright</strong> XIANG © 2016-2017
            </div>
        </div>
        </div>
        </div>



  <!-- Mainly scripts -->
  <script src="<%=request.getContextPath()%>/static/js/jquery-2.1.1.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/jquery.metisMenu.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/jquery.slimscroll.min.js"></script>

  <!-- Flot -->
  <script src="<%=request.getContextPath()%>/static/js/jquery.flot.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/jquery.flot.tooltip.min.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/jquery.flot.resize.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/jquery.flot.pie.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/jquery.flot.time.js"></script>

  <!-- Custom and plugin javascript -->
  <script src="<%=request.getContextPath()%>/static/js/inspinia.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/pace.min.js"></script>

  <script src="<%=request.getContextPath()%>/static/js/xiang.lib.js"></script>

  <!-- Flot demo data -->
  <script src="<%=request.getContextPath()%>/static/js/flot-demo.js"></script>



<script type="text/javascript">

    var doctorUsername = "${username}";

    var lastTimestamp = new Date().getTime();
    //var lastTimestamp = 1483973771000;

    var host = "";

    var canFetchHeartData = true;

    var currPatient = {};


    (function () {

        $.ajax({
            url: host+"/hbr/patient/getlistbydoctor",
            type: "POST",
            dataType: "JSON",
            data: {
                doctorUsername: doctorUsername
            },
            success: function (res) {

                for (var i=0; i < res.length; ++i) {
                    var obj = res[i];
                    var patientTemp = '<li id="patient-{id}" onclick="selectPatient({id}, \'{name}\', \'{flag}\', \'{gender}\', \'{position}\')"> <a href="#"> <i class="fa fa-user"></i> <span class="nav-label">{name}</span> </a> </li>';
                    patientTemp = patientTemp.format({
                        id: obj.id,
                        name: obj.name,
                        flag: obj.heartIdentifier,
                        gender: obj.gender == 'M' ? "男" : "女",
                        position: obj.position,
                        status: obj.treatStatus
                    });
                    $("#side-menu").append(patientTemp);

                    if(i==0) {
                        $("#patient-"+obj.id).click();
                    }
                }


            },
            error: function (error) {
                console.log(error);
            },
            complete: function () {

            }
        });
    })();


    setInterval(function() {

        if(!globalData.isFull() && canFetchHeartData) {

            $.ajax({
                url: "/hbr/result/getpatientfromhbase",
                type: "GET",
                dataType: "JSON",
                data: {
                    patientId: currPatient.id,
                    timestamp: lastTimestamp
                },
                beforeSend: function () {
                    canFetchHeartData = false;
                },
                success: function (res) {

                    for (var j = 0; j < res.length; ++j) {

                        if (res[j].timestamp > lastTimestamp) {
                            lastTimestamp = res[j].timestamp;
                        }

                        var arr = res[j].value.split(",");
                        if (!globalData.isFull()) {
                            for (var i = 0; i < arr.length; ++i) {
                                globalData.push(parseInt(arr[i]));
                            }
                        }
                    }
                    canFetchHeartData = true;
                },
                error: function (err) {
                    console.log(err);

                },
                complete: function () {

                }
            });
        }

    }, 2000);



    setInterval(function () {

        $.ajax({
            url: "/hbr/result/getpatientresultfrommysql",
            type: "GET",
            dataType: "JSON",
            data: {
                patientid: currPatient.id,
            },
            success: function (res) {
                if (res != null) {
                    $("#patient-sd1").html(res.sd1.toFixed(4));
                    $("#patient-sd2").html(res.sd2.toFixed(4));
                    $("#patient-status").html(res.healthStatus == "1"? "健康":"不健康");
                    $("#last-update").html(new Date(res.logTime).toLocaleTimeString());

                    if (res.healthStatus != "1") {
                        alertMsg("病人目前处于不健康状态，请及时进行诊断！", "alert-danger");
                    }
                }
            },
            error: function (err) {
                console.log(err);
            },
            complete: function () {

            }
        });

    }, 2000);

    
    function selectPatient(id, name, flag, gender, position) {
        currPatient = {
            "id": id,
            "name": name,
            "gender": gender,
            "flag": flag,
            "position": position
        };
        $("#side-menu li").removeClass("active");
        $("#side-menu li#patient-"+id).addClass("active");
        $("#patient-name").html(currPatient.name);
        $("#patient-gender").html(currPatient.gengder);
        $("#patient-age").html(20);
        q.clear();
        globalData.clear();
    }

    
</script>

</body>
</html>