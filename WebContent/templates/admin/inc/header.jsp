<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Quản Lý Gym</title>
	<link href="<%=request.getContextPath() %>/templates/admin/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath() %>/templates/admin/css/bootstrap-switch.min.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/admin/css/style.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/admin/css/style-1.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/admin/css/bootstrap-datepicker.css">
	<link href="<%=request.getContextPath() %>/templates/admin/css/animate.min.css" rel="stylesheet" media="screen">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/ckeditor/ckeditor.js"></script><style>.cke{visibility:hidden;}</style>
    <script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/ckfinder/ckfinder.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/bootbox.min.js"></script>
    <script src="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/moment.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/bootstrap_dropdown.js"></script>
  	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.css">
</head>
<body>
	<!-- header -->
	<header>
	<div class="navbar navbar-static-top bs-docs-nav">
		<div class="container">
			<nav class="collapse navbar-collapse bs-navbar-collapse ">
				<ul class="nav navbar-nav header-menu">
					<li><a href="<%=request.getContextPath() %>/admin/index"><img src="<%=request.getContextPath() %>/templates/admin/images/logo.png" alt="" class="img-circle" style="width:20px; height:20px; "></a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexUsers">KHÁCH HÀNG</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexRegister">HỘI VIÊN</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexTraining">GÓI TẬP</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/fitnessCategory">GIÁO ÁN</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexPost">BÀI ĐĂNG</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/indexProduct">SẢN PHẨM</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/historyOrder2">LỊCH SỬ BÁN HÀNG</a></li>
				</ul>
				<%
					User objAdmin = (User)session.getAttribute("objAdmin");
					if(objAdmin == null){
				%> 
				<div class="nav navbar-nav navbar-right ">
					<div class="header-login dropdown animated fadeInDown animation-delay-11">	
						<a href="<%=request.getContextPath() %>/admin/login" ><i class="fa fa-user"></i> Login</a>
					</div>
				</div>
					<%}else{ %>
				<div class="nav navbar-nav navbar-right ">
					<div class="header-login dropdown animated fadeInDown animation-delay-11">	
						<a href="<%=request.getContextPath() %>/admin/loout" ><i class="fa fa-user"></i> Logout</a>
					</div>
				</div>	
					<%} %>
			</nav>
		</div>
	</div>
	<div class="header-banner">
		<img src="<%=request.getContextPath() %>/templates/admin/images/logo-tapthehinh1.png">
	</div>
	</header>
	<!-- end header -->