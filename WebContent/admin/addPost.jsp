<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<div class="container">
	<div class="col-md-2">
					<p>
						<a href="<%=request.getContextPath()%>/admin/indexPost" class="btn btn-success create-button" style="margin-left: -16px; margin-top: 41px;">Quay lại</a>
		        	</p>
		    	</div>	
		<div class="row body-form">
			<div class="col-md-12">
			<form action="<%=request.getContextPath() %>/admin/addPost" enctype="multipart/form-data" class="form_addEX" method="post">
              <div class="row form-group">
                
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputTrainingname">Tên bài đăng(*)</label>
                    <input type="text" class="form-control" name="name" placeholder="Nhập tên bài tập">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputPrice">loại bài đăng(*)</label>
                    <select name="typePost" class="form-control" >
                    	<option value="1">Tin tức</option>
                    	<option value="2">Quảng cáo</option>
                    </select>                
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <label class="control-label" for="inputPreview">Mô tả(*)</label>
                    <textarea class="form-control" name="preview" rows="3"></textarea>
                </div>
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <label class="control-label" for="inputPreview">Chi tiết(*)</label>
                    <textarea id="detail" class="form-control" name="detail" rows="3"></textarea>
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
    CKEDITOR.replace('detail' );
</script>	
<script type="text/javascript">	
$( document ).ready(function() {
	$(".form_addEX").validate({
		rules: {
			name: {
				required: true,
			},
			preview: {
				required: true,
			},
			detail: {
				required: true,
			},
		},
		messages: {
			name: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập tên bài đăng!</span>",
			},
			preview: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập mô tả!</span>",
			},
			detail: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập chi tiết!</span>",
			}
		}
	});
});
</script>
<script>

</script>
</body>
</html>