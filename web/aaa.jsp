<%@ page import="dao.deptDao" %>
<%@ page import="dao.deptDaoImpl" %>
<%@ page import="domain.Dept" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.jobDao" %>
<%@ page import="dao.jobDaoImpl" %>
<%@ page import="domain.Job" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/12
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jQuery.main.js"></script>

<body>
<script type="text/javascript">
    function getShoppe() {//如果第一个下拉列表的值改变则调用此方法
        var name = $("#bra option:selected").attr("id");//得到第一个下拉列表的值
        if (name != null && "" != name && -1 != name) {
            //通过ajax传入后台，把orderTypeName数据传到后端
            $.post("deptFindNameAllServlet", {name: name}, function (data) {
                var res = $.parseJSON(data);//把后台传回的json数据解析
                var option;
                option = "<option>" + "选择岗位" + "</option>";
                $.each(res, function (i, n) {//循环，i为下标从0开始，n为集合中对应的第i个对象
                    option += "<option value='" + n.name + "'>" + n.name + "</option>"
                });
                $("#shoppe").html(option);//将循环拼接的字符串插入第二个下拉列表
                $("#shoppe").show();//把第二个下拉列表展示
            });

        } else {
            $("#shoppe").hide();
        }
    }
</script>
<select onchange="getShoppe()" id="bra" name="brand">
    <option>选择部门</option>
    <%
        deptDao deptDao = new deptDaoImpl();
        ArrayList<Dept> list = deptDao.findNameAll();
        request.setAttribute("findall", list);
    %>
    <c:forEach var="brandL" items="${findall}">
        <option value="${brandL.name}">${brandL.name}</option>
    </c:forEach>
</select>

<select name="shop" id="shoppe" onchange="getStaff()">
    <option>选择岗位</option>
    <%
        jobDao jobDao = new jobDaoImpl();
        ArrayList<Job> listjob = jobDao.findNameAll();
        request.setAttribute("findalljob", listjob);
    %>
    <c:forEach var="brandL" items="${findalljob}">
        <option value="${brandL.name}">${brandL.name}</option>
    </c:forEach>
</select>


</body>
</html>
