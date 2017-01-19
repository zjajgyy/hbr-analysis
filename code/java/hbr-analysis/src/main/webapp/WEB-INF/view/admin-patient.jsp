<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0063)http://webapplayers.com/inspinia_admin-v2.6.2.1/graph_flot.html -->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>病人管理 | 心率分析系统</title>
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
                <li>
                  <a href="/hbr/home/?location=admin">
                      <i class="fa fa-cloud-upload"></i>
                      <span class="nav-label">医生管理</span>
                  </a>
                </li>
                <li class="active">
                  <a href="#">
                      <i class="fa fa-pie-chart"></i>
                      <span class="nav-label">病人管理</span>
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
                <h2>病人管理</h2>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
          <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <div class="row">
                              <div class="col-sm-4">
                                <div class="input-group">
                                  <input id="patient-name" type="text" placeholder="请输入病人姓名" class="input-sm form-control">
                                  <span class="input-group-btn">
                                    <button type="button" class="btn btn-sm btn-primary">查询</button>
                                  </span>
                                </div>

                              </div>
                              <div class="col-sm-2">
                                <button class="btn btn-sm btn-info">
                                  <strong>入住病人</strong>
                                </button>
                              </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>床号</th>
                                        <th>主治医师</th>
                                        <th>标识</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="patient-list">

                                    </tbody>
                                </table>
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

<script type="text/javascript">


    ///hbr/patient/getall
    ///hbr/patient/add



    
    function getList() {

        var patientName = $("#patient-name").val();

        $.ajax({
            url: "/hbr/patient/getall",
            type: "GET",
            dataType: "JSON",
            data: {
                name: patientName
            },
            success: function (res) {

                if(typeof res == 'object' && res.code == 200) {
                    for (var i=0; i<res.data.length; ++i) {
                        var obj = res.data[i];
                        var doctorTemplate = '<tr id="patient-{id}" > <td>{no}</td> <td>{name}</td> <td>{gender}</td> <td>{position}</td> <td>{doctor}</td> <td>{flag}</td> <td class="text-navy">{status}</td> <td> <button class="btn btn-xs btn-warning"> <strong>修改信息</strong> </button> <button class="btn btn-xs btn-danger"> <strong>出院</strong> </button> </td> </tr>';
                        doctorTemplate = doctorTemplate.format({
                            no: i+1,
                            id: obj.id,
                            name: obj.name,
                            flag: obj.heartIdentifier == null ? "" : obj.heartIdentifier,
                            gender: obj.gender == 'M' ? "男" : "女",
                            position: obj.position,
                            status: obj.treatStatus,
                            doctor: obj.doctorLoginName
                        });
                        $("#patient-list").append(doctorTemplate);
                    }

                }


            },
            error: function (error) {

            },
            complete: function () {

            }
        });
    }






    getList();
    

</script>
</body>
</html>