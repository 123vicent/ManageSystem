<%@ page import="basic.Shopapt" %>
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
                  <li><a href="#A" data-toggle="tab"><font size="3">系统主页</font></a></li>
                  <li><a href="#B" class="active" data-toggle="tab"><font size="3">使用功能</font></a></li>
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
      <div class="tab-pane fade" id="A">
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
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#B" data-toggle="tab"role="button">马上使用功能</a></p>
                          </div>
                      </div>
                  </div>
                  <div class="item">
                      <img class="second-slide" src="" alt="Second slide">
                      <div class="container">
                          <div class="carousel-caption">
                              <h1>标题二</h1>
                              <p>段落二</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#C" data-toggle="tab"role="button">查看用户设置</a></p>
                          </div>
                      </div>
                  </div>
                  <div class="item">
                      <img class="third-slide" src="" alt="Third slide">
                      <div class="container">
                          <div class="carousel-caption">
                              <h1>标题三</h1>
                              <p>段落三</p>
                              <p><a class="btn btn-lg btn-primary" data-toggle="tab" href="#D" role="button">查看帮助界面</a></p>
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
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>Heading</h2>
          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="../img/team.jpg" alt="Generic placeholder image" width="140" height="140">
          <h2>关于我们</h2>
          <p>团队介绍</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->/.col-lg-4 -->
              </div><!-- /.row -->


      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">
          汽车销售管理系统 精细化管理客户</br> <span class="text-muted">  </span></h2>
          <p class="lead">专为汽车4S店、二手车、新车经销商设计的车辆销售管理系统。系统功能强大、操作简单、容易上手。 程序化快速建档，自有服务器存储海量客户，避免客户数据丢失；意向客户及保险到期及时提醒，方便执行</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="../img/car-manage.png" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">精细化管理客户 <span class="text-muted">  </span></h2>
          <p class="lead">程序化快速建档，自有服务器存储海量客户，避免客户数据丢失；意向客户及保险到期及时提醒，方便执行</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="../img/client_manage.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">员工满意度提升 <span class="text-muted">  </span></h2>
          <p class="lead">详细记录客户信息，更好的把控客户进度，以业绩为导向，通过目标管理聚焦关键任务，形成团队协同力。</p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="../img/service.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
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
      <div class="tab-pane fade in active" id="B">
          <!-- 功能主页实现 -->
          <div class="container-fluid">
              <div class="col-sm-3 col-md-2 sidebar">
                  <ul class="nav nav-sidebar">
                      <li><a href="#0"data-toggle="tab">功能概览</a></li>
                      <li><a href="#1" data-toggle="tab">查询车辆信息</a></li>
                      <li><a href="#2" data-toggle="tab">上传车辆信息</a></li>
                      <li  class="active"><a href="#3" data-toggle="tab">查询客户预约</a></li>
                      <li><a href="#4" data-toggle="tab">进行消息推送</a></li>
                      <!--功能可以继续扩展-->
                  </ul>
              </div>
              <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                  <!-- 控制输出内容在右半部分 -->
                  <div class="tab-content">
                      <div class="tab-pane fade " id="0">
                          <p>
							<font size="4">
							在这里可以看到功能的概览
							</font>
                          </p>
                      </div>
              <div class="tab-pane fade" id="1">
                   <div>
                      <form action="/Search">
					    <p>
						<font size="4">
						在这里你可以查看你旗下的车辆信息
						</font>
					    </p></br>
						<form class="navbar-form navbar-left">
							<select style="width:100px;height:35px">
								<option value="null"></option>
								<option value="A1">A1</option>
								<option value="A2">A2</option>
								<option value="A3">A3</option>
							</select>
							<input type="text" class="form-control" name="customername" placeholder="输入信息..."></input>
						</form>
						<form class="navbar-form navbar-left">
							<select style="width:100px;height:35px">
								<option value="null"></option>
								<option value="B1">B1</option>
								<option value="B2">B2</option>
								<option value="B3">B3</option>
							</select>
							<input type="text" class="form-control" name="customername" placeholder="输入信息..."></input>
						</form>
						<form class="navbar-form navbar-left">
							<select style="width:100px;height:35px">
								<option value="null"></option>
								<option value="C1">C1</option>
								<option value="C2">C2</option>
								<option value="C3">C3</option>
							</select>
							<input type="text" class="form-control" name="customername" placeholder="输入信息..."></input>
								<button id="queryBtn2" type="button" class="btn btn-default" class="btn-group pull-left" style="margin-left: 10px;">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
                        </form>
                      </form>
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
                          <form action="/addcar">
                          <p>
                              <font size="4">
                                  在这里你可以上传你旗下的车辆信息
                              </font>
                          </p></br>
					<form role="form">
						<div>
	
							<label for="name">车辆属性一（选择）</label>
							<div>
							<select style="width:1000px;height:35px">
								<option value="value1">11111</option>
								<option value="value2">22222</option>
								<option value="value3">33333</option>
							</select>
							</div>
							<div>
							<label for="name">车辆属性二（自填）</label>
							<input style="width:1000px" type="text" class="form-control" 
							placeholder="请输入属性二">
							</div>
							<div>
							<label for="name">车辆属性三</label>
							<input style="width:1000px" type="text" class="form-control" 
							placeholder="请输入属性三">
							</div>
						</div>
					</form>                          <!--
                          <div class="form-group">
                              <label for="inputfile">车辆展示图片上传</label>
                              <input type="file" id="inputfile">
                              <p class="help-block">请选择文件图片上传</p>

                          </div>
                          -->
					</br>
                          <div class="btn-group pull-left" style="margin-left: 20px;">
                              <button id="addBtn" type="button" class="btn btn-default">
                                  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>上传</button>
                          </div>
                          </form>
                      </div>

                      <div class="tab-pane fade in active" id="3">
                          <p>
                              <font size="4">
                                  在这里你可以查看你旗下的客户预约
                              </font>
                          </p></br>
						<form action="/handlebook" class="navbar-form navbar-left">
							<select name="appointstate" style="width:100px;height:35px">
								<option value=""></option>
								<option >全部预约</option>
								<option >已处理预约</option>
								<option >未处理预约</option>
							</select>
                            <select name="appointtype" style="width:100px;height:35px">
                                <option value=""></option>
                                <option >试驾预约</option>
                                <option >保养预约</option>
                                <option >购车预约</option>
                            </select>
							<input type="text" class="form-control" name="customername" placeholder="输入需要查询的客户姓名"></input>
								<button id="queryBtn2" type="submit" class="btn btn-default" class="btn-group pull-left" style="margin-left: 10px;">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
						</form>
					<p></br></br></br>
                              <font size="4">
                                  查询结果
                              </font>
                          </p></br>

                          <table class="table table-bordered table-striped">

                              <thead>
                              <tr>
                                  <th>预约号</th>
                                  <th>客户姓名</th>
                                  <th>联系方式</th>
                                  <th>预约类型</th>
                                  <th>预约时间</th>
                                  <th>预约状态</th>
                              </tr>
                              </thead>
                              <%List<Shopapt> shopapts = (List<Shopapt>) request.getAttribute("userapoint");
                                  int i = 0;%>
                              <%for(Shopapt shopapt:shopapts){%>
                              <tr>
                              <th><%=i%></th>
                              <th><%=shopapt.getCus_name()%></th>
                              <th><%=shopapt.getCus_phone()%></th>
                              <th><%=shopapt.getAp_type()%></th>
                              <th><%=shopapt.getAp_time()%></th>
                              <th><%=shopapt.getAp_state()%></th>
                              <%i++;%>
                              <%}%>
                              </tr>
                              </tbody>
                          </table>
                      </div>
				<div class="tab-pane fade" id="4">
					<p>
						<font size="4">
							在这里可以进行微信端的消息推送
						</font>
					</p>
					<form role="form" action="/sendMessage">
						<div>
							<textarea name="customermessage" style="width:1000px;" rows="5" warp="virtual" placeholder="输入要推送给客户的信息"></textarea>
						</div>
						<div class="btn-group pull-left" style="margin-left: 0px;">
							<button id="addBtn" type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>推送</button>
						</div>
					</form>
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