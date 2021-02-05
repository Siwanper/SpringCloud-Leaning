<%--
  Created by IntelliJ IDEA.
  User: chenjie
  Date: 2020/10/21
  Time: 11:18 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <button onclick = "login()" style = "font-size: 36px; margin-top: 40px; margin-left: 40px">邀请好友</button>
    <script type="text/javascript">
        function login() {
            loginSucceed();
        }
        function loginSucceed() {
            var order_id = "1";
            window.webkit.messageHandlers.shareMessage.postMessage(order_id);
        }
    </script>
</body>
</html>
