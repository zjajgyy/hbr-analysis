<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0058)http://webapplayers.com/inspinia_admin-v2.6.2.1/login.html -->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>心率分析系统 | 登录</title>
      <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/static/css/font-awesome.css" rel="stylesheet">

      <link href="<%=request.getContextPath()%>/static/css/animate.css" rel="stylesheet">
      <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet">
  </head>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">IN+</h1>
            </div>
            <h3>欢迎进入心率分析系统</h3>
            
            <p>登录</p>
            <form class="m-t" role="form" action="#">
                <div id="tips"></div>
                <div class="form-group">
                    <input id="username" type="text" class="form-control" placeholder="Username" required="">
                </div>
                <div class="form-group">
                    <input id="password" type="password" class="form-control" placeholder="Password" required="">
                </div>
                <button type="button" class="btn btn-primary block full-width m-b" onclick="login();">登录</button>
                <p class="text-muted text-center"><small>没有账户?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="/hbr/home/?location=register">创建普通账户</a>
            </form>
            <p class="m-t"> <small>XIANG © 2016</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="<%=request.getContextPath()%>/static/js/jquery-2.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>

    <script src="<%=request.getContextPath()%>/static/js/xiang.lib.js"></script>


<script type="text/javascript">
    
    
    function login() {
        var username = $("#username").val();
        var password = $("#password").val();

        $.ajax({
            url: "/hbr/user/login.do",
            type: "POST",
            dataType: "JSON",
            data: {
                username: username,
                password: password
            },
            success: function (res) {

                if(typeof res == 'object' && res.code == 200) {
                    location.href = res.target;
                } else {
                    alertMsg(res.msg);
                }

            },
            error: function (error) {

            },
            complete: function () {

            }
        });
    }



</script>


</body>
</html>