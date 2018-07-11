<%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/10
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../style/css/bootstrap.min.css" />
    <title>用户注册</title>
</head>
<body>
<form action="/regist">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <<p class="navbar-brand"><font size="5">汽车销售管理系统</p>
        </div>
    </div>
</nav>

<div class="container" style="margin-top: 80px;">
    <div class="col-md-6 col-md-offset-3">
        <form action="" class="">
            <label for="user_id"><font size="4">账号</font></label>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                <input id="user_id" name="id" class="form-control" placeholder="请输入申请账号" maxlength="20" type="text" />
            </div>
            <%if(request.getAttribute("msg")!=null){ %>
            <%=request.getAttribute("msg")%>
            <%  }%>
            <div class="form-group">
                <label for="username"><font size="4">姓名</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input id="username" name="name" class="form-control" placeholder="请输入用户姓名" maxlength="30" type="text"/>
                </div>
            </div>

            <div class="form-group">
                <label for="password"><font size="4">密码</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="password" name="password" class="form-control" placeholder="请输入密码" maxlength="20" type="password" />
                </div>
            </div>

            <div class="form-group">
                <label for="repassword"><font size="4">确认密码</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="repassword" name="chkpassword" class="form-control" placeholder="请再次输入密码" maxlength="20" type="password" />
                </div>
            </div>
            <%if(request.getAttribute("chkpswd")!=null){ %>
            <%=request.getAttribute("chkpswd")%>
            <%  }%>
            <div class="form-group">
                <label for="user_phone"><font size="4">手机号码</font></label>
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                    <input id="user_phone" name="phone" class="form-control" placeholder="请输入用户手机号码" maxlength="11" type="text" />
                </div>
            </div>

            <div class="form-group">
                <input class="form-control btn btn-primary" type="submit" id="register" value="立&nbsp;&nbsp;即&nbsp;&nbsp;注&nbsp;&nbsp;册" />
            </div>
            <div class="form-group">
                <input id="reset" class="form-control btn btn-danger" type="reset" value="重置"/>
            </div>

        </form>
    </div>
</div>
</form>
</body>
</html>