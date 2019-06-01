<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/17
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<%@ include file="public.jsp" %>
<div id="section">
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th>性别</th>
                <th>比例(百分比)</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <tr>
                    <td><input type="text" value="${u.sex}" name="sex" readonly="readonly" size="5"></td>
                    <td><input type="text" value="${u.count}" name="count" readonly="readonly" size="10"></td>
                </tr>
            </c:forEach>
        </table>
    </center>

</div>
</body>
</html>
