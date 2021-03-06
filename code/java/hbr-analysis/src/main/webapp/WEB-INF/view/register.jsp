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
    
    <style type="text/css">
      .group-radio {
        margin-right: 20px;
      }
    </style>
  </head>
<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">IN+</h1>
            </div>
            <h3>欢迎进入心率分析系统</h3>
            
            <p>登录</p>
            <form class="m-t" role="form" action="login.html">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="姓名" required="">
                </div>
                <div class="form-group" style="text-align: left;">
                    <label class="group-radio">
                      <input type="radio" name="gender" id="gengder-m" /> 男
                    </label>
                    <label class="group-radio">
                      <input type="radio" name="gender" id="gengder-f" /> 女
                    </label>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="确认密码" required="">
                </div>
                <div class="form-group">
                  <div class="checkbox i-checks"><label> <input type="checkbox"><i></i> 同意<a href="#">心率分析系统使用协议</a> </label></div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">注册</button>

                <p class="text-muted text-center"><small>已经有账户?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="/hbr/home/?location=login">登录</a>
            </form>
            <p class="m-t"> <small>XIANG © 2016</small> </p>
        </div>
    </div>
    <!-- Mainly scripts -->
    <script src="<%=request.getContextPath()%>/static/js/jquery-2.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>

</body>
</html>