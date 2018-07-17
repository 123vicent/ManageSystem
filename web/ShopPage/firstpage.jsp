<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="basic.KeyValuePair" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/3
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../css/favicon.ico">
    <title>汽车销售管理系统</title>
	<!-- css引用 -->
    <!-- Bootstrap core CSS -->
    <link href="../style/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="../style/css/childstyle.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="../style/css/childmenu.css" type="text/css" media="screen">
	<link rel="stylesheet" href="../style/css/bootstrap-table.css"/>
	<link rel="stylesheet" href="../style/css/bootstrap-table-fixed-columns.css"/>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../style/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../style/css/dashboard.css" rel="stylesheet">
	<link href="../style/css/carousel.css" rel="stylesheet">

  <script src="../style/js/ie-emulation-modes-warning.js"></script>
	<!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
	<!--jquery和box和bootstrap-->
	<script type="text/javascript" src="../style/js/jquery.min.js"></script>
	<script type="text/javascript" src="../style/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script><!-- 如果断网，需要下载这个js -->
	<script type="text/javascript" src="../style/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="../style/js/bootstrap-table-zh-CN.js"></script>


  </head>

  <body>
  <style type="text/css">
      #result{
          width: 800px;
          height:500px;
          border:1px solid #eee;
      }
      #result img{
          height:500px;
      }
  </style>
  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
          <div class="navbar-header">
              <img src="../../style/images/mainlogo.png" style="width:50px">
          </div>
          <div class="navbar-header">
              <p class="navbar-brand" ><font size="5">汽车销售管理系统</font></p>
          </div>
          <div>
              <p id= "huanying" class="navbar-brand" align="right"><font size="4">用户：<a href="/SearchUserServlet" name="userid">${userid}</a> </font></p>
          </div>

          <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav navbar-right">
                  <li><a href="/SwitchPage?page=homepage" class="active"><font size="3">系统主页</font></a></li>
                  <li><a href="/SwitchPage?page=funcpage"><font size="3">使用功能</font></a></li>
                  <li><a href="/SwitchPage?page=setpage"><font size="3">用户设置</font></a></li>
                  <li><a href="/SwitchPage?page=helppage"><font size="3">帮助界面</font></a></li>
              </ul>
              <!--页内切换-->
              <!--
              <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
              </form>
              -->
          </div>
      </div>
  </nav>

  <div class="tab-content">
      <div class="tab-pane fade in active" id="A">
          <!-- Carousel
          ================================================== -->
          <div id="myCarousel" class="carousel slide" data-ride="carousel">
              <!-- Indicators -->
              <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
              </ol>
              <div class="carousel-inner" role="listbox">
                  <div class="item active">
                      <img class="first-slide" src="../../style/images/firstpage1.png"  alt="First slide">
                      <div class="container">
                          <%--<div class="carousel-caption">
                              <h1>标题一</h1>
                              <p>段落一</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="/SwitchPage?page=funcpage" data-toggle="tab"role="button">马上使用功能</a></p>
                          </div>--%>
                      </div>
                  </div>
                  <div class="item">
                      <img class="second-slide" src="../../style/images/firstpage2.jpg" alt="Second slide">
                      <div class="container">
                          <%--<div class="carousel-caption">
                              <h1>标题二</h1>
                              <p>段落二</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#C" data-toggle="tab"role="button">查看用户设置</a></p>
                          </div>--%>
                      </div>
                  </div>
                  <div class="item">
                      <img class="third-slide" src="../../style/images/firstpage3.jpg" alt="Third slide">
                      <div class="container">
                          <%--<div class="carousel-caption">
                              <h1>标题三</h1>
                              <p>段落三</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#D" role="button">查看帮助界面</a></p>
                          </div>--%>
                      </div>
                  </div>
              </div>
              <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
              </a>
              <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
              </a>
          </div><!-- /.carousel -->
          <!-- Marketing messaging and featurettes
      ================================================== -->
          <!-- Wrap the rest of the page in another container to center all the content. -->

          <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>查询车辆</h2>
          <p></p>
          <p><a class="btn btn-default" href="/SwitchPage?page=funcViewCar" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>查询预约</h2>
          <p></p>
          <p><a class="btn btn-default" href="/SwitchPage?page=funcViewAppointment" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>浏览记录</h2>
          <p></p>
          <p><a class="btn btn-default" href="/SwitchPage?page=funcViewRecord" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->
              </div><!-- /.row -->

              <!-- FOOTER -->
              <footer>
                  <p class="pull-right"><a href="#">返回顶部</a></p>
              </footer>

          </div><!-- /.container -->
  </div>
  </body>
</html>

