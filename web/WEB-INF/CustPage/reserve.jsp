<%--
  Created by IntelliJ IDEA.
  User: rsh
  Date: 2018/7/5
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>reserve</title>
	<!-- For-Mobile-Apps-and-Meta-Tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Fortune Estates Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, SmartPhone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //For-Mobile-Apps-and-Meta-Tags -->
	<!-- Custom Theme files -->
	<link href="../../style/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="../../style/css/style.css" type="text/css" rel="stylesheet" media="all">
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
                overflowY: 'auto',
                closeBtnInside: true,
                preloader: false,
                midClick: true,
                removalDelay: 300,
                mainClass: 'my-mfp-zoom-in'
            });
        });

	</script>
	<style>
		.select-form{
			width: 100%;
			color: #999;
			background: none;
			outline: none;
			font-size: 0.9em;
			padding: .8em;
			margin-bottom: 1em;
			border: solid 1px #ccc;
			-webkit-appearance: none;
			border-radius: 3px;
			-webkit-border-radius: 3px;
			-moz-border-radius: 3px;
		}
	</style>
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
				<li><a href="/jump?action=personal_info"><i class="glyphicon glyphicon-info-sign"></i> 个人信息 </a></li>
				<li><a href="/jump?action=testdrive"><i class="glyphicon glyphicon-eye-open"></i> 寻车试驾 </a></li>
				<li><a href="/jump?action=viewcar"><i class="glyphicon glyphicon-picture"></i> 豪车鉴赏</a></li>
				<li><a class="active" href="/jump?action=reserve"><i class="glyphicon glyphicon-envelope"></i> 养修预约 </a></li>
				<li><a href="/jump?action=apt_record"><i class="glyphicon glyphicon-briefcase"></i> 预约历史 </a> </li>
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
					<h3>养修预约</h3>
				</div>
			</div>
			<!-- //banner -->
			<!-- contact -->
			<div class="w3agile contact">
				<h3 class="w3ls-title">预约保养维修</h3>
				<div class="contact-form">
					<form action="/MR_BookServlet" method="post">

						<span style="font-size: 14px;">姓名</span>
						<input type="text" name="name" placeholder="请填写您的真实姓名" required="" />
						<div style="margin-top: 10px;">
							<span style="font-size: 14px;">手机号码</span>
							<input type="text" name="phone" placeholder="请填写您的手机号码" maxlength="11" required="" />
						</div>
						<span style="font-size: 14px;">需维修或保养汽车车型</span>
						<select class="select-form" name="brand">
							<option value="">请选择品牌..</option>
							<option value="宝马">宝马</option>
							<option value="奔驰">奔驰</option>
						</select>
						<select class="select-form" name="model">
							<option value="">请选择车型..</option>
							<option value="X3">X3</option>
							<option value="X6">X6</option>
						</select>
						<span style="font-size: 14px;">意向服务点</span>
						<select class="select-form" name="province">
							<option value="">经销商省</option>
							<option value="北京">北京</option>
							<option value="湖北">湖北</option>
						</select>
						<select class="select-form" name="city">
							<option value="">经销商市</option>
							<option value="武汉">武汉</option>
							<option value="宜昌">宜昌</option>
						</select>
						<select class="select-form" name="shop">
							<option value="">经销商</option>
							<option value="1">1</option>
							<option value="任意一家">任意一家</option>
							<option value="AA汽车销售服务公司">AA汽车销售服务公司</option>
						</select>
						<div class="col-sm-12">
							<label class="radio-inline">
								<input type="radio" name="book" id="emp_add_repair1" value="保养预约" checked="checked"> 保养 </label>
							<label class="radio-inline">
								<input type="radio" name="book" id="emp_add_repair2" value="维修预约"> 维修 </label>
						</div>
						<span style="font-size: 14px;">计划到店时间</span>
						<select class="select-form" name="time">
							<option value="">计划到店时间..</option>
							<option value="当天">当天</option>
							<option value="三天内">三天内</option>
							<option value="一周内">一周内</option>
						</select>

						<textarea name="Message" placeholder="问题描述" required></textarea>
						<input type="submit" value="提交">
					</form>
				</div>
			</div>
			<!-- //contact -->
			<!-- brands -->
			<div class="w3agile brands">
				<h3 class="w3ls-title">合作品牌</h3>
				<div class="brands-info">
					<div class="brand-grids">
						<a href="#"><img src="../../style/images/b1.jpg" alt=""/></a>
					</div>
					<div class="brand-grids">
						<a href="#"><img src="../../style/images/b2.jpg" alt=""/></a>
					</div>
					<div class="brand-grids">
						<a href="#"><img src="../../style/images/b3.jpg" alt=""/></a>
					</div>
					<div class="brand-grids">
						<a href="#"><img src="../../style/images/b4.jpg" alt=""/></a>
					</div>
					<div class="brand-grids">
						<a href="#"><img src="../../style/images/b5.jpg" alt=""/></a>
					</div>
					<div class="brand-grids">
						<a href="#"><img src="../../style/images/b6.jpg" alt=""/></a>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<!-- //brands -->
			<!-- footer -->
			<div class="w3agile footer">


			</div>
		</div>
	</div>
</div>
<!-- menu-js -->
<script src="../../style/js/classie.js"></script>
<script src="../../style/js/main.js"></script>
<!-- //menu-js -->
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