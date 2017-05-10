<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
			<form action="<%=request.getContextPath() %>/admin/addTraining" enctype="multipart/form-data" class="form_addTraining" method="post">
              <div class="row form-group">
                
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputTrainingname">Tên(*)</label>
                    <input type="text" class="form-control" name="trainName" placeholder="Nhập tên gói tập">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputPrice">Giá(*)</label>
                    <input type="text" class="form-control" name="price"  placeholder="Nhập giá">                  
                </div> 
              </div>
            <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputFrom">Số ngày tập(*)</label>
                    <input type="text" class="form-control" name="dayOfTraining" placeholder="Nhập số ngày tập">
                </div>
            </div> 
           	<div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputDiscount">Giảm giá(%)</label>
                    <input type="text" class="form-control highlight" name="discount" id="inputCurrentPassword" value="" placeholder="ex: 10%">                  
                </div>                
              </div>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputFrom">Bắt đầu ngày</label>
                    <div class="input-group date" id="date">
                    	<input type="text" class="form-control" name="from" placeholder="dd-MM-yyyy"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputConfirmNewPassword">kết thúc ngày</label>
                    <div class="input-group date" id="date">
                    <input type="text" class="form-control" name="to" placeholder="dd-MM-yyyy"><span class="input-group-addon"><i class="fa fa-calendar"></i></span> 
                    </div>
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <label class="control-label" for="inputPreview">Preview(*)</label>
                    <textarea class="form-control" name="preview" rows="3"></textarea>
                </div>
              </div>
               <div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Hình ảnh</label>
                  <input type="file" name="picture" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                  <p>Maximum upload size is 5 MB.</p>                  
                </div>
              </div>
              <div class="form-group text-right">
               <span><input class="button-add btn btn-success create-button" name="submit" type="submit" value="Thêm" /> </span>
               <span><input class="button-add btn btn-danger create-button" name="reset" type="reset" value="Nhập lại" /> </span>
              </div>                           
            </form>

			</div>
		</div>
	</div>
	<script type="text/javascript">	
$( document ).ready(function() {
	$(".form_addTraining").validate({
		rules: {
			trainName: {
				required: true,
			},
			dayOfTraining: {
				required: true,
				number: true
			},
			price: {
				required: true,
				number: true
			},
			preview:{
				required: true,
			}
		},
		messages: {
			trainName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập lịch tập!</span>",
			},
			dayOfTraining: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập số ngày tập!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Kiểu dữ liệu không phải là số!</span>",
			},
			price: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập giá!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Kiểu dữ liệu không phải là số!</span>",
			},
			preview: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng mô tả!</span>"
			}
		}
	});
});
</script>
<script>
$(document).ready(function() {
	var date_now = new Date(Date.now());
	$(".input-group#date").datepicker({
		changeYear: true,
		changeMonth: true,
		autoclose: true,
		format: 'dd/mm/yyyy',
		startDate: date_now
	});
});
</script>
</body>
</html>