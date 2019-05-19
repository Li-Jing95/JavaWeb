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

    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th>编号</th>
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
            </tr>
            <c:forEach var="u" items="${findall}">
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="3"></td>
                        <td><input type="text" value="${u.name}" name="name" readonly="readonly" size="1"></td>
                        <td><input type="text" value="${u.sex}" name="sex" readonly="readonly" size="1"></td>
                        <td><input type="text" value="${u.nation}" name="nation" readonly="readonly" size="1"></td>
                        <td><input type="text" value="${u.polic}" name="polic" readonly="readonly" size="1"></td>
                        <td><input type="text" value="${u.born}" name="born" readonly="readonly" size="5"></td>
                        <td><input type="text" value="${u.tel}" name="tel" readonly="readonly" size="8"></td>
                        <td><input type="text" value="${u.email}" name="email" readonly="readonly" size="12"></td>
                        <td><input type="text" value="${u.education}" name="education" readonly="readonly" size="2">
                        </td>
                        <td><input type="text" value="${u.card_id}" name="card_id" readonly="readonly" size="12"></td>
                        <td><input type="text" value="${u.dept}" name="dept" readonly="readonly" size="4"></td>
                        <td><input type="text" value="${u.job}" name="job" readonly="readonly" size="6"></td>
                        <td><input type="text" value="${u.createdate}" name="createdate" readonly="readonly" size="12">
                        </td>
                    </tr>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
