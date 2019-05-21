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
<head>
    <link href="css/head.css" rel="stylesheet" type="text/css">
    <link href="css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="public.jsp" %>
<div id="section">
    <!--搜索栏-->
    <div class="select">
        <center>
            <br><br>
            <form action="localPaySelectServlet" method="post">
                <input type="text" name="name" placeholder="请输入要查找的部门薪资" class="loginname">
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
                <th>部门名称</th>
                <th>部门描述</th>
                <th>基本薪资</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <form action="localPayUpdateServlet" method="post">
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="5"></td>
                        <td><input type="text" value="${u.name}" name="name" size="10"></td>
                        <td><input type="text" value="${u.remark}" name="remark" size="70"></td>
                        <td><input type="text" value="${u.localpay}" name="localpay" size="10"></td>
                        <td>
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
