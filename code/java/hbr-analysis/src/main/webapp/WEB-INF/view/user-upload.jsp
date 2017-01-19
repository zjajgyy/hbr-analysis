<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<!-- saved from url=(0063)http://webapplayers.com/inspinia_admin-v2.6.2.1/graph_flot.html -->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>上传心率数据 | 心率分析系统</title>
      <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/static/css/font-awesome.css" rel="stylesheet">

      <link href="<%=request.getContextPath()%>/static/css/animate.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet">
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
                <li class="active">
                  <a href="#">
                      <i class="fa fa-cloud-upload"></i>
                      <span class="nav-label">上传心率文件</span>
                  </a>
                </li>
                <li>
                  <a href="/hbr/home/?location=user-report">
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
                <h2>上传心率数据</h2>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <iframe name="upload_iframe" class="hide"></iframe>
        <form id="upload-form" action="/hbr/user/upload/${username}" method="post" enctype="multipart/form-data" target="upload_iframe" onsubmit="submitFile();">
            <div id="upload-progress" class="progress progress-mini">
                <div style="width: 0;" class="progress-bar progress-bar-success"></div>
            </div>

            <div id="tips"></div>

            <div class="wrapper wrapper-content animated fadeInRight" style="text-align: center; margin-top: 100px;">
                <label title="Upload image file" for="input-file" class="btn btn-default" style="width: 200px;">
                    <input type="file" name="file" id="input-file" class="hide">
                    <span id="file-path">选择文件</span>
                </label>
                <button id="upload-btn" class="btn btn-primary" type="submit">
                    <i class="fa fa-cloud-upload"></i> 上传心率数据
                </button>
            </div>
        </form>

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

<script type="text/javascript">

  var finished = true;

  var $input = $("#input-file");
//  $inputImage.bind("click", function(e) {
//    $("#file").click();
//  });
  if (window.FileReader) {
      $input.change(function() {
          var files = this.files;

          if (!files.length) {
              return;
          }
          finished = false;
          $("#file-path").html(files[0].name);
      });
  } else {
      $input.addClass("hide");
  }
  
  function submitFile() {

      finished = false;
      $("#upload-progress").show();
      $("#upload-btn").attr("disabled", "disabled");

      setInterval(function () {

          if (finished) {
              return ;
          }

          $.ajax({
              url: "/hbr/test/uploadstatus",
              type: "POST",
              dataType: "JSON",
              success: function (res) {

                  var rate = res.bytesRead/res.contentLength;
                  if (rate >= 1) {

                      finished = true;

                      $("#upload-progress").hide();
                      $("#upload-progress div").css("width", "0");
                      $("#upload-btn").removeAttr("disabled");

                      alertMsg("上传成功！", null, function () {
                          location.href = "/hbr/home/?location=user-report";
                      });

                      return;
                  }
                  console.log(res);
                  $("#upload-progress div").css("width", rate * 100 + "%");
              },
              error: function (err) {
                  console.log(err);
              },
              complete: function () {

              }
          });
      }, 1000);
  }


</script>
</body>
</html>