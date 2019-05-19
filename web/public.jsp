<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/17
  Time: 10:25
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
            $("#jobNameList").hide();//隐藏对象不生效
        }
    }
</script>
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

        document.getElementById("shuihou").value = shuihou1;

        var realpay1 = Number(sum) - Number(wuxian1) - Number(shuihou1);
        document.getElementById("realpay").value = realpay1;
    };
</script>
<body>
<div id="header">
    <h2>企业人事管理系统</h2>
    <a class="loginout" href="login.jsp"><i class="iconfont icon-tuichudenglu">退出登录</i></a>
    <a class="reindex" href="ok.jsp"><i class="iconfont icon-fanhuishouye">返回首页</i></a>
</div>
<div id="nav">
    <div class="dropdown">
        <ul class="score">
            <li><span class="iconfont icon-bumen"> 部门管理</span>
                <ol class="public">
                    <li>
                        <form action="deptFindAllServlet" method="post">
                            <i class="iconfont icon-liebiao">
                                <input type="submit" value="部门列表" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="addDept.jsp" method="post">
                            <i class="iconfont icon-tianjia">
                                <input type="submit" value="添加部门" class="square">
                            </i>
                        </form>
                    </li>
                </ol>
            </li>
            <li><span class="iconfont icon-zhiwei"> 职位管理</span>
                <ol class="public">
                    <li>
                        <form action="jobFindAllServlet" method="post">
                            <i class="iconfont icon-liebiao">
                                <input type="submit" value="职位列表" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="addJob.jsp" method="post">
                            <i class="iconfont icon-tianjia">
                                <input type="submit" value="添加职位" class="square">
                            </i>
                        </form>
                    </li>
                </ol>
            </li>
            <li><span class="iconfont icon-yuangong"> 员工管理</span>
                <ol class="public">
                    <li>
                        <form action="employeeFindAllServlet" method="post">
                            <i class="iconfont icon-liebiao">
                                <input type="submit" value="员工列表" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="addEmployee.jsp" method="post">
                            <i class="iconfont icon-tianjia">
                                <input type="submit" value="添加员工" class="square">
                            </i>
                        </form>
                    </li>
                </ol>
            </li>
            <li><span class="iconfont icon-xinzi"> 薪资管理</span>
                <ol class="public">
                    <li>
                        <form action="localPayFindAllServlet" method="post">
                            <i class="iconfont icon-gongzi">
                                <input type="submit" value="基本薪资" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="jobPayFindAllServlet" method="post">
                            <i class="iconfont icon-gongzi">
                                <input type="submit" value="岗位薪资" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="employeePayFindAllServlet" method="post">
                            <i class="iconfont icon-gongzi">
                                <input type="submit" value="应发薪资" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="realPayFindAllServlet" method="post">
                            <i class="iconfont icon-gongzi">
                                <input type="submit" value="实发薪资" class="square">
                            </i>
                        </form>
                    </li>
                </ol>
            </li>
            <li><span class="iconfont icon-tongji"> 统计功能</span>
                <ol class="public">
                    <li>
                        <form action="manOrWomanServlet" method="post">
                            <i class="iconfont icon-male8">
                                <input type="submit" value="男女比例" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="educationalLevelServlet" method="post">
                            <i class="iconfont icon-xueli">
                                <input type="submit" value="学历层次" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="politicalLevelServlet" method="post">
                            <i class="iconfont icon-zhengzhi">
                                <input type="submit" value="政治层次" class="square">
                            </i>
                        </form>
                    </li>
                </ol>
            </li>
            <li><span class="iconfont icon-yuangongguanli"> 用户管理</span>
                <ol class="public">
                    <li>
                        <form action="findAllServlet" method="post">
                            <i class="iconfont icon-liebiao">
                                <input type="submit" value="用户列表" class="square">
                            </i>
                        </form>
                    </li>
                    <li>
                        <form action="addUser.jsp" method="post">
                            <i class="iconfont icon-tianjia">
                                <input type="submit" value="添加用户" class="square">
                            </i>
                        </form>
                    </li>
                </ol>
            </li>
        </ul>
    </div>
</div>
</body>
</html>