<%@ page import="java.net.URLDecoder" %><%--
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
        function add(){
            document.getElementById('form').action = "/user/add";;
            document.getElementById("form").submit();
        }

        function user_delete() {
            document.getElementById('form').action = "/user/delete";;
            document.getElementById("form").submit();
        }

        function update() {
            document.getElementById('form').action = "/user/update";;
            document.getElementById("form").submit();
        }

        function query() {
            document.getElementById('form').action = "/user/query";;
            document.getElementById("form").submit();
        }

        /*
                if (document.form.add.checked == true) {
                }

                if (document.form.delete.checked == true) {
                }

                if (document.form.update.checked == true) {
                }
                if (document.form.update.checked == true) {
                }
         */

    </script>
</head>
<body>

<h1>首页面</h1>
<br/>

<b style="color: brown;">${requestScope.token}
    <%
        Cookie cookie = null;
        Cookie[] cookies = null;
        // 获取cookies的数据,是一个数组
        cookies = request.getCookies();
        if( cookies != null ){
            out.println("<h2> 查找 Cookie 名与值</h2>");
            for (int i = 0; i < cookies.length; i++){
                cookie = cookies[i];

                out.print("参数名 : " + cookie.getName());
                out.print("<br>");
                out.print("参数值: " + URLDecoder.decode(cookie.getValue(), "utf-8") +" <br>");
                out.print("------------------------------------<br>");
            }
        }else{
            out.println("<h2>没有发现 Cookie</h2>");
        }
    %>

</b>

<br/>

<form action="" name="form">
    <b style="color: red;">${message}</b>
    <br/>
    用户名：<input type="text" name="username"/> <br/>
    密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"/> <br/>
    邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="email" name="email"/> <br/>
    性&nbsp;&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="sex" value="男" checked="checked"/>男
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="sex" value="女"/>女 <br/>
    &nbsp;&nbsp;
    <input type="submit" value="添加" name="add" onclick="form.action='/user/add'">
    &nbsp;&nbsp;
    <input type="submit" value="删除" name="delete" onclick="form.action='/user/delete'">
    &nbsp;&nbsp;
    <input type="submit" value="修改" name="update" onclick="form.action='/user/update'">
    &nbsp;&nbsp;
    <input type="submit" value="查询" name="query" onclick="form.action='/user/query'">

    <br/><br/>
    <b style="color: cadetblue;">${user}</b>


</form>
</body>
</html>
