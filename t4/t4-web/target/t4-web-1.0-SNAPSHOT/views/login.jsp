<%--
  Created by IntelliJ IDEA.
  User: chenjie
  Date: 2020/10/21
  Time: 11:19 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/global.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/resource/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="login-window">
        <div class="input-group m-b-20">
            <span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
            <div class="fg-line">
                <input class="form-control" id="username"  type="text" placeholder="用户名" name="username" required autofocus/>
            </div>
        </div>
        <div class="input-group m-b-20">
            <span class="input-group-addon"><i class="zmdi zmdi-lock"></i></span>
            <div class="fg-line">
                <input class="form-control" id="password" type="password" placeholder="密码" name="password" required/>
            </div>
        </div>
        <div class="input-group m-b-20">
            <input id="remember" type="checkbox"><label class="remember-title">记住密码</label>
        </div>
        <a id="login-btn" class="waves-effect waves-button waves-float" href="javascript:;"><i
                class="zmdi zmdi-arrow-forward" style="font-size: 20px; color: #ffffff"></i></a>
    </div>
    <script type="text/javascript">

        Waves.displayEffect();

        $(".form-control").focus(function () {
            $(this).parent().addClass("fg-toggled");
        }).blur(function () {
            $(this).parent().removeClass("fg-toggled");
        });

        if($.cookie('loginCookie') != null && $.cookie('loginCookie') != 'null'){
            var loginCookies = $.cookie('loginCookie').split(',');
            $('#username').val(loginCookies[0]);
            $('#password').val(loginCookies[1]);
            $('#remember').attr('checked', loginCookies[2]);
        }

        $('#login-btn').click(function () {
            $.post(
                '${pageContext.request.contextPath}/login/signin',
                {
                    username: $('#username').val(),
                    password: $('#password').val(),
                    remember: $('#remember').is(':checked')
                },
                function (data) {
                    if (data.status == 0) {
                        $.alert(data.msg);
                    } else {
                        if (data.remember){
                            var loginCookie = $('#username').val() + ',' + $('#password').val() + ',' + $('#remember').is(':checked');
                            $.cookie('loginCookie', loginCookie, {expires : 7});
                        } else  {
                            $.cookie('loginCookie', null);
                        }
                        location.href = '${pageContext.request.contextPath}' + data.url;
                    }
                }
            );
        });

    </script>
</body>
</html>
