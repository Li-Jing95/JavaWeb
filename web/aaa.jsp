<%--
  Created by IntelliJ IDEA.
  User: Jing
  Date: 2019/5/31
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jQuery.main.js"></script>
<script type="text/javascript">
    function chMobilePhone(src) {
        if (/^1([38]\d|5[0-35-9]|7[3678])\d{8}$/.test(src)) {
            alert('手机号码规范');
            // return true;

        } else {
            alert("手机号码不规范");
            document.getElementById('tel').value = "";
        }
    }

    function check() {
        var oval = document.getElementById('tel').value;
        if (oval.length == 11) {
            chMobilePhone(oval);
        }
        else {
            alert("手机号位数不对,请重新输入");
            document.getElementById('tel').value = "";
        }
    }
</script>
<body>
<input type="text" name="tel" id="tel" class="loginname" onblur="check()">
<%--<input type="submit" value="确定" class="submit">--%>
</body>
</html>
