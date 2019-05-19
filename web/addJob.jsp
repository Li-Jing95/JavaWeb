<%@ page import="dao.deptDao" %>
<%@ page import="dao.deptDaoImpl" %>
<%@ page import="domain.Dept" %>
<%@ page import="java.util.ArrayList" %>
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

<%@ include file="public.jsp" %>
<div id="section">
    <div class="select">
        <center>
            &nbsp;&nbsp;<!--这儿有空格不能删除-->
            <h3>添加信息</h3>
            &nbsp;<!--这儿有空格不能删除-->
            <form action="jobRegisterServlet" method="post">
                <table>
                    <tr>
                        <td align="center" class="submit">选择部门</td>
                        <td>
                            <select name="deptid" class="loginname">
                                <option>请选择</option>
                                <%
                                    deptDao deptDao = new deptDaoImpl();
                                    ArrayList<Dept> list = deptDao.findNameAll();
                                    request.setAttribute("findall", list);
                                %>
                                <c:forEach var="i" items="${findall}">
                                    <option value="${i.id}">${i.name}</option>
                                </c:forEach>
                                <%--for (int i = 0; i < list.size(); i++) {%>--%>
                                <%--<option value="<%=i+1%>"><%=list.get(i).getName()%>--%>
                                <%--</option>--%>
                                <%--<%}%>--%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">职位名称</td>
                        <td><input type="text" name="name" class="loginname"></td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">职位描述</td>
                        <td><input type="text" name="remark" class="loginname"></td>
                    </tr>
                </table>
                &nbsp;&nbsp;<!--这儿有空格不能删除-->
                <tr>
                    <div>
                        <td>
                            <input type="submit" value="确定" class="submit">
                            &nbsp;&nbsp;&nbsp;<!--这有空格不能删除-->
                            <a href="jobFindAllServlet">
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
