<%@page import="bean.User"%>
<%@page import="java.util.Date"%>
<%@page import="library.TimeConvert"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
	<%
	String output = "";
	if(request.getParameter("msg") != null){
						String msg = request.getParameter("msg");
						if("edit0".equals(msg)){
							output ="Trùng Username!";
						}
	}
	User objUser = (User)request.getAttribute("objUser");
	TimeConvert cv = new TimeConvert();
	Date date_until = cv.getNormalDate(objUser.getBirthDay());
	String date_string = cv.getStringDatetime(date_until);
	%> 
	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form_editUsers" role="form" method="post" action="<%=request.getContextPath() %>/admin/editUsers?uid=<%=objUser.getId()%>">
					<%-- <div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
   						<div class="col-sm-10">
      						<input type="text" name="userName" value = "<%=objUser.getUserName() %>" class="form-control required" id="username" placeholder="">
      						<% if(!output.equals("")){%>
      						<p style="color:red;" >
								<i class="fa fa-user"></i>
								<%=output %>
								</p>
      						<%} %>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Password</label>
   						<div class="col-sm-10">
      						<input type="password" name="passWord" value = "<%=objUser.getPassWord() %>" class="form-control" id="password" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Họ tên</label>
   						<div class="col-sm-10">
      						<input type="text" name="fullName" value = "<%=objUser.getFullName() %>" class="form-control" id="fullname" placeholder="">
    					</div>
 					 </div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Ngày sinh</label>
   						<div class="col-sm-10">
      						<input type="text" name="birthDay" value = "<%=date2 %>" class="form-control myDateFormat " id="birthday" placeholder="dd/mm/YYYY">
      					
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Địa chỉ</label>
   						<div class="col-sm-10">
      						<input type="text" name="address"  value = "<%=objUser.getAddDress() %>" class="form-control" id="address" placeholder="">
      						
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Số điện thoại</label>
   						<div class="col-sm-10">
      						<input type="text" name="phoneNumber" value = "<%=objUser.getPhoneNumber() %>" class="form-control" id="phone" placeholder="Email">
      						
    					</div>
 					</div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="sua" type="submit" value="Sửa" /> 
		        			</p>
    					</div>
  					</div> --%>
  					<div class="row form-group">
                
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputFullname">Tên đầy đủ(*)</label>
                    <input type="text" class="form-control" name="fullName" value="<%=objUser.getFullName() %>" placeholder="Nhập họ tên đầy đủ">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputPhone">Số điện thoại(*)</label>
                    <input type="text" class="form-control" name="phoneNumber" value="<%=objUser.getPhoneNumber() %>" placeholder="Ex:0935353463">                  
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputBirthday">Ngày sinh(*)</label>
                     <div class="input-group date" id="date">
                   	 	<input type="text" class="form-control" name="birthDay" value="<%=date_string %>" placeholder="dd-MM-yyyy"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                   	 </div>                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputAddress">Địa chỉ(*)</label>
                    <input type="text" class="form-control" name="address" value="<%=objUser.getAddDress() %>" placeholder="Nhập địa chỉ">                  
                </div> 
              </div>
              <div class="row form-group">
              
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputUsername">Tên(*)</label>
                    <input type="text" class="form-control" name="userName" value="<%=objUser.getUserName() %>"  placeholder="Nhập Username">     
                    <% if(!output.equals("")){%>
      					<p style="color:red;" >
							<i class="fa fa-user"></i>
							<%=output %>
						</p>
      				<%} %>             
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputPassword">Mật khẩu(*)</label>
                    <input type="password" class="form-control" name="passWord" value="<%=objUser.getPassWord() %>" placeholder="**********">                  
                </div> 
              </div>
              <div class="form-group text-right">
               <span><input class="button-add btn btn-success create-button" name="sua" type="submit" value="Sửa" /> </span>
               <span><input class="button-add btn btn-danger create-button" name="reset" type="reset" value="Nhập lại" /> </span>
              </div>                  
  					
		</form>
		<script type="text/javascript">
$( document ).ready(function() {
	$(".form_editUsers").validate({
		rules: {
			userName: {
				required: true,
			},
			passWord: {
				required: true,
			},
			fullName: {
				required: true,
			},
			birthDay: {
				required: true,
			},
			address: {
				required: true,
			},
			phoneNumber:{
				required: true,
				number: true
			}
		},
		messages: {
			userName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập username!</span>",
			},
			passWord: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập password!</span>",
			},
			fullName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập họ tên!</span>"	
			},
			birthDay: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập ngày tháng năm sinh!</span>",
			},
			address: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập địa chỉ!</span>",
			},
			phoneNumber: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập số điện thoại!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!</span>",
			}
		}
	});
});
</script>
<script>
$(document).ready(function() {
	$(".input-group#date").datepicker({
		changeYear: true,
		changeMonth: true,
		autoclose: true,
		format: 'dd/mm/yyyy' 
	});
});
</script>
			</div>
		</div>
	</div>
	
</body>
</html>