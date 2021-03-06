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
<%@ include file="public.jsp" %>
<div id="section">
    <!--搜索栏-->
    <div class="select">
        <center>
            <br><br>
            <form action="localPaySelectServlet" method="post">
                <input type="text" name="name" placeholder="请输入要查找的部门名称" class="loginname">
                <input type="submit" value="搜索" class="submit">
            </form>
        </center>
    </div>
    <br><br>
    <!--显示列表-->
    <center>
        <table class="gridtable" id="t_student">
            <tr>
                <th>ID</th>
                <th>部门名称</th>
                <th>部门描述</th>
                <th>基本薪资</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${findall}">
                <form action="localPayUpdateServlet" method="post">
                    <tr>
                        <td><input type="text" value="${u.id}" name="id" readonly="readonly" size="5"></td>
                        <td><input type="text" value="${u.name}" name="name" readonly="readonly" size="10"></td>
                        <td><input type="text" value="${u.remark}" name="remark" readonly="readonly" size="70"></td>
                        <td><input type="text" value="${u.localpay}" name="localpay" size="10"></td>
                        <td>
                            <input type="submit" value="更新"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </center>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--这有空格不能删除-->
    <center>
        <div class="gridItem">
            <!--style="padding: 5px; width: 250px; float: left; text-align: left; height: 20px; font-size: 15px; margin: 0 auto;"-->
            共有<span id="spanTotalInfor"></span>条记录
            当前第<span id="spanPageNum"></span>页
            共<span id="spanTotalPage"></span>页
            <%--</div>--%>
            <%--<div class="gridItem">--%>
            <!--style="margin-left:50px;  padding: 5px; width: 400px; float: left; text-align: center; height: 20px; vertical-align: middle; font-size: 15px;"-->
            <span id="spanFirst">首页</span>
            <span id="spanPre">上一页</span>
            <span id="spanInput" style="margin: 0px; padding: 0px 0px 4px 0px; height:100%; ">
                第<input id="Text1" type="text" class="TextBox" onkeyup="changepage()"
                        style="height:20px; text-align: center;width:50px"/>页
            </span>
            <span id="spanNext">下一页</span>
            <span id="spanLast">尾页</span>
        </div>
    </center>
</div>
<script type="text/javascript">
    var theTable = document.getElementById("t_student");
    var txtValue = document.getElementById("Text1").value;

    function changepage() {
        var txtValue2 = document.getElementById("Text1").value;
        if (txtValue != txtValue2) {
            if (txtValue2 > pageCount()) {

            }
            else if (txtValue2 <= 0) {

            }
            else if (txtValue2 == 1) {
                first();
            }
            else if (txtValue2 == pageCount()) {
                last();
            }
            else {
                hideTable();//隐藏所有行
                page = txtValue2;
                pageNum2.value = page;

                currentRow = pageSize * page;
                maxRow = currentRow - pageSize;
                if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
                for (var i = maxRow; i < currentRow; i++) {
                    theTable.rows[i].style.display = '';
                }
                if (maxRow == 0) {
                    preText();
                    firstText();
                }
                showPage();
                nextLink();
                lastLink();
                preLink();
                firstLink();
            }

            txtValue = txtValue2;
        }
    }

</script>
<script type="text/javascript" src="js/Pagging.js"></script>
</body>
</html>
