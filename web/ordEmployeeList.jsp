<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/17
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%@ include file="ordinary.jsp" %>
<div id="section">
    <!--搜索栏-->
    <div class="select">
        <center>
            <br><br>
            <form action="employeeSelectServlet" method="post">
                <input type="text" name="loginname" placeholder="请输入要查找的员工" class="loginname">
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
                <th>姓名</th>
                <th>性别</th>
                <th>民族</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>学历</th>
                <th>部门</th>
                <th>岗位</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="3"></td>
                        <td><input type="text" value="${u.name}" name="name" size="1"></td>
                        <td><input type="text" value="${u.sex}" name="sex" size="1"></td>
                        <td><input type="text" value="${u.nation}" name="nation" size="1"></td>
                        <td><input type="text" value="${u.tel}" name="tel" size="8"></td>
                        <td><input type="text" value="${u.email}" name="email" size="10"></td>
                        <td><input type="text" value="${u.education}" name="education" size="1"></td>
                        <td><input type="text" value="${u.dept}" name="dept" readonly="readonly" size="3"></td>
                        <td><input type="text" value="${u.job}" name="job" readonly="readonly" size="5"></td>
                    </tr>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
