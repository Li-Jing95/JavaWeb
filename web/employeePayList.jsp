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
    <!--搜索栏-->
    <div class="select">
        <center>
            <br><br>
            <form action="employeePaySelectServlet" method="post">
                <input type="text" name="loginname" placeholder="请输入要查找的员工" class="loginname">
                <input type="submit" value="搜索" class="submit">
            </form>
        </center>
    </div>
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable">
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>性别</th>
                <th>身份证号</th>
                <th>部门</th>
                <th>职位</th>
                <th>基本薪资</th>
                <th>岗位薪资</th>
                <th>总薪资</th>
                <th>建档日期</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="3"></td>
                        <td><input type="text" value="${u.name}" name="name" size="3"></td>
                        <td><input type="text" value="${u.sex}" name="sex" size="3"></td>
                        <td><input type="text" value="${u.card_id}" name="card_id" size="12"></td>
                        <td><input type="text" value="${u.dept}" name="dept" size="7"></td>
                        <td><input type="text" value="${u.job}" name="job" size="7"></td>
                        <td><input type="text" value="${u.localpay}" name="localpay" size="3"></td>
                        <td><input type="text" value="${u.jobpay}" name="jobpay" size="3"></td>
                        <td><input type="text" value="${u.sum}" name="sum" size="3"></td>
                        <td><input type="text" value="${u.createdate}" name="createdate" size="10"></td>
                    </tr>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
