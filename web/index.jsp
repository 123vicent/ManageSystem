<%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/3
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta  charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>登录系统</title>
  <link href="style/login.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="style/layui.css">
</head>
<body>
<div id="title">
  <h1>车辆销售处理系统</h1>
</div>
<div id="myBody">

  <div id="border">
    <div id="userLogin">
      <form id="loginForm" action="/login">
        <label id="lab">登录</label>
        <br/>
        <div id="userName">
          <img class="textPic" src="style/styleImg/用户.png">
          <input class="text" type="text" placeholder="账号" name="username">
        </div>
        <%if(request.getAttribute("msg0")!=null){ %>
        <%=request.getAttribute("msg0")%>
        <%  }%>
        <div id="password">
          <img class="textPic" src="style/styleImg/密码.png">
          <input class="text" type="password" placeholder="密码" name="password">
        </div>
        <%if(request.getAttribute("msg1")!=null){ %>
        <%=request.getAttribute("msg1")%>
        <% }%>
          <%if(request.getAttribute("msg2")!=null){ %>
          <%=request.getAttribute("msg2")%>
          <%  }%>

        <br/>
        <div id="button">
          <input id="loginButton" name="submit" type="submit" value="登录">
        </div>
        <div id="others">
          <label id="register"><input id="submit" name="submit" type="submit" value="立即注册"></label>
          <label id="forget"><input id="bttn" name="submit" type="submit" value="忘记密码"></label>
        </div>
      </form>

    </div>
  </div>
</div>
<script src="style/layui.js"></script>
</body>
</html>
