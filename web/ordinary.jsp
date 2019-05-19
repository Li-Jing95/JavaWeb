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
    <link href="css/iconfont.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" defer="defer"
        src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js">
</script>
<body>
<div id="header">
    <h2>企业人事管理系统</h2>

    <a class="loginout" href="ordLogin.jsp"><i class="iconfont icon-tuichudenglu">退出登录</i></a>
    <a class="reindex" href="ordOk.jsp"><i class="iconfont icon-fanhuishouye">返回首页</i></a>
</div>
<div id="nav">
    <div class="dropdown">
        <ul class="score">
            <li><span class="iconfont icon-yuangong"> 查看信息</span>
                <ol class="public">
                    <li>
                        <form action="ordDeptFindAllServlet" method="post">
                            <i class="iconfont icon-liebiao">
                                <input type="submit" value="部门列表" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="ordJobFindAllServlet" method="post">
                            <i class="iconfont icon-liebiao">
                                <input type="submit" value="职位列表" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="ordMyInfServlet" method="post">
                            <i class="iconfont icon-liebiao">
                                <input type="submit" value="我的信息" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="ordMyPayServlet" method="post">
                            <i class="iconfont icon-liebiao">
                                <input type="submit" value="我的工资" class="square">
                            </i>
                        </form>
                    </li>
                </ol>
            </li>
            <li>
                <span class="iconfont icon-yuangong">
                    <a href="ordChangeMiMa.jsp">修改密码</a>
                </span>

            </li>
        </ul>

    </div>
</div>
</body>
</html>
