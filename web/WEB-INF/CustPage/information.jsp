<%@ page import="model.Customeruser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>imformation</title> 
<!-- For-Mobile-Apps-and-Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fortune Estates Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, SmartPhone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps-and-Meta-Tags -->
<!-- Custom Theme files -->
<link href="../../style/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="../../style/css/style.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="../../style/css/lightbox.css">

<!-- //Custom Theme files -->
<!-- js -->
<script src="../../style/js/jquery-2.2.3.min.js"></script>
<!-- //js -->
<!-- pop-up-box -->
<script src="../../style/js/jquery.magnific-popup.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$('.popup-top-anim').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
		});																							
	}); 
</script>
<!--//pop-up-box -->
<!-- web-fonts -->  
<link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- //web-fonts -->
</head>
<body class="bg">

	<div class="agile-main"> 
		<div class="menu-wrap" id="style-1"> 
			<nav class="top-nav">
				<ul class="icon-list">
					<li class="menu-title">CarManage</li>
					<li><a href="/jump?action=homepage"><i class="glyphicon glyphicon-home"></i> 主页 </a></li>
					<li><a class="active" href="/jump?action=personal_info"><i class="glyphicon glyphicon-info-sign"></i> 个人信息 </a></li>
					<li><a href="/jump?action=testdrive"><i class="glyphicon glyphicon-eye-open"></i> 寻车试驾 </a></li>
					<li><a href="/jump?action=viewcar"><i class="glyphicon glyphicon-picture"></i> 豪车鉴赏</a></li>
					<li><a href="/jump?action=reserve"><i class="glyphicon glyphicon-envelope"></i> 养修预约 </a></li>
					<li><a href="/jump?action=apt_record"><i class="glyphicon glyphicon-briefcase"></i> 预约历史 </a> </li>
					<li><a href="/jump?action=viewhistory"><i class="glyphicon glyphicon-list-alt"></i> 浏览历史</a></li>
				</ul>
			</nav>
			<button class="close-button" id="close-button">C</button>
		</div> 
		<div class="content-wrap">
			<div class="header"> 
				<div class="menu-icon">   
					<button class="menu-button" id="open-button">O</button>
				</div>

				<div class="clearfix"> </div>
			</div>
			<div class="content">
				<!-- banner -->
				<div class="banner about-banner"> 
					<div class="banner-img">  
						<h3>个人信息</h3>   
					</div> 
				</div>
				<!-- //banner -->
				<!-- agents -->
				<!--这里需要动态显示用户的信息-->
				<div class="w3agile agents"> 
					<h3 class="w3ls-title">个人信息</h3> 
					<div class="w3agent-grid">
						<img src="../../style/images/head.jpeg">
						<%--<form method="post" action="/uploadimg"  enctype="multipart/form-data">
						<div class="form-group">
							<input type="file" id="inputfile" style="width:100%" ></br>
							<button type="submit" class="btn btn-primary" name="uploadfile" data-dismiss="modal">上传头像</button>
						</div>
						</form>--%>

						<%--<form method="post" action="/uploadimg" enctype="multipart/form-data">
							选择一个文件:
							<input type="file" name="uploadFile" />
							<br/><br/>
							<input type="submit" value="头像上传" />
						</form>--%>

						<div class="w3agent-text">
							<%Customeruser customeruser = (Customeruser)request.getAttribute("user_info");%>
							<h4><%=customeruser.getCus_name()%></h4>
							<p><i class="glyphicon glyphicon-earphone"></i><%=customeruser.getCus_phone()%></p>
							<p><i class="glyphicon glyphicon-info-sign"></i> <%=customeruser.getSex()%></p>
							<p><i class="glyphicon glyphicon-user" aria-hidden="true"></i><a href="mailto:info@example.com"><%=customeruser.getBirthday()%></a></p>
							<p><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i><%=customeruser.getAddress()%></p>
						</div>
					</div>
					
					<div class="clearfix"> </div>
				</div>
				<!-- //agents --> 
				
				<div class="w3agile gallery"> 
					 
					
					
					
			
					<!-- 按钮触发模态框 -->
					<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="margin-left: 80px">
						点击修改
					</button>
					<!-- 模态框（Modal） -->
					<div class="lightboxOverlay" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" display:block;>
						<!--提交表-->
						<div class="w3agile properties">
							<div class="w3ls-related">   
								<h3 class="w3ls-title">用户信息</h3>
								<div class="contact-form"> 
									<form action="/modify">
										<input type="text" name="phone" placeholder="联系方式" required=""> 
										<input type="text" name="sex" placeholder="性别" required="">
										<input type="text" name="address" placeholder="地址" required=""> 
										<!--textarea name="Message" placeholder="Message" required=""></textarea-->
										<input type="submit" value="提交">
										<button type="button" class="btn btn-success" data-dismiss="modal">关闭</button>
									</form> 
								</div> 
							</div>
						</div>

					</div>

					<!--  light box js -->
					<script src="../../style/js/lightbox-plus-jquery.min.js"> </script>
					<!-- //light box js--> 					 
				</div>
				<!-- //gallery -->
			</div>
		</div>
	</div> 
	<!-- menu-js -->
	<script src="../../style/js/classie.js"></script>
	<script src="../../style/js/main.js"></script>
	<!-- //menu-js -->
	<script src="../../style/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box -->
	<!-- nicescroll-js -->
	<script src="../../style/js/jquery.nicescroll.min.js"></script>
	<script>
		$(document).ready(function() {
	  
			var nice = $("html").niceScroll();  // The document page (body)
		
			$("#div1").html($("#div1").html()+' '+nice.version);
		
			$("#boxscroll").niceScroll({cursorborder:"",cursorcolor:"#00F",boxzoom:true}); // First scrollable DIV
		});
	</script>
	<!-- //nicescroll-js -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../../style/js/bootstrap.js"></script>
</body>
</html>