<%@ page import="basic.Shopapt" %><%--
  Created by IntelliJ IDEA.
  User: 17308
  Date: 2018/7/4
  Time: 14:50
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
    <script language="javascript" type="text/javascript" src="../../style/js/My97DatePicker/WdatePicker.js"></script>

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
            <p class="navbar-brand" ><font size="5">汽车销售管理系统</font></p>
        </div>
        <div>
            <p id= "huanying" class="navbar-brand" align="right"><font size="4">欢迎您！<a href="/SearchUserServlet" name="userid">${userid}</a> </font></p>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="first.html" class="active" ><font size="3">系统主页</font></a></li>
                <li><a href="funcViewAppointment.html"  ><font size="3">使用功能</font></a></li>
                <li><a href="set.html" ><font size="3">用户设置</font></a></li>
                <li><a href="help.html" ><font size="3">帮助界面</font></a></li>
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
<!--//上方导航栏-->


<!--内容-->
<div class="container-fluid">

    <!-- 左边导航栏 -->
    <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
            <li><a href="funcOverview.html">功能概览</a></li>
            <li><a href="funcViewCar.html" >查询车辆信息</a></li>
            <li><a href="funcUploadCar.html" >上传车辆信息</a></li>
            <li class="active"><a href="funcViewAppointment.html" >查询客户预约</a></li>
            <li><a href="funcPushMsg.html" >进行消息推送</a></li>
            <li><a href="funcRegister.html" >登记客户车辆</a></li>
            <li><a href="funcViewReg.html" >查询登记车辆</a></li>
            <!--功能可以继续扩展-->
        </ul>
    </div>
    <!-- //左边导航栏 -->



    <!--查询所有车的类型型号，设置下拉框-->
    <!--//查询所有车的类型型号，设置下拉框-->



    <!-- 控制输出内容在右半部分 -->
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

        <div class="tab-content">
            <!--处理客户预约-->
            <h1 align="center">预约处理</h1>
            <div>
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
                    <%Shopapt shopapt = (Shopapt) request.getAttribute("shopapt");
                    %>
                    <tr>
                        <th><%=shopapt.getAppointment_id()%></th>
                        <th><%=shopapt.getBrand()%></th>
                        <th><%=shopapt.getModel()%></th>
                        <th><%=shopapt.getCus_name()%></th>
                        <th><%=shopapt.getCus_phone()%></th>
                        <th><%=shopapt.getAp_type()%></th>
                        <th><%=shopapt.getAp_time()%></th>
                        <th><%=shopapt.getAp_state()%></th>

                    </tr>
                    </tbody>
                </table>
            </div>

            <%if(shopapt.getAp_state().equals("待接受")){%>
            <div>
                <br><br>
                <form action="/dealingapt">
                    <input type="hidden" name="ap_id" value="<%=shopapt.getAppointment_id()%>"></input>
                    <div>
                        <button id="addBtn" type="submit" name="submit" value="接受预约" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>接受预约</button>
                    </div>
                    <div>
                        <br>
                        <br>
                        <label for="name">拒绝原因</label>
                        <div>
                            <textarea name="refusemsg" style="width:1000px;" rows="5" warp="virtual" placeholder="输入拒绝原因"></textarea>
                        </div>
                        <%if(request.getAttribute("error")!=null){ %>
                        <%=request.getAttribute("error")%>
                        <%  }%>
                        <div>
                            <br><br>
                            <button id="addBtn" type="submit" name="submit" value="拒绝预约" class="btn btn-default">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>拒绝预约</button>
                        </div>
                    </div>

                </form>
            </div>

            <%;}%>
            <%if(shopapt.getAp_state().equals("已接受")){%>
            <div>
                <br>
                <br>
                <form action="/dealingapt">
                    <input type="hidden" name="ap_id" value="<%=shopapt.getAppointment_id()%>"></input>
                    <div>
                        <div><label for="name">完成时间</label></div>
                        <input class="Wdate" name="complete_time" type="text" id="d15" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                        <div>
                            <br><br>
                            <label for="name">收款</label>
                        </div>
                        <input name="payment" style="width:500px" type="text" class="form-control"
                               placeholder="请输入收款数">
                    </div>
                    <div>
                        <br><br>
                        <label for="name">描述</label>
                        <div>
                            <textarea name="description" style="width:1000px;" rows="5" warp="virtual" placeholder="输入预约完成描述"></textarea>
                        </div>
                        <%if(request.getAttribute("error")!=null){ %>
                        <%=request.getAttribute("error")%>
                        <%  }%>
                        <div>
                            <br>
                            <button id="addBtn" type="submit" name="submit" value="完成预约" class="btn btn-default">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>完成预约</button>
                        </div>
                    </div>
                </form>
            </div>
            <%;}%>
            <form action="/dealingapt">
                <center>

                    <button id="addBtn" type="submit" name="submit" value="返回上一层" class="btn btn-default">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>返回上一层</button>
                </center>
            </form>
            <!--//处理客户预约-->
        </div>
    </div>
    <!-- //控制输出内容在右半部分 -->

</div>
<!--内容-->

</div>
</body>
</html>