<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查看健康报告 | 心率分析系统</title>
      <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/static/css/font-awesome.css" rel="stylesheet">

      <link href="<%=request.getContextPath()%>/static/css/animate.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet">
    
    <style type="text/css">
    
      
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
                <li>
                  <a href="/hbr/home/?location=user">
                      <i class="fa fa-cloud-upload"></i>
                      <span class="nav-label">上传心率文件</span>
                  </a>
                </li>
                <li class="active">
                  <a href="#">
                      <i class="fa fa-pie-chart"></i>
                      <span class="nav-label">查看健康报告</span>
                  </a>
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
                <h2>查看健康报告</h2>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">

          <span id="tip" class="label lable-info">报告生成中，请稍候...</span>

          <div id="sd-info" style="display: none;">
              <div>
                  <label>指标:</label>
              </div>

              <div class="row">
                  <div class="col-lg-3">
                      <div class="widget style1 lazur-bg">
                          <div class="row">
                              <div class="col-xs-4">
                                  <i class="fa fa-stethoscope fa-5x"></i>
                              </div>
                              <div class="col-xs-8 text-right">
                                  <span> SD1 </span>
                                  <h2 id="data-sd1" class="font-bold">0</h2>
                              </div>
                          </div>
                      </div>
                  </div>
                  <div class="col-lg-3">
                      <div class="widget style1 lazur-bg">
                          <div class="row">
                              <div class="col-xs-4">
                                  <i class="fa fa-stethoscope fa-5x"></i>
                              </div>
                              <div class="col-xs-8 text-right">
                                  <span> SD2 </span>
                                  <h2 id="data-sd2" class="font-bold">0</h2>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>

              <div>
                  <label>健康状况:</label>
              </div>

              <div class="row">
                  <div class="col-lg-6">
                      <div id="heath-span" class="widget navy-bg p-lg text-center">
                          <div class="m-b-md">
                              <i class="fa fa-shield fa-4x"></i>
                              <h1 id="heath-status" class="m-xs">良好</h1>
                              <h3 class="font-bold no-margins"></h3>
                              <small id="heath-info">您的身体素质已经能跟健身教练相比了.</small>
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

<script type="text/javascript">

    var username = "${username}";

    var healths = {
        "unhealthy": {
            "status": "极差",
            "info": "您的身体素质极低，请一定要抽时间锻炼.",
            "classes": "widget bg-danger p-lg text-center"
        },
        "healthy1": {
            "status": "较好",
            "info": "您的身体素质不错，保持锻炼的习惯，你可以做的更好.",
            "classes": "widget navy-bg p-lg text-center"
        },
        "healthy": {
            "status": "非常好",
            "info": "您的身体素质已经能跟健身教练相比了.",
            "classes": "widget bg-success p-lg text-center"
        }
    };

    var canFetch = true;

    setInterval(function () {

        if (canFetch) {

            canFetch = false;

            $.ajax({
                url: "/hbr/result/getuserresult",
                type: "GET",
                dataType: "JSON",
                data: {
                    username: username
                },
                success: function (res) {

                    if (res != null && res.length > 0) {

                        console.log(res);
                        $("#tip").fadeOut();
                        $("#sd-info").fadeIn();
                        canFetch = false;

                        $("#data-sd1").html(res[0].sd1.toFixed(4));
                        $("#data-sd2").html(res[0].sd2.toFixed(4));

                        var obj = healths[res[0].healthStatus];
                        $("#heath-span").attr("class", obj.classes);
                        $("#heath-status").html(obj.status);
                        $("#heath-info").html(obj.info);

                    } else {
                        canFetch = true;
                    }

                },
                error: function (err) {
                    console.log(err);
                },
                complete: function () {

                }
            });
        }

    }, 2000);


</script>
</body>
</html>