<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="basic.Shopapt" %>
<%@ page import="java.util.List" %>
<%@ page import="basic.KeyValuePair" %><%--
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
    <title>汽车销售管理系统-查询预约</title>
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
		<link href="../style/css/style1.css" rel="stylesheet">
		<script src="../style/js/jquery-1.7.1.min.js"></script>
		<script src="../style/js/ui.js"></script>
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
		
		<!--上方导航栏-->
	    <nav class="navbar navbar-inverse navbar-fixed-top">
		    <div class="container-fluid">
				<div class="navbar-header">
					<img src="../../style/images/mainlogo.png" style="width:50px">
				</div>
			    <div class="navbar-header">
		  		    <p class="navbar-brand" ><font size="5">汽车销售管理系统</font></p>
			    </div>
			    <div>
				    <p id= "huanying" class="navbar-brand" align="right"><font size="4">用户：<a href="/SwitchPage?page=setpage">${userid}</a> </font></p>
			    </div>

			    <div id="navbar" class="navbar-collapse collapse">
				    <ul class="nav navbar-nav navbar-right">
						<li><a href="/SwitchPage?page=homepage" ><font size="3">系统主页</font></a></li>
						<li><a href="/SwitchPage?page=funcpage" class="active" ><font size="3">使用功能</font></a></li>
						<li><a href="/SwitchPage?page=setpage" ><font size="3">用户设置</font></a></li>
						<li><a href="/SwitchPage?page=helppage" ><font size="3">帮助界面</font></a></li>
				    </ul>
			    </div>
		    </div>
	    </nav>
		<!--//上方导航栏-->
		
		
		<!--内容-->
	    <div class="container-fluid">
		
			<!-- 左边导航栏 -->
		    <div class="col-sm-3 col-md-2 sidebar">
			    <ul class="nav nav-sidebar">
					<li><a href="/SwitchPage?page=funcpage">功能概览</a></li>
					<li><a href="/SwitchPage?page=funcViewCar" >查询车辆信息</a></li>
					<li><a href="/SwitchPage?page=funcUploadCar" >上传车辆信息</a></li>
					<li class="active"><a href="/SwitchPage?page=funcViewAppointment" >查询客户预约</a></li>
					<li><a href="/SwitchPage?page=funcPushMsg" >发布通知</a></li>
					<li><a href="/SwitchPage?page=funcRegister" >登记客户车辆</a></li>
					<li><a href="/SwitchPage?page=funcViewReg" >查询登记车辆</a></li>
					<li><a href="/SwitchPage?page=funcViewRecord" >查看浏览记录</a></li>
					<li><a href="/SwitchPage?page=funcDataAnalyze" >浏览数据分析</a></li>
				    <!--功能可以继续扩展-->
			    </ul>
		    </div>
			<!-- //左边导航栏 -->

			<!-- 控制输出内容在右半部分 -->
		    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			    
			    <div class="tab-content">
					<!--查询客户预约-->
					<p>
						<font size="6">
							在这里你可以查看你旗下的客户预约
						</font>
					</p>
					</br>
					<form action="/handlebook" class="navbar-form navbar-left" style="margin-left: -15px">
						<label>预约状态</label>
						<select name="appointstate" style="width:100px;height:33px">
							<option >全部预约</option>
							<option >待接受</option>
							<option >已接受</option>
							<option >已完成</option>
							<option >已拒绝</option>
							<option >已取消</option>
						</select>
						<label>预约类型</label>
						<select name="appointtype" style="width:100px;height:33px">
							<option >全部预约</option>
							<option >试驾预约</option>
							<option >维修预约</option>
							<option >保养预约</option>
						</select>
						<input type="text" class="form-control" name="customername" placeholder="输入需要查询的客户姓名"></input>
						<input type="text" class="form-control" name="ap_id" placeholder="输入需要查询的预约号"></input>
						<button id="queryBtn2" type="submit" class="btn btn-default" class="btn-group pull-left" style="margin-left: 10px;">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询</button>
					</form>
					<p>
					</br>
					</br>
					</br>
					<font size="4">
						查询结果
					</font>
					</p>
					</br>


						<table class="table table-bordered table-striped">

							<thead>
							<tr>
								<th>预约号</th>
								<th>品牌</th>
								<th>型号</th>
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
								<th><%=shopapt.getAppointment_id()%></th>
								<th><%=shopapt.getBrand()%></th>
								<th><%=shopapt.getModel()%></th>
								<th><%=shopapt.getCus_name()%></th>
								<th><%=shopapt.getCus_phone()%></th>
								<th><%=shopapt.getAp_type()%></th>
								<th><%=shopapt.getAp_time()%></th>
								<th><%=shopapt.getAp_state()%>
									<%if(shopapt.getAp_state().equals("待接受")||shopapt.getAp_state().equals("已接受")){%>
									<a href="/dealapt?access=deal&value=<%=shopapt.getAppointment_id()%>" >
										<button  type="button" class="btn btn-success" class="btn-group pull-left" style="margin-left: 10px;">
										处理</button>
									</a>
									</th>
								<%}else{%>
								<a href="/dealapt?access=check&value=<%=shopapt.getAppointment_id()%>" >
									<button  type="button" class="btn btn-primary" class="btn-group pull-left" style="margin-left: 10px;">
										查看</button>
								</a>
								</th>
								<%;}%>

								<%i++;%>
								<%}%>
							</tr>
							</tbody>
						</table>

					<input type="hidden" id="success" value=<%=request.getAttribute("success")%>>
					<input type="hidden" id="error" value=<%=request.getAttribute("error")%>>
					<!--//查询客户预约-->
			    </div>
		    </div>
			<!-- //控制输出内容在右半部分 -->

	    </div>

		<!--内容--> 
			
	    </div>
    </body>
</html>
<script>
    var error = document.getElementById("error").value;
    var success = document.getElementById("success").value;
    if(error.localeCompare(null)) {
        mizhu.alert('', error);
    }
    if(success.localeCompare(null)) {
        mizhu.alert('', success);
    }
</script>