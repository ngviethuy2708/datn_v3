<!DOCTYPE html>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="library.TimeConvert"%>
<%@page import="bean.User"%>
<%@page import="bean.Training"%>
<%@page import="bean.Product"%>
<%@page import="bean.Post"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>QUẢN LÝ GYM</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/admin/css/bootstrap-datepicker.css">	
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/templates/public/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/css/style.css">
  	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.css">
   	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
   	<script src="<%=request.getContextPath() %>/templates/public/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/moment.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/admin/css/style-1.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/templates/public/js/star-rating.js" type="text/javascript"></script> 
    <script src="<%=request.getContextPath() %>/templates/public/js/jquery-bootstrap-modal-steps.js" type="text/javascript"></script>   
<style>
.offer-tag {
    position: absolute;
    top: 0px;
    z-index: 1;
    background: url('<%=request.getContextPath() %>/templates/public/images/offer-tag.png') no-repeat;
    width: 80px;
    height: 70px;
    margin-left: -5px;
    margin-top: -3px;
}
p.off-price {
    -webkit-transform: rotate(-45deg);
    -moz-transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    -o-transform: rotate(-45deg);
    filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=3);
    color: #fff;
    font-size: 13px;
    font-weight: bold;

</style>
<body>
    <div class="header" style="background-color:#444444; z-index:1000;">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <a href="#"><img src="<%=request.getContextPath() %>/templates/public/images/logo-gym.png" alt="" style="width: 200px;height: 55px;"></a>
                </div>
                <div class="nav navbar-nav navbar-right ">
					<div class="header-login dropdown animated fadeInDown animation-delay-11">	
						<%
						User objUsers = (User)session.getAttribute("objUser");
						if(objUsers!=null){
						%>
						<a style="color:white;" href="" data-toggle="modal" data-target="#profile" ><i class="fa fa-user"></i><%=objUsers.getFullName() %></a>
						<a style="color:#00AEEF;" href="<%=request.getContextPath()%>/logout"> <span style="font-weight:bold">Log out</span></a>
						<%}else{ %>
						<span style="color:white;"><i class="fa fa-user">Khách</i></span>
						<a style="color:#00AEEF;" href="" data-toggle="modal" data-target="#login"> <span style="font-weight:bold">Login</span></a>
						<%} %>
					</div>
				</div> 
                <div class="col-lg-8 col-md-4 col-sm-12 col-xs-12" style="">
                     <div class="navigation">
                        <div id="navigation">
                            <ul>
                                <li class="active" ><a style="color:white" href="<%=request.getContextPath() %>/index" title="Home">TRANG CHỦ</a></li>
                                <li class="active" ><a style="color:white" href="index.html" title="Home">GIỚI THIỆU</a></li>
                                <li class="active" ><a style="color:white" href="index.html" title="Home">GÓI TẬP</a></li>
                                <li class="active" ><a style="color:white" href="<%=request.getContextPath() %>/indexProduct" title="Home">SẢN PHẨM</a></li>
                                <li class="active" ><a style="color:white" href="" title="Home" data-toggle="modal" data-target="#Excercises">BÀI TẬP</a></li>
                                <li class="active" ><a style="color:white" href="index.html" title="Home">TIN TỨC</a></li>
                                <li class="active" ><a style="color:white" href="index.html" data-toggle="modal" data-target="#signup" title="Home">ĐĂNG KÝ</a></li>
                                <%if(objUsers != null && objUsers.isMember() == true){ %>
                                <li class="active" ><a style="color:white" href="<%=request.getContextPath() %>/historyMember" title="Home">THẺ HỘI VIÊN</a></li>
                                <%} %>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
<div id="login" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color:#00AEEF;">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" style="text-align:center; color:white; font-weight:bold">ĐĂNG NHẬP WEBSITE</h4>
      </div>
      <div class="modal-body">
       	  <form action="<%=request.getContextPath() %>/login" class="templatemo-login-form">
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="username" name="username">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>	        		
		              	<input type="password" class="form-control" placeholder="******" name="password">           
		          	</div>	
	        	</div>	          	      
      </div>
      <div class="modal-footer">
        <input type="submit" class="btn btn-default" name="submit" value="Đăng nhập">
      </div>
      		</form>
    </div>

  </div>
</div>
<div id="profile" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color:#00AEEF;">
        <button type="button" class="close" data-dismiss="modal" >&times;</button>
        <h4 class="modal-title" style="text-align:center; color:white; font-weight:bold;">THÔNG TIN KHÁCH HÀNG</h4>
      </div>
      <div class="modal-body">
       	  <form action="<%=request.getContextPath() %>/editUser" class="templatemo-login-form">
       	  		<%
       	  		User objUser = new User();
       	  		if(session.getAttribute("objUser") != null){
       	  			objUser = (User)session.getAttribute("objUser");
       	  		}
       	  		%>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="username" name="userName" value="<%=objUser.getUserName()%>">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>	        		
		              	<input type="password" class="form-control" placeholder="******" name="passWord" value="<%=objUser.getPassWord()%>">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-users fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="fullname" name="fullName" value="<%=objUser.getFullName()%>">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-location-arrow fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="address" name="address" value="<%=objUser.getAddDress()%>">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-phone fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="phone" name="phoneNumber" value="<%=objUser.getPhoneNumber()%>">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-birthday-cake fa-fw"></i></div>
		        		 <%
		        		 String birthday = "";
		        		 if(objUser.getBirthDay()!= null){
		        			 birthday = TimeConvert.getStringDatetime(objUser.getBirthDay());
		        		 }%>  		
		              	<input type="text" class="form-control" placeholder="birthday" name="birthDay" value="<%= birthday %>">           
		          	</div>	
	        	</div>
	        	<input type="hidden" name="uid" value="<%=objUser.getId()%>">	          	      
      </div>
      <div class="modal-footer">
        <input type="submit" class="btn btn-default" name="submit" value="Cập nhật">
      </div>
      		</form>
    </div>
  </div>
</div>
<div id="signup" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color:#00AEEF;">
        <button type="button" class="close" data-dismiss="modal" >&times;</button>
        <h4 class="modal-title" style="text-align:center; color:white; font-weight:bold;">ĐĂNG KÝ TÀI KHOẢN</h4>
      </div>
      <div class="modal-body">
       	  <form action="<%=request.getContextPath() %>/signupUser" class="templatemo-login-form">
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-user fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="username" name="userName" value="">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-key fa-fw"></i></div>	        		
		              	<input type="password" class="form-control" placeholder="******" name="passWord" value="">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-users fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="fullname" name="fullName" value="">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-location-arrow fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="address" name="address" value="">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		<div class="input-group">
		        		<div class="input-group-addon"><i class="fa fa-phone fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="phone" name="phoneNumber" value="">           
		          	</div>	
	        	</div>
	        	<div class="form-group">
	        		 <div class="input-group date" id="date">
                   	 	<div class="input-group-addon"><i class="fa fa-birthday-cake fa-fw"></i></div>	        		
		              	<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="birthDay" value="">    
                   	 </div>          
	        	</div>         	      
      </div>
      <div class="modal-footer">
        <input type="submit" class="btn btn-default" name="submit" value="Đăng ký">
      </div>
     </form>
    </div>
  </div>
</div>

<!-- modal excercises -->
      <div class="modal fade" id="Excercises" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="js-title-step" style="font-weight: bold; font-size:21px;"></h4>
				</div>
				<form id="category" action="<%=request.getContextPath()%>/indexCategoryExcercises" method="Post">
				<div class="modal-body" style="background-color:#eee;">
					<div class="row hide" data-step="1" data-title="Chúng tôi sẽ gợi ý cho bạn những bài tập phù hợp nhất!">
						<div class="jumbotron" style="padding:10px;">
						<span>Cho chúng tôi biết về giới tính của bạn?</span></br>
						<span>Câu trả lời của bạn: </span>
						<input type="radio" name="gioitinh" value="1" checked/>Nam
						<input type="radio" name="gioitinh" value="2" />Nữ
						</div>
					</div>
					<div class="row hide" data-step="2" data-title="Chúng tôi sẽ gợi ý cho bạn những bài tập phù hợp nhất!">
						<div class="jumbotron" style="padding:10px;">
						<span>Bạn tập gym được bao lâu (Bạn mới bắt đầu tập gym, bạn tập được một khoảng thời gian nhất định, bạn đã tập lâu năm)?</span><br>
						<span>Câu trả lời của bạn: </span>
						<select name="thoigian">
							<option value="1">Mới tập</option>
							<option value="2">Đã Biết Tập</option>
							<option value="3">Tập lâu năm</option>
						</select>
						</div>
					</div>
					<div class="row hide" data-step="3" data-title="Chúng tôi sẽ gợi ý cho bạn những bài tập phù hợp nhất!">
						<div class="jumbotron" style="padding:10px;">
						<span>Bạn muốn sau một thời gian tập luyện sẽ đạt được kết quả như thế nào ?(Tăng cân, giảm cân, tăng cơ)?</span><br>
						<span>Câu trả lời của bạn: </span>
						<select name="chucnang">
							<option value="1">Tăng cân</option>
							<option value="2">Tăng cơ</option>
							<option value="3">Giảm cân</option>
						</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger js-btn-step pull-left" data-orientation="cancel" data-dismiss="modal"></button>
					<button type="button" class="btn btn-warning js-btn-step" data-orientation="previous"></button>
					<button type="button" class="btn btn-success js-btn-step" data-orientation="next"></button>
				</div>
				</form>
			</div>
		</div>
	</div>
<%
	String msg = "";
	if(request.getParameter("login") != null){
		msg = request.getParameter("login");
		if(msg.equals("success")){
%>
<script>
	swal("", "Đăng nhập tài khoản thành công!", "success");
</script>
		<%} %>
	<%} %>
<%
	String msg2 = "";
	if(request.getParameter("edit") != null){
		msg = request.getParameter("edit");
		if(msg.equals("success")){
%>
<script>
	swal("", "Cập thông tin thành công!", "success");
</script>
		<%} %>
	<%} %>
<%
	String msg3 = "";
	if(request.getParameter("add") != null){
		msg = request.getParameter("add");
		if(msg.equals("success")){
%>
<script>
	swal("", "Tạo tài khoản thành công!", "success");
</script>
		<%} %>
	<%} %>
<script type="text/javascript">
$(document).ready(function() {
	$(".input-group#date").datepicker({
		changeYear: true,
		changeMonth: true,
		autoclose: true,
		format: 'dd/mm/yyyy' 
	});
});
</script>
<script>
$('#Excercises').modalSteps();
$('#myModal').modalSteps({
	btnCancelHtml: 'ĐÓNG',
	btnPreviousHtml: 'QUAY LẠI',
	btnNextHtml: 'TIẾP THEO',
	btnLastStepHtml: 'HOÀN TẤT',
	disableNextButton: false,
	});
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=request.getContextPath() %>/templates/public/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/templates/public/js/menumaker.js"></script>
<script src="<%=request.getContextPath() %>/templates/public/js/jquery.sticky.js"></script>
<script src="<%=request.getContextPath() %>/templates/public/js/sticky-header.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/bootstrap-datepicker.js"></script>
<style>
.datepicker{
	 z-index:99999 !important;
}
</style>
