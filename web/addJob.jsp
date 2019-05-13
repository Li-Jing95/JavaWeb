<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.Dept" %>
<%@ page import="dao.deptDao" %>
<%@ page import="erp.JDBC" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.deptDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/4/6
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--String path = request.getContextPath();--%>
<%--String basePath = request.getScheme() + "://" + request.getServerName() + "://" + request.getServerPort() + path + "/";--%>
<%--%>--%>
<html>
<head>
    <link href="css/head.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" defer="defer"
        src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
<body>
<h5>${xiaoxi}</h5>
<div id="header">
    <h2>企业人事管理系统</h2>
    <a class="reindex" href="ok.jsp">返回首页</a>
    <a class="loginout" href="login.jsp">退出登录</a>
</div>
<div id="nav">
    <div class="dropdown">
        <ul class="score">
            <li>用户管理
                <ol class="public">
                    <li>
                        <form action="findAllServlet" method="post">
                            <input type="submit" value="用户列表" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="addUser.jsp" method="post">
                            <input type="submit" value="添加用户" class="square">
                        </form>
                    </li>

                </ol>
            </li>
            <li>部门管理
                <ol class="public">
                    <li>
                        <form action="deptFindAllServlet" method="post">
                            <input type="submit" value="部门列表" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="addDept.jsp" method="post">
                            <input type="submit" value="添加部门" class="square">
                        </form>
                    </li>
                </ol>
            </li>
            <li>职位管理
                <ol class="public">
                    <li>
                        <form action="jobFindAllServlet" method="post">
                            <input type="submit" value="职位列表" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="addJob.jsp" method="post">
                            <input type="submit" value="添加职位" class="square">
                        </form>
                    </li>
                </ol>
            </li>
            <li>员工管理
                <ol class="public">
                    <li>
                        <form action="employeeFindAllServlet" method="post">
                            <input type="submit" value="员工列表" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="addEmployee.jsp" method="post">
                            <input type="submit" value="添加员工" class="square">
                        </form>
                    </li>

                </ol>
            </li>
            <li>薪资管理
                <ol class="public">
                    <li>
                        <form action="localPayFindAllServlet" method="post">
                            <input type="submit" value="基本薪资" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="jobPayFindAllServlet" method="post">
                            <input type="submit" value="岗位薪资" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="employeePayFindAllServlet" method="post">
                            <input type="submit" value="员工薪资" class="square">
                        </form>
                    </li>
                </ol>
            </li>
        </ul>
    </div>
</div>
<div id="section">
    <center>
        <h4>添加信息</h4>
        <form action="jobRegisterServlet" method="post">
            <table>
                <tr>
                    <td>请选择部门:</td>
                    <td>
                        <select name="deptid">
                            <option value="0">请选择</option>
                            <%
                                deptDao deptDao = new deptDaoImpl();
                                ArrayList<Dept> list=deptDao.findNameAll();
                                for (int i=0;i<list.size();i++){%>
                                    <option value="<%=i+1%>"><%=list.get(i).getName()%></option>
                            <%}%>
                        </select>
                    </td>

                </tr>
                <tr>
                    <td>职位名称:</td>
                    <td><input type="text" name="name"></td>
                </tr>

                <tr>
                    <td>职位描述:</td>
                    <td><input type="textarea" name="remark"></td>
                </tr>
                <tr>
                    <td>

                        <input type="submit" value="确定">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</div>
</body>
</html>
