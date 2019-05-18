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
<h5>${xiaoxi}</h5>
<%@ include file="public.jsp" %>
<div id="section">
    <div class="select">
        <center>
            <h3>添加信息</h3>
            <form action="employeeRegisterServlet" method="post">
                <table>
                    <tr>
                        <td align="center" class="submit">姓名</td>
                        <td><input type="text" name="name" class="loginname"></td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">性别</td>
                        <td>
                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                            <input type="radio" name="sex" value="男">男
                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                            <input type="radio" name="sex" value="女">女
                        </td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">民族</td>
                        <td><input type="text" name="nation" class="loginname"></td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">政治面貌</td>
                        <td>
                            <select name="polic" class="loginname">
                                <option value="0">请选择</option>
                                <option value="群众">群众</option>
                                <option value="团员">团员</option>
                                <option value="党员">党员</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">出生日期</td>
                        <td><input type="text" name="born" class="loginname"></td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">电话</td>
                        <td><input type="text" name="tel" class="loginname"></td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">邮箱</td>
                        <td><input type="text" name="email" class="loginname"></td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">学历</td>
                        <td>
                            <select name="education" class="loginname">
                                <option value="0">请选择</option>
                                <option value="专科">专科</option>
                                <option value="本科">专科</option>
                                <option value="研究生">研究生</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">身份证号</td>
                        <td><input type="text" name="card_id" class="loginname"></td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">部门</td>
                        <td>
                            <select onchange="getJobNameBySelectedDeptName(this.value)" id="dept" name="brand"
                                    class="loginname">
                                <option>选择部门</option>
                                <%
                                    deptDao deptDao = new deptDaoImpl();
                                    ArrayList<Dept> list = deptDao.findNameAll();
                                    request.setAttribute("findall", list);
                                %>
                                <c:forEach var="deptItem" items="${findall}">
                                    <option value="${deptItem.id}">${deptItem.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">岗位</td>
                        <td>
                            <select name="jobNameList" id="jobNameList" class="loginname">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" class="submit">建档日期</td>
                        <td><input type="text" name="createdate" onfocus="WdatePicker()" class="loginname"></td>
                    </tr>

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
