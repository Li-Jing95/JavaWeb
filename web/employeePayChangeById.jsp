<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/18
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<%@ include file="public.jsp" %>
<div id="section">
    <div class="select">
        <center>
            &nbsp;
            <form action="realPayServlet" method="post">
                <table>
                    <c:forEach var="u" items="${findall}">
                        <tr>
                            <td align="center" class="submit">员工ID</td>
                            <td><input type="text" value="${u.id}" name="id" readonly="readonly" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">员工姓名</td>
                            <td><input type="text" value="${u.name}" name="name" readonly="readonly" class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">部门</td>
                            <td><input type="text" value="${u.dept}" name="dept" readonly="readonly" class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">岗位</td>
                            <td><input type="text" value="${u.job}" name="job" readonly="readonly" class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">月份</td>
                            <td><input type="month" value="2019-05" name="month" class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">应发工资</td>
                            <td><input type="text" value="${u.sum}" name="sum" id="sum" readonly="readonly"
                                       class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">五险一金</td>
                            <td><input type="text" name="wuxian" id="wuxian" class="loginname"
                                       placeholder="养老8%医疗2%失业0.2%住房12%"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">税（3%）</td>
                            <td><input type="text" name="shuihou" id="shuihou" class="loginname" placeholder="税率3%">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">实发工资</td>
                            <td><input type="text" name="realpay" id="realpay" class="loginname">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                &nbsp;&nbsp;
                <tr>
                    <div>
                        <td>
                            <input type="submit" value="确定" class="submit">
                        </td>
                    </div>
                </tr>
            </form>

        </center>
    </div>
</div>
</body>
</html>

