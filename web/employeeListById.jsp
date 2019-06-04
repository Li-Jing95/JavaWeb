<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/18
  Time: 11:16
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
            &nbsp;<!--这儿有空格不能删除-->
            <form action="employeeUpdateServlet" method="post">
                <table>
                    <c:forEach var="u" items="${findall}">
                        <tr>
                            <td align="center" class="submit">ID</td>
                            <td><input type="text" value="${u.id}" name="id" readonly="readonly" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">姓名</td>
                            <td><input type="text" value="${u.name}" name="name" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">性别</td>
                            <td>
                                    <%--&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<!--这有空格不能删除-->--%>
                                    <%--<input type="radio" name="sex" value="男">男--%>
                                    <%--&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<!--这有空格不能删除-->--%>
                                    <%--<input type="radio" name="sex" value="女">女--%>
                                <select name="sex" value="${u.sex}" class="loginname">
                                    <option value="男" <c:if test="${'男' eq u.sex}">selected</c:if>>男</option>
                                    <option value="女" <c:if test="${'女' eq u.sex}">selected</c:if>>女</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">民族</td>
                            <td><input type="text" value="${u.nation}" name="nation" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">政治面貌</td>
                            <td>
                                <select name="polic" value="${u.polic}" class="loginname">
                                    <option value="群众" <c:if test="${'群众' eq u.polic}">selected</c:if>>群众</option>
                                    <option value="团员" <c:if test="${'团员' eq u.polic}">selected</c:if>>团员</option>
                                    <option value="党员" <c:if test="${'党员' eq u.polic}">selected</c:if>>党员</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">出生日期</td>
                            <td><input type="date" value="${u.born}" name="born" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">电话</td>
                            <td><input type="text" value="${u.tel}" name="tel" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">邮箱</td>
                            <td><input type="text" value="${u.email}" name="email" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">学历</td>
                            <td>
                                <select name="education" value="${u.education}" class="loginname">
                                    <option value="专科" <c:if test="${'专科' eq u.education}">selected</c:if>>专科</option>
                                    <option value="本科" <c:if test="${'本科' eq u.education}">selected</c:if>>本科</option>
                                    <option value="研究生" <c:if test="${'研究生' eq u.education}">selected</c:if>>研究生
                                    </option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">身份证号</td>
                            <td><input type="text" value="${u.card_id}" name="card_id" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">建档日期</td>
                            <td><input type="text" value="${u.createdate}" name="createdate" onfocus="WdatePicker()"
                                       class="loginname"></td>
                        </tr>
                    </c:forEach>
                </table>
                &nbsp;&nbsp;<!--这儿有空格不能删除-->
                <tr>
                    <div>
                        <td>
                            <input type="submit" value="确定" class="submit">
                            &nbsp;&nbsp;&nbsp;<!--这儿有空格不能删除-->
                            <a href="employeeFindAllServlet">
                                <input type="button" value="取消" class="submit">
                            </a>
                        </td>
                    </div>
                </tr>
            </form>
        </center>
    </div>
</div>
</body>
</html>
