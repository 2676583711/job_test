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
                document.form.action = "/login.jsp";
        }
    </script>
</head>
<body>

<h1>注册 </h1>
<br/>
<br/>
<form action="/user/register" method="post">
    <b style="color: red;">${message}</b><br/>
    用户名：<input type="text" name="username"/> <br/>
    密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"/> <br/>
    邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="email" name="email"/> <br/>
    性&nbsp;&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="sex" value="男" checked="checked"/>男
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="sex" value="女"/>女 <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="提交">
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/user/login"><input type="button" value="去登录"  /></a>
</form>
</body>
</html>
