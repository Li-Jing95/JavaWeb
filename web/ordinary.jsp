<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/17
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/head.css" rel="stylesheet" type="text/css">
    <link href="css/table.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" defer="defer"
        src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js">
</script>
<script src="js/jQuery.main.js"></script>
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
            $("#jobNameList").hide();
        }
    }
</script>
<body>
<div id="header">
    <h2>企业人事管理系统</h2>
    <a class="reindex" href="ok.jsp">返回首页</a>
    <a class="loginout" href="login.jsp">退出登录</a>
</div>
<div id="nav">
    <div class="dropdown">
        <ul class="score">
            <li><span>查看信息</span>
                <ol class="public">
                    <li>
                        <form action="ordDeptFindAllServlet" method="post">
                            <input type="submit" value="部门列表" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="ordJobFindAllServlet" method="post">
                            <input type="submit" value="职位列表" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="ordEmployeeFindAllServlet" method="post">
                            <input type="submit" value="员工列表" class="square">
                        </form>
                    </li>
                    <li>
                        <form action="employeePayFindAllServlet" method="post">
                            <input type="submit" value="员工薪资" class="square">
                        </form>
                    </li>
                </ol>
        </ul>
    </div>
</div>
</body>
</html>
