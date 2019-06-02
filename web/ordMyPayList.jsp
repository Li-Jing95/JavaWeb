<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/19
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%@ include file="ordinary.jsp" %>
<div id="section">
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
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th width="80px">ID</th>
                <th width="80px">姓名</th>
                <th width="80px">部门</th>
                <th width="80px">岗位</th>
                <th width="80px">月份</th>
                <th width="80px">应发工资</th>
                <th width="80px">五险一金</th>
                <th width="80px">税（3%）</th>
                <th width="80px">实发工资</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <tr>
                        <%--<td><input type="text" value="${u.id}" name="id" readonly="readonly" size="5"></td>--%>
                        <%--<td><input type="text" value="${u.name}" name="name" size="10"></td>--%>
                        <%--<td><input type="text" value="${u.dept}" name="remark" size="10"></td>--%>
                        <%--<td><input type="text" value="${u.job}" name="localpay" size="10"></td>--%>
                        <%--<td><input type="text" value="${u.month}" name="localpay" size="10"></td>--%>
                        <%--<td><input type="text" value="${u.sum}" name="localpay" size="10"></td>--%>
                        <%--<td><input type="text" value="${u.wuxian}" name="localpay" size="10"></td>--%>
                        <%--<td><input type="text" value="${u.shuihou}" name="localpay" size="10"></td>--%>
                        <%--<td><input type="text" value="${u.realpay}" name="localpay" size="10"></td>--%>
                    <td align="center" valign="center">${u.id}</td>
                    <td align="center" valign="center">${u.name}</td>
                    <td align="center" valign="center">${u.dept}</td>
                    <td align="center" valign="center">${u.job}</td>
                    <td align="center" valign="center">${u.month}</td>
                    <td align="center" valign="center">${u.sum}</td>
                    <td align="center" valign="center">${u.wuxian}</td>
                    <td align="center" valign="center">${u.shuihou}</td>
                    <td align="center" valign="center">${u.realpay}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>

