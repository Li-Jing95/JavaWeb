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
            <form action="deptRegisterServlet" method="post">
                <table>
                    <!--登录名-->
                    <tr>
                        <td align="center" class="submit">部门名称</td>
                        <td><input type="text" name="name" class="loginname"></td>
                    </tr>
                    <!--描述-->
                    <tr>
                        <td align="center" class="submit">部门描述</td>
                        <td><input type="text" name="remark" class="loginname"></td>
                    </tr>
                </table>
                &nbsp;&nbsp;<!--这儿有空格不能删除-->
                <tr>
                    <div>
                        <td>
                            <input type="submit" value="确定" class="submit">
                            &nbsp;&nbsp;&nbsp;<!--这儿有空格不能删除-->
                            <a href="deptFindAllServlet">
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
