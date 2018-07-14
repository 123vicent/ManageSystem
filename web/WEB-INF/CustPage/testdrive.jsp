<%@ page import="java.util.List" %>
<%@ page import="basic.Carview" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>testdrive</title> 
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
					<li><a class="active" href="/jump?action=testdrive"><i class="glyphicon glyphicon-eye-open"></i> 寻车试驾 </a></li>
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
						<h3>寻车试驾</h3>   
					</div> 
				</div>
				<!-- //banner -->

				<div class="w3agile agents">
					<h3 class="w3ls-title">寻找爱车</h3>
					<form action="/searchcar">
						<div class="input-group">
							<input type="text" name= "con" class="form-control" placeholder="查找..." style="width:80%" >
							<span class="input-group-btn">
							<button class="btn btn-default" type="submit">Go!</button>
							</span>
						</div><!-- /input-group -->
						<div>
							<lable>价格区间：¥</lable>
							<input type="text" name="min_price" style="width: 20%">--<input name="max_price"type="text"  style="width:20%">
						</div>
					</form>

					<% List<Carview> cars = (List<Carview>)request.getAttribute("cars");%>
					<%if(cars!=null){
					  	for(Carview car:cars){%>
					<div class="properties-bottom">
						<div class="properties-img">
							<img src=<%=car.getPic_url().split("--")[0]%> alt="">
							<div class="view-caption"><!--加rent-caption为蓝色-->
								<h4><span class="glyphicon glyphicon-eye-open"></span> <%=car.getBrand()%> </h4> <!--车辆简介-->
							</div>
							<div class="w3ls-buy">
								<a href="/jump?action=car_detail&carid=<%=car.getCar_id()%>&shopuserid=<%=car.getShopuser_id()%>">详细</a> <!--加class="rent"为蓝色-->
							</div>
						</div>
						<div class="w3ls-text">
							<h5><%=car.getModel()%></h5><!--车名-->
							<h6>¥<%=car.getPrice()%></h6><!--价格-->
						</div>
					</div>
					<%}}%>
					<!--<div class="properties-bottom">
						<div class="properties-img">
							<img src="../../style/images/1.jpg" alt="">
							<div class="view-caption rent-caption">
								<h4><span class="glyphicon glyphicon-eye-open"></span> 123 </h4>
							</div>
							<div class="w3ls-buy" >
								<a href="/jump?action=车辆信息" class="rent">详细</a>
							</div>
						</div>
						<div class="w3ls-text">
							<h5>Car2</h5>
							<h6>¥500k</h6>
						</div>
					</div>-->
					<div class="clearfix"> </div>
				</div>
				<!--<form action="/testdrive_book">
				<div class="w3agile agents">
					<h3 class="w3ls-title">试驾预约</h3>
						<div align="center">
						<button class="btn btn-default" type="submit" onclick="window.location.href='testdrive2.html'">进行预约</button>
						</div>
				</div>
				</form>-->
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