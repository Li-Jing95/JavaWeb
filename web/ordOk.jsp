<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/17
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div id="baba">
    <%@ include file="ordinary.jsp" %>
    <div id="section">
        <h2 align="center">欢迎工号为<%=session.getAttribute("login")%>的员工登录</h2>
        <center>
            <img src="img/aa.png">
        </center>
    </div>
</div>
</body>
</html>
