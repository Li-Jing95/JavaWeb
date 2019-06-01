<%@ page import="dao.deptDao" %>
<%@ page import="dao.deptDaoImpl" %>
<%@ page import="domain.Dept" %>
<%@ page import="java.util.ArrayList" %>
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
<script type="text/javascript">
    function getJobNameBySelectedDeptName(id) {//如果第一个下拉列表的值改变则调用此方法
        if (id != null && "" != id && -1 != id) {
            //通过ajax传入后台，把deptName数据传到后端
            $.post("deptLinkJobServlet", {deptId: id}, function (res) {
                var option;
                option = "<option>" + "选择岗位" + "</option>";
                $.each(res, function (i, n) {//循环，i为下标从0开始，n为集合中对应的第i个对象
                    option += "<option value='" + n.id + "'>" + n.name + "</option>"
                });
                $("#jobNameList").html(option);//将循环拼接的字符串插入第二个下拉列表
                $("#jobNameList").show();//把第二个下拉列表展示
            });
        } else {
            $("#jobNameList").hide();//隐藏对象不生效
        }
    }
</script>
<body>
<%@ include file="public.jsp" %>
<div id="section">
    <!--搜索栏-->
    <div class="select">
        <center>
            <br><br>
            <form action="employeeSelectServlet" method="post">
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
                <th>部门</th>
                <th>岗位</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <form action="employeeOkJobServlet" method="post">
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="3"></td>
                        <td><input type="text" value="${u.name}" name="name" readonly="readonly" size="3"></td>
                        <td>
                            <select onchange="getJobNameBySelectedDeptName(this.value)" id="dept" name="brand">
                                <option>选择部门</option>
                                <%
                                    deptDao deptDao = new deptDaoImpl();
                                    ArrayList<Dept> list = deptDao.findNameAll();
                                    request.setAttribute("findall", list);
                                %>
                                <c:forEach var="deptItem" items="${findall}">
                                    <option value="${deptItem.id}">${deptItem.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select name="jobNameList" id="jobNameList">
                            </select>
                        </td>
                        <td>
                            <input type="submit" value="确定"/>
                            <a href="employeeFindAllServlet">
                                <input type="button" value="取消" class="submit">
                            </a>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
