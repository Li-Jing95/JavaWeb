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
            &nbsp;&nbsp;
            <h3>添加信息</h3>
            &nbsp;
            <form action="registerServlet" method="post">
                <table>
                    <!--登录名-->
                    <tr>
                        <td align="center" class="submit">登录名</td>
                        <td><input type="text" name="loginname" class="loginname"></td>
                    </tr>
                    <!--密码-->
                    <tr>
                        <td align="center" class="submit">密码</td>
                        <td><input type="password" name="password" class="loginname"></td>
                    </tr>
                    <!--创建日期-->
                    <tr>
                        <td align="center" class="submit">建档日期</td>
                        <td><input type="text" name="createdate" onfocus="WdatePicker()" class="loginname"></td>
                    </tr>
                    <!--用户名-->
                    <tr>
                        <td align="center" class="submit">用户名</td>
                        <td><input type="text" name="username" class="loginname"></td>
                    </tr>
                </table>
                &nbsp;&nbsp;
                <tr>
                    <div>
                        <td>
                            <input type="submit" value="确定" class="submit">
                            &nbsp;&nbsp;&nbsp;<!--这有空格不能删除-->
                            <a href="findAllServlet">
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
