<%@page import="bean.News"%>
<%@page import="bean.Introduce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp" %>
	<!-- body -->
	<div class="main-content">
			<div class="container">
				<div class="row main-section">
					<div class="col-md-12">
						<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form-login" role="form" method="post" action="<%=request.getContextPath() %>/login">
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
   						<div class="col-sm-10">
      						<input type="text" name="userName" class="form-control required" id="username" placeholder="" style="width:500px;">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Password</label>
   						<div class="col-sm-10">
      						<input type="password" name="passWord" class="form-control" id="password" placeholder="" style="width:500px;">
    					</div>
 					</div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Đăng nhập" /> 
								<a href="<%=request.getContextPath()%>/register"><input class="button-add btn btn-danger create-button" value="Đăng ký" / style="width:100px;"></a> 
		        			</p>
    					</div>
  					</div>
  					
				</form>
			</div>
		</div>
	</div>
</div>
</div>
</div><!-- end body -->
		<script type="text/javascript">
$( document ).ready(function() {
	$(".form-login").validate({
		rules: {
			userName: {
				required: true,
			},
			passWord: {
				required: true,
			}
			
		},
		messages: {
			userName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập username</span>",
			},
			passWord: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập password</span>",
			},
			
		}
	});
});
</script>
		<%@include file="/templates/public/inc/footer.jsp" %>