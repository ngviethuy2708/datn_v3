<%@page import="bean.FitnessCategory"%>
<%@page import="bean.Training"%>
<%@page import="bean.User"%>
<%@page import="library.TimeConvert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<!-- body -->
	<div class="container">
		<div class="row">
			<!-- main -->
			<div class="col-md-10 main">
				<div class="search-form">
					<div class="col-md-2">
						<p>
							<a class="btn btn-success create-button" data-toggle="modal" data-target="#creatCategory">TẠO LỊCH TẬP</a>
		        		</p>
		    		</div>
		    		<div class="col-md-10">
						<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/sortCategory" method="post">
							<div class="form-group">
								<select name="type" class="form-control" style="margin-left: 102px; margin-right:20px; width: 125px;">
  									<option value="1">TĂNG CÂN</option>
 									<option value="2">TĂNG CƠ</option>
  									<option value="3">GIẢM CÂN</option>
								</select>
								<select name="time" class="form-control" style="margin-left: -15px; margin-right:20px;  width: 125px;">
  									<option value="1">MỚI TẬP</option>
 									<option value="2">ĐÃ BIẾT TẬP</option>
  									<option value="3">TẬP LÂU NĂM</option>
								</select>
								<select name="limit" class="form-control" style="margin-left: -15px; margin-right:20px; width: 125px;">
  									<option value="1">NAM</option>
 									<option value="2">NỮ</option>
								</select>
							</div>
							<input class="button-add btn btn-primary create-button" name="submit" type="submit" value="Sắp xếp" />
						</form>
					</div>
				</div>
				<!-- end search form -->
			<div class="portfolio_area" id="mypost" style="margin-top:108px; margin-bottom:108px;">
				<div class="container">
					 <div class="row">
					 	 <div class="col-md-12">
               					<div class="portfolio_nav">
               			 </div>
        		    </div>
        		    <div class="project_maxitup" id="MixItUp380DA8">
        		    	<%
        		    	ArrayList<FitnessCategory> alCategory = (ArrayList<FitnessCategory>)request.getAttribute("alCategory"); 
        		    	for(FitnessCategory objCategory: alCategory){
        		    	%>
        		    	<div class="col-md-4 col-sm-6 mix Tat-Ca" style="display: inline-block;" data-bound="">
        		    		<div class="portfolio">
        		    			<div class="single_protfolio">
        		    				<div class="prot_imag">
        		    					<a href="<%=request.getContextPath() %>/admin/deleteCategory?id=<%=objCategory.getId() %>" ><i class="fa fa-times" style="margin-left:337px; color:red;"></i></a>
        		    					<a class="venobox vbox-item" href="<%=request.getContextPath() %>/admin/indexExcercises?cid=<%=objCategory.getId() %>" title="<%=objCategory.getName()%>" target="_blank">
            								<img style = "width:350px; height:200px;"src="<%=request.getContextPath()%>/files/<%=objCategory.getImage() %>" alt="<%=objCategory.getName()%>">
            							</a>
            							<div class="hover_port_text">
            								<h2><a href="/Nhung-lan-quay-pha-83.html"><%=objCategory.getName() %></a></h2>
            							</div>
        		    				</div>
        		    			</div>
        		    		</div>   
        		    	</div>
        		    	<%} %>
        		    </div>
				</div>
				<div class="pagi">
					<ul class="pagination">
					<%
					String active="";
					int curentPage = (Integer)request.getAttribute("page");
					int soTrang = (Integer)request.getAttribute("soTrang");
					for(int i=1;i<=soTrang;i++){
						if(curentPage==i){
							active = "class=\"active\"";
						}else{
							active ="";
						}
					%>
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/fitnessCategory?page=<%=i%>"><%=i %></a></li>
  					<%} %>
					</ul>
				</div>	
			</div>
			<!-- end main -->
		</div>
		
	</div>
	<!-- end body -->
<%
	String msg = "";
	if(request.getParameter("delete") != null){
		msg = request.getParameter("delete");
		if(msg.equals("success")){
%>
<script>
	swal("", "Xóa danh mục thành công!", "success")
</script>
		<%} %>
	<%} %>
</body>
<!-- Modal -->
<div class="modal fade" id="creatCategory" tabindex="-1" role="dialog" aria-labelledby="loginLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" style="background-color: #787878;">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginlLabel" style = "font-weight:bold; text-align:center; color:white;">TẠO DANH MỤC</h4>
      </div>
      <div class="modal-body">
		<input type="hidden" name="userID" value="">
       	<form class="form-horizontal form_register" role="form" method="post" enctype="multipart/form-data" action="<%=request.getContextPath() %>/admin/addFitnessCategory">
         	<div class="input-group">
 				<span class="input-group-addon" id="basic-addon1">Tên danh mục</span>
 				<input type="text" name="nameCategory" class="form-control" placeholder="Tên danh mục" aria-describedby="basic-addon1">
			</div>
			<div class="input-group" style="margin-top:20px; margin-bottom:20px;">
 				<span class="input-group-addon" id="basic-addon1" style="width:142px;">Loại bài tập</span>
 				<select name="typeCategory" class="form-control" aria-describedby="basic-addon1" style="width:451px;">
  					<option value="1">TĂNG CÂN</option>
 					<option value="2">TĂNG CƠ</option>
  					<option value="3">GIẢM CÂN</option>
				</select>
			</div>
			<div class="input-group" style="margin-top:20px; margin-bottom:20px;">
 				<span class="input-group-addon" id="basic-addon1" style="width:142px;">Thời gian tập</span>
 				<select name="timeCategory" class="form-control" aria-describedby="basic-addon1" style="width:451px;">
  					<option value="1">MỚI TẬP</option>
 					<option value="2">ĐÃ BIẾT TẬP</option>
  					<option value="3">TẬP LÂU NĂM</option>
				</select>
			</div>
			<div class="input-group" style="margin-top:20px; margin-bottom:20px;" >
 				<span class="input-group-addon" id="basic-addon1"  style="width:142px;" >Giới tinh</span>
 				<select name="limitCategory" class="form-control" aria-describedby="basic-addon1" style="width:451px;">
  					<option value="1">Nam</option>
 					<option value="2">Nữ</option>
				</select>
			</div>
			<div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Hình ảnh</label>
                  <input type="file" name="picture" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">    
                 <p>Maximum upload size is 5 MB.</p>                  
                </div>
            </div>
             <div class="form-group text-right" style="margin-right:0px;">
               <span><input class="button-add btn btn-success create-button" name="sửa" type="submit" value="Xác nhận" /> </span>
              </div>                           
            </form>
        </form>
      </div>
    </div>
  </div>
</div>
</html>
