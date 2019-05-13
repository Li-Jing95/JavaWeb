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
<head>
    <link href="css/head.css" rel="stylesheet" type="text/css">
    <link href="css/table.css" rel="stylesheet" type="text/css">
</head>
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
    <!--搜索栏-->
    <div class="select">
        <center>
            <br><br>
            <form action="deptSelectServlet" method="post">
                <input type="text" name="name" placeholder="请输入要查找的部门名称">
                <input type="submit" value="搜索">
            </form>
        </center>
    </div>
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th>ID</th>
                <th>部门名称</th>
                <th>部门描述</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <form action="deptUpdateServlet" method="post">
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="5"></td>
                        <td><input type="text" value="${u.name}" name="name" size="10"></td>
                        <td><input type="text" value="${u.remark}" name="remark" size="70" ></td>
                        <td>
                            <a href="deptDeleteServlet?id=${u.id}">删除</a>
                            <input type="submit" value="更新"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
