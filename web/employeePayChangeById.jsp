<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/18
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript">
    window.onload = function () {
        var sum = document.getElementById("sum").value;
        var wuxian1 = Number(sum) * 0.222;
        document.getElementById("wuxian").value = wuxian1;

        var shui1 = Number(sum) - Number(wuxian1);

        if (shui1 >= 5000) {
            var shuihou1 = Number(shui1) * 0.03;
        } else {
            var shuihou1 = 0;
        }
        alert(shuihou1);
        document.getElementById("shuihou").value = shuihou1;

        var realpay1 = Number(sum) - Number(wuxian1) - Number(shuihou1);
        document.getElementById("realpay").value = realpay1;
    };
</script>
<body>
<%@ include file="public.jsp" %>
<div id="section">
    <div class="select">
        <center>
            &nbsp;
            <form action="realPayServlet" method="post">
                <table>
                    <c:forEach var="u" items="${findall}">
                        <tr>
                            <td align="center" class="submit">员工ID</td>
                            <td><input type="text" value="${u.id}" name="id" readonly="readonly" class="loginname"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">员工姓名</td>
                            <td><input type="text" value="${u.name}" name="name" readonly="readonly" class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">部门</td>
                            <td><input type="text" value="${u.dept}" name="dept" readonly="readonly" class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">岗位</td>
                            <td><input type="text" value="${u.job}" name="job" readonly="readonly" class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">月份</td>
                            <td><input type="month" value="2019-05" name="month" class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">应发工资</td>
                            <td><input type="text" value="${u.sum}" name="sum" id="sum" readonly="readonly"
                                       class="loginname">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">五险一金</td>
                            <td><input type="text" name="wuxian" id="wuxian" class="loginname"
                                       placeholder="养老8%医疗2%失业0.2%住房12%"></td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">税后</td>
                            <td><input type="text" name="shuihou" id="shuihou" class="loginname" placeholder="税率3%">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" class="submit">实发工资</td>
                            <td><input type="text" name="realpay" id="realpay" class="loginname">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                &nbsp;&nbsp;
                <tr>
                    <div>
                        <td>
                            <input type="submit" value="确定" class="submit">
                        </td>
                    </div>
                </tr>
            </form>

        </center>
    </div>
</div>
</body>
</html>

