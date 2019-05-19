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
<%@ include file="public.jsp" %>
<div id="section">
    <!--搜索栏-->
    <div class="select">
        <center>
            <br><br>
            <form action="employeeSelectServlet" method="post">
                <input type="text" name="name" placeholder="请输入要查找的员工" class="loginname">
                <input type="submit" value="搜索" class="submit">
            </form>
        </center>
    </div>
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th>员工编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>民族</th>
                <th>政治面貌</th>
                <th>出生日期</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>学历</th>
                <th>身份证号</th>
                <th>部门</th>
                <th>岗位</th>
                <th>建档日期</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <%--<form action="employeeUpdateServlet" method="post">--%>
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="3"></td>
                        <td><input type="text" value="${u.name}" name="name" readonly="readonly" size="1"></td>
                        <td><input type="text" value="${u.sex}" name="sex" readonly="readonly" size="1"></td>
                        <td><input type="text" value="${u.nation}" name="nation" readonly="readonly" size="1"></td>
                        <td><input type="text" value="${u.polic}" name="polic" readonly="readonly" size="2"></td>
                        <td><input type="text" value="${u.born}" name="born" readonly="readonly" size="5"></td>
                        <td><input type="text" value="${u.tel}" name="tel" readonly="readonly" size="8"></td>
                        <td><input type="text" value="${u.email}" name="email" readonly="readonly" size="10"></td>
                        <td><input type="text" value="${u.education}" name="education" readonly="readonly" size="2">
                        </td>
                        <td><input type="text" value="${u.card_id}" name="card_id" readonly="readonly" size="12"></td>
                        <td><input type="text" value="${u.dept}" name="dept" readonly="readonly" size="3"></td>
                        <td><input type="text" value="${u.job}" name="job" readonly="readonly" size="5"></td>
                        <td><input type="text" value="${u.createdate}" readonly="readonly" name="createdate" size="8">
                        </td>
                        <td>
                            <a href="employeeDeleteServlet?id=${u.id}">删除</a>
                            <a href="employeeListByIdServlet?id=${u.id}">修改</a>
                                <%--<input type="submit" value="更新"/>--%>
                            <a href="employeeChangeJobServlet?id=${u.id}">调岗</a>
                            <a href="employeeAddOrdUserServlet?id=${u.id}">入库</a>
                        </td>
                    </tr>
                <%--</form>--%>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
