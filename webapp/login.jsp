<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/7/4
  Time: 下午9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页面</title>

    <script language="javascript">
        function check() {
            window.location.href = '/register.jsp'
        }
    </script>
</head>
<body>

<h1>登录 </h1>
<br/>
<br/>
<%--method="post"--%>
<form action="/user/login" >
    <b style="color: red;">${message}</b><br/>
    用户名：<input type="text" name="username"/>
    <br/>
    密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"/>
    <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="登录">
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="注册" onclick="check()">
</form>
</body>
</html>
