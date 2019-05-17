<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/4/6
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h5>${xiaoxi}</h5>
<%@include file="public.jsp"%>
<div id="section">
    <!--搜索栏-->
    <div class="select">
        <center>
            <br><br>
            <form action="selectServlet" method="post">
                <input type="text" name="loginname" placeholder="请输入要查找的登录名" class="loginname">
                <input type="submit" value="搜索" class="submit">
            </form>
        </center>
    </div>
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th>ID</th>
                <th>登录名</th>
                <th>密码</th>
                <th>注册日期</th>
                <th>用户名</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <form action="updateServlet" method="post">
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly"></td>
                        <td><input type="text" value="${u.loginname}" name="loginname"></td>
                        <td><input type="text" value="${u.password}" name="password"></td>
                        <td><input type="text" value="${u.createdate}" name="createdate"></td>
                        <td><input type="text" value="${u.username}" name="username"></td>
                        <td>
                            <a href="deleteServlet?id=${u.id}">删除</a>
                            <input type="submit" value="更新"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
