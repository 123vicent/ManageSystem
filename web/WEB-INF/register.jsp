<%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/3
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <link rel="stylesheet" href="../style/layui.css">
    <link rel="stylesheet" href="../style/login.css">
</head>
<body>
<div id="title">
    <h1>车辆销售处理系统</h1>
    <hr />
</div>
<div id="reg_border">
    <h2 id="reg_title">欢迎注册车辆销售管理系统！</h2>
    <form class="layui-form" action="/register">

        <div class="layui-form-item" id="reg_id">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" style="width:300px" name="identity" lay-verify="identity" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <%if(request.getAttribute("msg")!=null){ %>
            <%=request.getAttribute("msg")%>
            <%  }%>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" style="width:300px" name="password" lay-verify="pass" placeholder="请填写6到12位密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" style="width:300px" name="chkpassword" lay-verify="pass" placeholder="请确保和上方密码一致" autocomplete="off" class="layui-input">
            </div>
        </div>
        <%if(request.getAttribute("chkpswd")!=null){ %>
        <%=request.getAttribute("chkpswd")%>
        <%  }%>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">店名</label>
                <div class="layui-input-inline">
                    <input type="tel" name="shopname" style="width: 300px" lay-verify="required|phone" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">联系方式</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" style="width: 300px" lay-verify="email" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">店址</label>
                <div class="layui-input-inline">
                    <input type="text" name="address" style="width: 300px" lay-verify="email" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">负责人</label>
                <div class="layui-input-inline">
                    <input type="text" name="manager" style="width: 300px" lay-verify="email" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <input class="layui-btn"  type = "submit" name="submit" value="立即提交">
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script src="../style/layui.js"></script>

</body>
</html>
