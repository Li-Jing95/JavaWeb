<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/4/5
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8"/>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>

<body>
<img class="bgone" src="img/1.jpg"/>
<img class="pic" src="img/a.png"/>

<div class="table">
    <form action="loginServlet" method="post">
        <div class="wel">企业人事管理系统登录</div>
        <div class="wel1">QI YE REN SHI GUAN LI XI TONG DENG LU</div>
        <div class="user">
            <div id="yonghu"><img src="img/yhm.png"/>
            </div>
            <input type="text" name="loginname" placeholder="管理员账号"/>
        </div>
        <div class="password">
            <div id="yonghuhu"><img src="img/mm.png"/></div>
            <input type="password" name="password" placeholder="密码"/>
        </div>
        <input class="btn" type="submit" value="登录"/>
    </form>
</div>


</body>
</html>