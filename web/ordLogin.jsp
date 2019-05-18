<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/17
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
    <div class="wrapper">
        <form action="ordLoginServlet" method="post" class="form-signin">
            <h1>企业人事管理系统</h1>
            <h3>请登录</h3>
            <table border="0">
                <tr>
                    <td>用户名:</td>
                    <td><input type="text" class="form-control"name="loginname"></td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                    <td><input type="password" class="form-control" name="password"></td>
                </tr>
            </table>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" class="button" value="登录">
        </form>
    </div>
</center>
</body>
</html>
