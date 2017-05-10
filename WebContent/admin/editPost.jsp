<%@page import="bean.Post"%>
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
			<%Post objP = (Post)request.getAttribute("objPost"); %>
			<form action="<%=request.getContextPath() %>/admin/editPost" enctype="multipart/form-data" class="form_addEX" method="post">
              <div class="row form-group">
                
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputTrainingname">Tên bài đăng(*)</label>
                    <input type="text" class="form-control" name="name" value="<%=objP.getName() %>" placeholder="Nhập tên bài tập">                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label for="inputPrice">loại bài đăng(*)</label>
                    <%
                    	String selected1 = "";
                    	String selected2 = "";
                    	if(objP.getCategoryId() == 1){
                    		selected1 = "selected";
                    	}else{
                    		selected2 = "selected";
                    	}
                    	
                    %>
                    <select name="typePost" class="form-control" >
                    	<option value="1" <%=selected1 %>>Tin tức</option>
                    	<option value="2" <%=selected2 %>>Quảng cáo</option>
                    </select>                
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <label class="control-label" for="inputPreview">Mô tả(*)</label>
                    <textarea class="form-control"  name="preview" rows="3"><%=objP.getPreview() %></textarea>
                </div>
              </div>
              <div class="row form-group">
                <div class="col-lg-12 form-group">                   
                    <label class="control-label" for="inputPreview">Chi tiết(*)</label>
                    <textarea id="detail" class="form-control" name="detail" rows="3"><%=objP.getDetail() %></textarea>
                </div>
              </div>
               <div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Hình ảnh</label>
                  <%if (!objP.getImage().isEmpty()) {
   							String imgPath = request.getContextPath() + "/files/" + objP.getImage();
   						 %>
   						 <input type="hidden" name="pictureOld" value="<%=objP.getImage()%>" />
   						 <img class="img-rounded"  src="<%=imgPath%>" width="100px" height ="80px">
   					<%} %>
                  <input type="file" name="picture" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                  <p>Maximum upload size is 5 MB.</p>                  
                </div>
              </div>
              <input type="hidden" name="pid" value="<%=objP.getId()%>">;
              <div class="form-group text-right">
               <span><input class="button-add btn btn-success create-button" name="submit" type="submit" value="Sửa" /> </span>
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