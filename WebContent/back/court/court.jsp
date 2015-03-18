<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="com.court.model.*"%>

<%
	CourtService cSvc = new CourtService();
	List<CourtVO> list = cSvc.getAll();
	pageContext.setAttribute("list",list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>追求卓越後端系統</title>

    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- start: CSS -->
    <link href="css/icon.css" rel="stylesheet">
    <link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <link id="base-style" href="css/style.css" rel="stylesheet">
    <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
    <!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'> -->
    <!-- myStyleCss -->
   
    <link href="css/myStyle.css" rel="stylesheet">


    <!-- end: CSS -->


    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->

    <!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->

    <!-- start: Favicon -->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- end: Favicon -->




</head>

<body>
    <!-- start: Header -->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="index.html"><span>追求卓越後端管理系統</span></a>

                <!-- start: Header Menu -->
                <div class="nav-no-collapse header-nav">
                    <ul class="nav pull-right">
                        <li class="dropdown hidden-phone">
                            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="halflings-icon white warning-sign"></i>
                            </a>
                            <ul class="dropdown-menu notifications">
                                <li class="dropdown-menu-title">
                                    <span>You have 11 notifications</span>
                                    <a href="#refresh"><i class="icon-repeat"></i></a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon blue"><i class="icon-user"></i></span>
                                        <span class="message">New user registration</span>
                                        <span class="time">1 min</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon green"><i class="icon-comment-alt"></i></span>
                                        <span class="message">New comment</span>
                                        <span class="time">7 min</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon green"><i class="icon-comment-alt"></i></span>
                                        <span class="message">New comment</span>
                                        <span class="time">8 min</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon green"><i class="icon-comment-alt"></i></span>
                                        <span class="message">New comment</span>
                                        <span class="time">16 min</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon blue"><i class="icon-user"></i></span>
                                        <span class="message">New user registration</span>
                                        <span class="time">36 min</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon yellow"><i class="icon-shopping-cart"></i></span>
                                        <span class="message">2 items sold</span>
                                        <span class="time">1 hour</span>
                                    </a>
                                </li>
                                <li class="warning">
                                    <a href="#">
                                        <span class="icon red"><i class="icon-user"></i></span>
                                        <span class="message">User deleted account</span>
                                        <span class="time">2 hour</span>
                                    </a>
                                </li>
                                <li class="warning">
                                    <a href="#">
                                        <span class="icon red"><i class="icon-shopping-cart"></i></span>
                                        <span class="message">New comment</span>
                                        <span class="time">6 hour</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon green"><i class="icon-comment-alt"></i></span>
                                        <span class="message">New comment</span>
                                        <span class="time">yesterday</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon blue"><i class="icon-user"></i></span>
                                        <span class="message">New user registration</span>
                                        <span class="time">yesterday</span>
                                    </a>
                                </li>
                                <li class="dropdown-menu-sub-footer">
                                    <a>View all notifications</a>
                                </li>
                            </ul>
                        </li>
                        <!-- start: Notifications Dropdown -->
                   
                        <!-- end: Notifications Dropdown -->
                        <!-- start: Message Dropdown -->
                        <li class="dropdown hidden-phone">
                            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="halflings-icon white envelope"></i>
                            </a>
                            <ul class="dropdown-menu messages">
                                <li class="dropdown-menu-title">
                                    <span>You have 9 messages</span>
                                    <a href="#refresh"><i class="icon-repeat"></i></a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
                                        <span class="header">
											<span class="from">
										    	超級管理員
										     </span>
                                        <span class="time">
										    	6 min
										    </span>
                                        </span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
                                        <span class="header">
											<span class="from">
										    	超級管理員
										     </span>
                                        <span class="time">
										    	56 min
										    </span>
                                        </span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
                                        <span class="header">
											<span class="from">
										    	超級管理員
										     </span>
                                        <span class="time">
										    	3 hours
										    </span>
                                        </span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
                                        <span class="header">
											<span class="from">
										    	超級管理員
										     </span>
                                        <span class="time">
										    	yesterday
										    </span>
                                        </span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
                                        <span class="header">
											<span class="from">
										    	超級管理員
										     </span>
                                        <span class="time">
										    	Jul 25, 2012
										    </span>
                                        </span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a class="dropdown-menu-sub-footer">View all messages</a>
                                </li>
                            </ul>
                        </li>
                        <!-- end: Message Dropdown -->
                        <li>
                            <a class="btn" href="#">
                                <i class="halflings-icon white wrench"></i>
                            </a>
                        </li>
                        <!-- start: User Dropdown -->
                        <li class="dropdown">
                            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="halflings-icon white user"></i> 超級管理員
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-menu-title">
                                    <span>帳戶設定</span>
                                </li>
                                <li><a href="#"><i class="halflings-icon user"></i> 使用者資料</a>
                                </li>
                                <li><a href="login.html"><i class="halflings-icon off"></i> 登出</a>
                                </li>
                            </ul>
                        </li>
                        <!-- end: User Dropdown -->
                    </ul>
                </div>
                <!-- end: Header Menu -->

            </div>
        </div>
    </div>
    <!-- start: Header -->

    <div class="container-fluid-full">
        <div class="row-fluid">

            <!-- start: Main Menu -->
            <div id="sidebar-left" class="span2">
                <div class="nav-collapse sidebar-nav">
                    <ul class="nav nav-tabs nav-stacked main-menu">
                    	<li><a href="index.html"><i class="icon-home"></i><span class="hidden-tablet">Home</span></a></li>
                        <!-- <li><a href="index.html"><i class="icon-bar-chart"></i><span class="hidden-tablet"> Dashboard</span></a>
                        </li> -->
                        <li><a href="messages.html"><i class="icon-user"></i><span class="hidden-tablet"> 一般會員資料管理</span></a>
                        </li>
                        <li><a href="tasks.html"><i class="icon-user"></i><span class="hidden-tablet"> 主辦單位會員審核</span></a>
                        </li>
                        <li><a href="ui.html"><i class="icon-calendar"></i><span class="hidden-tablet"> 賽事管理</span></a>
                        </li>
                        <li><a href="widgets.html"><i class="icon-dashboard"></i><span class="hidden-tablet"> 對戰資料管理</span></a>
                        </li>
                        <li>
                            <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 訂單管理</span><span class="label label-important"> 3 </span></a>
                            <ul>
                                <li><a class="submenu" href="submenu.html"><i class="icon-file-alt"></i><span class="hidden-tablet"> 審核</span></a>
                                </li>
                                <li><a class="submenu" href="submenu2.html"><i class="icon-file-alt"></i><span class="hidden-tablet"> 付款</span></a>
                                </li>
                                <li><a class="submenu" href="submenu3.html"><i class="icon-file-alt"></i><span class="hidden-tablet"> 出貨</span></a>
                                </li>
                            </ul>
                        </li>
                        <li><a href="form.html"><i class="icon-edit"></i><span class="hidden-tablet"> 商品管理</span></a>
                        </li>
                        <li><a href="chart.html"><i class="icon-list-alt"></i><span class="hidden-tablet"> 場地管理</span></a>
                        </li>
                        <li><a href="typography.html"><i class="icon-camera"></i><span class="hidden-tablet"> 精彩瞬間管理</span></a>
                        </li>
                        <li><a href="gallery.html"><i class="icon-picture"></i><span class="hidden-tablet"> 友站連結管理</span></a>
                        </li>
                        <li><a href="table.html"><i class="icon-comments"></i><span class="hidden-tablet"> 討論區管理</span></a>
                        </li>
                        <li><a href="calendar.html"><i class="icon-cog"></i><span class="hidden-tablet"> 後端權限管理</span></a>
                        </li>

                        <li><a href="login.html"><i class="icon-lock"></i><span class="hidden-tablet"> 登入頁面</span></a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- end: Main Menu -->

            <noscript>
                <div class="alert alert-block span10">
                    <h4 class="alert-heading">Warning!</h4>
                    <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
                </div>
            </noscript>

            <!-- start: Content -->
            <div id="content" class="span10">

                <!-- breadcrumb -->
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="index.html">Home</a> 
                    <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">場地管理</a></li>
            </ul>


                <!-- main -->
                <!-- custom.js row per page -->
                <!-- MEMBER LIST START -->
            <div class="row-fluid sortable">        
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon user"></i><span class="break"></span>場地管理</h2>
                        <div class="box-icon">
                            <a href="#" class="btn-setting"><span class="label label-primary">列出所有</span></a>
                            <a href="#" class="btn-setting"><span class="label label-purple">列出所有</span></a>
                            <a href="#" class="btn-setting"><span class="label label-success">已審核</span></a>
                            <a href="#" class="btn-setting"><span class="label label-warning">待審核</span></a>
                            <a href="#" class="btn-setting"><span class="label">已失效</span></a>
                            <a href="#" class="btn-setting"><span class="label label-important"><i class="halflings-icon plus"></i>新增</span></a>
                            <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                            <!-- <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a> -->
                        </div>
                    </div>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                          <thead>
                              <tr>
                                  <th>場地編號</th>
                                  <th>場地名稱</th>
                                  <th>連絡電話</th>
                                  <th>最後修改時間</th>
                                  <th>狀態</th>
                                  <th>處理方式</th>
                              </tr>
                          </thead>   
                          <tbody>
<c:forEach var="courtVO" items="${list}">
    <tr align='center' valign='middle' ><!--將修改的那一筆加入對比色而已-->
            <td class="center">${courtVO.cid}</td>
			<td class="center">${courtVO.cname}</td>
			<td class="center">${courtVO.ctel}</td>
			<td class="center">${courtVO.cedit}</td>
			<td class="center">
			<c:if test="${courtVO.cstatus==0}"><span class="label label-warning">待審核</span></c:if>
			<c:if test="${courtVO.cstatus==1}"><span class="label label-success">已審核</span></c:if>
			<c:if test="${courtVO.cstatus==2}"><span class="label">已失效</span></c:if>
			<c:if test="${courtVO.cstatus==3}"><span class="label label-important">失效中的失效</span></c:if>
			
			</td>
                                
                                
                                
                   
                                <td class="center">
                                    <a class="btn btn-success" href="#">
                                        <i class="halflings-icon white zoom-in"></i>                                            
                                    </a>
                                    <a class="btn btn-info" href="#">
                                        <i class="halflings-icon white edit"></i>                                            
                                    </a>
                                    <c:if test="${courtVO.cstatus!=2}">
                                    <a class="btn btn-inverse" href="#">
                                        <i class="halflings-icon white trash"></i> 
                                    </a>
                                    </c:if>
                                </td>
     </tr>
</c:forEach>
 
     
       
                            
                          </tbody>
                      </table>            
                    </div>
                </div><!--/span-->
            
            </div><!--/row-->
            <!-- MEMBER LIST END -->
   
                <!-- main end -->



            </div>
            <!--/.fluid-container-->

            <!-- end: Content -->
        </div>
        <!--/#content.span10-->
    </div>
    <!--/fluid-row-->

	<div class="modal hide fade" id="myModal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <h3>新增</h3>
        </div>
        <div class="modal-body">
            <p>您要新增一筆場地資料嗎?</p>
        </div>
        <div class="modal-footer">
            <a href="#" class="btn" data-dismiss="modal">取消</a>
            <a href="#" class="btn btn-primary">確定</a>
        </div>
    </div>

    <div class="clearfix"></div>

    <footer>

        <div class="footer_right">
            <a href="/help">[尋求管理員幫助?]</a>

        </div>

    </footer>

    <!-- start: JavaScript-->

    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/jquery-migrate-1.0.0.min.js"></script>

    <script src="js/jquery-ui-1.10.0.custom.min.js"></script>

    <script src="js/jquery.ui.touch-punch.js"></script>

    <script src="js/modernizr.js"></script>

    <script src="js/bootstrap.min.js"></script>

    <script src="js/jquery.cookie.js"></script>

    <script src='js/fullcalendar.min.js'></script>

    <script src='js/jquery.dataTables.js'></script>

    <script src="js/excanvas.js"></script>
    <script src="js/jquery.flot.js"></script>
    <script src="js/jquery.flot.pie.js"></script>
    <script src="js/jquery.flot.stack.js"></script>
    <script src="js/jquery.flot.resize.min.js"></script>

    <script src="js/jquery.chosen.min.js"></script>

    <script src="js/jquery.uniform.min.js"></script>

    <script src="js/jquery.cleditor.min.js"></script>

    <script src="js/jquery.noty.js"></script>

    <script src="js/jquery.elfinder.min.js"></script>

    <script src="js/jquery.raty.min.js"></script>

    <script src="js/jquery.iphone.toggle.js"></script>

    <script src="js/jquery.uploadify-3.1.min.js"></script>

    <script src="js/jquery.gritter.min.js"></script>

    <script src="js/jquery.imagesloaded.js"></script>

    <script src="js/jquery.masonry.min.js"></script>

    <script src="js/jquery.knob.modified.js"></script>

    <script src="js/jquery.sparkline.min.js"></script>

    <script src="js/counter.js"></script>

    <script src="js/retina.js"></script>

    <script src="js/custom.js"></script>
    <!-- end: JavaScript-->



</body>
</html>