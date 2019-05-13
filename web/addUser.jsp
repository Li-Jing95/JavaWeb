<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/4/6
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.userDao" %>
<%@ page import="dao.userDaoImpl" %>

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
            <li><span>用户管理</span>
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
            <li><span>部门管理</span>
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
            <li><span>职位管理</span>
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
            <li><span>员工管理</span>
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
                    <li>
                        <form action="employeeJobServlet" method="post">
                            <input type="submit" value="员工岗位" class="square">
                        </form>
                    </li>

                </ol>
            </li>
            <li><span>薪资管理</span>
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
        <form action="registerServlet" method="post">
            <table>
                <!--登录名-->
                <tr>
                    <td>登&nbsp;&nbsp;录&nbsp;&nbsp;名:</td>
                    <td><input type="text" name="loginname"></td>
                </tr>
                <!--密码-->
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <!--创建日期-->
                <tr>
                    <td>建档日期：</td>
                    <td><input type="text" name="createdate" onfocus="WdatePicker()"></td>
                </tr>
                <!--用户名-->
                <tr>
                    <td>用&nbsp;&nbsp;户&nbsp;&nbsp;名:</td>
                    <td><input type="text" name="username"></td>
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
