<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/4/6
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="css/head.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="baba">
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
                        <li>
                            <form action="aaa.jsp" method="post">
                                <input type="submit" value="员工岗位" class="square">
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
        <h2 align="center">欢迎使用企业人事管理系统</h2>
    </div>
</div>
</body>
</html>


