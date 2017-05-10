<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
		<form action="<%=request.getContextPath() %>/admin/addUsers" class="form_addUsers" method="post">
              <div class="row form-group">
                
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputFullname">Tên đầy đủ(*)</label>
                    <input type="text" class="form-control" name="fullName" placeholder="Nhập họ tên đầy đủ">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputPhone">Số điện thoại(*)</label>
                    <input type="text" class="form-control" name="phoneNumber"  placeholder="Ex:0935353463">                  
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputBirthday">Ngày sinh(*)</label>
                     <div class="input-group date" id="date">
                    	<input type="text" class="form-control" name="birthDay"  placeholder="dd-MM-yyyy"><span class="input-group-addon"><i class="fa fa-calendar"></i></span> 
                    </div>                 
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputAddress">Địa chỉ(*)</label>
                    <input type="text" class="form-control" name="address" placeholder="Nhập địa chỉ">                  
                </div> 
              </div>
              <div class="row form-group">
              
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputUsername">Tên(*)</label>
                    <input type="text" class="form-control" name="userName"  placeholder="Nhập Username">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputPassword">Mật khẩu(*)</label>
                    <input type="password" class="form-control" name="passWord"  placeholder="**********">                  
                </div> 
              </div>
              <div class="form-group text-right">
               <span><input class="button-add btn btn-success create-button" name="submit" type="submit" value="Thêm" /> </span>
               <span><input class="button-add btn btn-danger create-button" name="reset" type="reset" value="Nhập lại" /> </span>
              </div>                           
            </form>
				<script type="text/javascript">
$( document ).ready(function() {
	$(".form_addUsers").validate({
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