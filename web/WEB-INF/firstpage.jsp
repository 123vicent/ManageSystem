<%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/3
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="basic.Appointment" %>
<%@ page language="java" import="basic.Car" %>
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
  <%Appointment appointment = new Appointment();
      appointment=(Appointment)request.getAttribute("appointment");
  %>
  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
          <div class="navbar-header">
              <p class="navbar-brand" ><font size="5">汽车销售管理系统</font></p>
          </div>
          <div>
              <p id= "huanying" class="navbar-brand" align="right"><font size="4">欢迎您！XXX</font></p>
          </div>

          <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav navbar-right">
                  <li><a href="#A" class="active" data-toggle="tab"><font size="3">系统主页</font></a></li>
                  <li><a href="#B" data-toggle="tab"><font size="3">使用功能</font></a></li>
                  <li><a href="#C" data-toggle="tab"><font size="3">用户设置</font></a></li>
                  <li><a href="#D" data-toggle="tab"><font size="3">帮助界面</font></a></li>
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
                      <img class="first-slide" src="../img/1.jpg"  alt="First slide">
                      <div class="container">
                          <div class="carousel-caption">
                              <h1>标题一</h1>
                              <p>段落一</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="A" data-toggle="tab"role="button">按钮一</a></p>
                          </div>
                      </div>
                  </div>
                  <div class="item">
                      <img class="second-slide" src="" alt="Second slide">
                      <div class="container">
                          <div class="carousel-caption">
                              <h1>标题二</h1>
                              <p>段落二</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#B" data-toggle="tab"role="button">按钮二</a></p>
                          </div>
                      </div>
                  </div>
                  <div class="item">
                      <img class="third-slide" src="" alt="Third slide">
                      <div class="container">
                          <div class="carousel-caption">
                              <h1>标题三</h1>
                              <p>段落三</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#C" role="button">按钮三</a></p>
                          </div>
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
                      <img class="img-circle" src="" alt="Generic placeholder image" width="140" height="140">
                      <h2>Heading</h2>
                      <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
                      <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                  </div><!-- /.col-lg-4 -->
                  <div class="col-lg-4">
                      <img class="img-circle" src="" alt="Generic placeholder image" width="140" height="140">
                      <h2>Heading</h2>
                      <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
                      <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                  </div><!-- /.col-lg-4 -->
                  <div class="col-lg-4">
                      <img class="img-circle" src="" alt="Generic placeholder image" width="140" height="140">
                      <h2>Heading</h2>
                      <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                      <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                  </div><!-- /.col-lg-4 -->
              </div><!-- /.row -->


              <!-- START THE FEATURETTES -->

              <hr class="featurette-divider">

              <div class="row featurette">
                  <div class="col-md-7">
                      <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
                      <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                  </div>
                  <div class="col-md-5">
                      <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
                  </div>
              </div>

              <hr class="featurette-divider">

              <div class="row featurette">
                  <div class="col-md-7 col-md-push-5">
                      <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
                      <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                  </div>
                  <div class="col-md-5 col-md-pull-7">
                      <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
                  </div>
              </div>

              <hr class="featurette-divider">

              <div class="row featurette">
                  <div class="col-md-7">
                      <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
                      <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                  </div>
                  <div class="col-md-5">
                      <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
                  </div>
              </div>

              <hr class="featurette-divider">

              <!-- /END THE FEATURETTES -->


              <!-- FOOTER -->
              <footer>
                  <p class="pull-right"><a href="#">返回顶部</a></p>
                  <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
              </footer>

          </div><!-- /.container -->
      </div>
      <div class="tab-pane fade" id="B">
          <!-- 功能主页实现 -->
          <div class="container-fluid">
              <div class="col-sm-3 col-md-2 sidebar">
                  <ul class="nav nav-sidebar">
                      <li class="active"><a href="#0"data-toggle="tab">功能概览</a></li>
                      <li><a href="#1" data-toggle="tab">查询车辆信息</a></li>
                      <li><a href="#2" data-toggle="tab">上传车辆信息</a></li>
                      <li><a href="#3" data-toggle="tab">查询客户预约</a></li>
                      <li><a href="#4" data-toggle="tab">进行消息推送</a></li>
                      <!--功能可以继续扩展-->
                  </ul>
              </div>
              <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                  <!-- 控制输出内容在右半部分 -->
                  <div class="tab-content">
                      <div class="tab-pane fade in active" id="0">
                          <p>
                              功能概览
                          </p>
                      </div>
                      <div class="tab-pane fade" id="1">

                          <p>
                              <font size="4">
                                  在这里你可以查看你旗下的车辆信息
                              </font>
                          </p></br>


                          <form action="/Search">
                          <div class="btn-group pull-left" style="margin-left: 20px;">
                              <button id="queryBtn1" type="button" class="btn btn-default" >
                                  <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
                          </div>
                          <p></br></br>
                              <font size="4">
                                  查询结果
                              </font>
                          </p></br>

                          <table class="table table-bordered table-striped">
                              <thead>
                              <tr>
                                  <th>#</th>
                                  <th>first</th>
                                  <th>second</th>
                                  <th>thrid</th>
                                  <th>fourth</th>
                                  <th>fifth</th>
                              </tr>
                              <tr>
                                  <td>1</td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                              </tr>
                              <tr>
                                  <td>2</td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                              </tr>
                              <tr>
                                  <td>3</td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                                  <td> </td>
                              </tr>
                              </thead>
                          </table>
                              </form>
                      </div>

                      <!--
                      <div class="tab-pane fade" id="1">
                      <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                          <div class="form-inline">
                          <button id="queryBtn" type="button" class="btn btn-default" >
                          <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>

                          <button id="btn_edit" type="button" class="btn btn-default" >
                          <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改</button>

                          <button id="btn_delete" type="button" class="btn btn-default" onClick="erpdel();">
                          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>
                          <button id="addBtn" type="button" class="btn btn-default">
                          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增</button>
                          </div>
                      </div>
                      </div>
                      -->

                      <div class="tab-pane fade" id="2">
                          <p>
                              <font size="4">
                                  在这里你可以上传你旗下的车辆信息
                              </font>
                          </p></br>
                          <form role="form">
                              <div class="form-group">
                                  <label for="name">车辆属性一</label>
                                  <input type="text" class="form-control" id="first"
                                         placeholder="请输入属性一">
                              </div>
                              <div class="form-group">
                                  <label for="name">车辆属性二</label>
                                  <input type="text" class="form-control" id="second"
                                         placeholder="请输入属性二">
                              </div>
                              <div class="form-group">
                                  <label for="name">车辆属性三</label>
                                  <input type="text" class="form-control" id="third"
                                         placeholder="请输入属性三">
                              </div>
                          </form>
                          <!--
                          <div class="form-group">
                              <label for="inputfile">车辆展示图片上传</label>
                              <input type="file" id="inputfile">
                              <p class="help-block">请选择文件图片上传</p>

                          </div>
                          -->

                          <div class="btn-group pull-left" style="margin-left: 20px;">
                              <button id="addBtn" type="button" class="btn btn-default">
                                  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>上传</button>
                          </div>
                      </div>

                      <div class="tab-pane fade" id="3">
                          <p>
                              <font size="4">
                                  在这里你可以查看你旗下的客户预约
                              </font>
                          </p></br>
                          <div class="btn-group pull-left" style="margin-left: 20px;">
                              <button id="queryBtn2" type="button" class="btn btn-default" >
                                  <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
                          </div>
                          <p></br></br>
                              <font size="4">
                                  查询结果
                              </font>
                          </p></br>

                          <table class="table table-bordered table-striped">

                              <thead>
                              <tr>
                                  <th>序号</th>
                                  <th>客户姓名</th>
                                  <th>预约类型</th>
                                  <th>预约时间</th>
                                  <th>预约状态</th>
                                  <th>联系方式</th>
                              </tr>
                              </thead>
                              <tbody>
                              <th>序号</th>
                              <th><%=appointment.getCustomer_name()%></th>
                              <th><%=appointment.getAppoint_type()%></th>
                              <th><%=appointment.getAppoint_time()%></th>
                              <th><%=appointment.getAppoint_state()%></th>
                              <th><%=appointment.getCustomer_call()%></th>

                              </tbody>
                          </table>
                      </div>
                      <div class="tab-pane fade" id="4">
                          <p>
                              功能4
                          </p>
                      </div>
                      <!--具体功能实现区-->
                  </div>
              </div>
          </div>
      </div>
      <div class="tab-pane fade" id="C">
          <p>
              用户设置
          </p>
      </div>
      <div class="tab-pane fade" id="D">
          <p>
              帮助界面
          </p>
      </div>
  </div>


  </body>
</html>