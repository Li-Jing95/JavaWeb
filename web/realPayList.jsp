<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/18
  Time: 20:40
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
            <form action="paySelectByMonthServlet" method="post">
                <input type="month" name="month" class="loginname">
                <input type="submit" value="搜索" class="submit">
            </form>
        </center>
    </div>
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th>工号</th>
                <th>姓名</th>
                <th>部门</th>
                <th>岗位</th>
                <th>月份</th>
                <th>应发工资</th>
                <th>五险一金</th>
                <th>税（3%）</th>
                <th>实发工资</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <tr>
                    <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="5"></td>
                    <td><input type="text" value="${u.name}" name="name" size="10"></td>
                    <td><input type="text" value="${u.dept}" name="remark" size="10"></td>
                    <td><input type="text" value="${u.job}" name="localpay" size="10"></td>
                    <td><input type="text" value="${u.month}" name="localpay" size="10"></td>
                    <td><input type="text" value="${u.sum}" name="localpay" size="10"></td>
                    <td><input type="text" value="${u.wuxian}" name="localpay" size="10"></td>
                    <td><input type="text" value="${u.shuihou}" name="localpay" size="10"></td>
                    <td><input type="text" value="${u.realpay}" name="localpay" size="10"></td>
                </tr>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
