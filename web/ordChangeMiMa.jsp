<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/19
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<%@ include file="ordinary.jsp" %>
<div id="section">
    <div class="select">
        <center>
            &nbsp;<!--这是空格不能删除-->
            <form action="ordChangeMiMaServet" method="post">
                <table>
                    <tr>
                        <td align="center" class="submit">新密码</td>
                        <td><input type="text" name="newpsd" placeholder="请输入新密码" class="loginname"></td>
                    </tr>

                </table>
                &nbsp;&nbsp;<!--这是空格不能删除-->
                <tr>
                    <div>
                        <td>
                            <input type="submit" value="确定" class="submit">
                            &nbsp;&nbsp;&nbsp;<!--这是空格不能删除-->
                            <a href="ordOk.jsp">
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

