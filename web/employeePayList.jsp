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
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th>工号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>部门</th>
                <th>职位</th>
                <th>基本薪资</th>
                <th>岗位薪资</th>
                <th>应发薪资</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <tr>
                    <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="3"></td>
                    <td><input type="text" value="${u.name}" name="name" readonly="readonly" size="3"></td>
                    <td><input type="text" value="${u.sex}" name="sex" readonly="readonly" size="3"></td>
                    <td><input type="text" value="${u.tel}" name="tel" readonly="readonly" size="12"></td>
                    <td><input type="text" value="${u.email}" name="email" readonly="readonly" size="12"></td>
                    <td><input type="text" value="${u.dept}" name="dept" readonly="readonly" size="7"></td>
                    <td><input type="text" value="${u.job}" name="job" readonly="readonly" size="7"></td>
                    <td><input type="text" value="${u.localpay}" name="localpay" readonly="readonly" size="3"></td>
                    <td><input type="text" value="${u.jobpay}" name="jobpay" readonly="readonly" size="3"></td>
                    <td><input type="text" value="${u.sum}" name="sum" readonly="readonly" size="3"></td>
                    <td>
                        <a href="employeePayChangeByIdServlet?id=${u.id}">查看实发薪资</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
