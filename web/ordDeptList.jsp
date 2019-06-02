<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/17
  Time: 20:23
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
            <form action="ordDeptSelectServlet" method="post">
                <input type="text" name="name" placeholder="请输入要查找的部门名称" class="loginname">
                <input type="submit" value="搜索" class="submit">
            </form>
        </center>
    </div>
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th width="80px">ID</th>
                <th width="80px">部门名称</th>
                <th width="80px">部门描述</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <tr>
                        <%--<td><input type="text" value="${u.id}" name="id" readonly="readonly" size="5"></td>--%>
                        <%--<td><input type="text" value="${u.name}" name="name" size="10"></td>--%>
                        <%--<td><input type="text" value="${u.remark}" name="remark" size="70"></td>--%>
                    <td align="center" valign="center">${u.id}</td>
                    <td align="center" valign="center">${u.name}</td>
                    <td align="center" valign="center">${u.remark}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>

