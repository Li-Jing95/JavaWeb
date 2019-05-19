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
    <meta charset="utf-8"/>
    <title>普通用户登录</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<img class="bgone" src="img/1.jpg"/>
<img class="pic" src="img/a.png"/>

<div class="table">
    <form action="ordLoginServlet" method="post">
        <div class="wel">企业人事管理系统登录</div>
        <div class="wel1">QI YE REN SHI GUAN LI XI TONG DENG LU</div>
        <div class="user">
            <div id="yonghu"><img src="img/yhm.png"/>
            </div>
            <input type="text" name="loginname" placeholder="用户名"/>
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
