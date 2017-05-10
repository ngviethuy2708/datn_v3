<%@page import="bean.FitnessCategory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/templates/public/inc/header.jsp" %>
    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="page-caption">
                        <h2 class="page-title">BÀI TẬP THỂ HÌNH</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="page-breadcrumb">
        <div class="container">
            <div class="col-lg-12">
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Danh mục bài tập</li>
                </ol>
            </div>
        </div>
    </div>
    <div class="content">
         
        <div class="container">
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                    <div class="mb60 text-center section-title">
                        <!-- section title start-->
                        <h1>BÀI TẬP THỂ HÌNH</h1>
                        <p>Những bài tập rất quan trọng trong tập Gym, nếu bạn muốn cơ bắp phát triển toàn diện nhanh nhất thì tập đúng cách là vấn đề then chốt. Chính vì vậy tập gym yếu tố kỹ thuật được đặt lên hàng đầu.</p>
                    </div>
                    <!-- /.section title start-->
                </div>
            </div>
            <div class="row">
                <div class="project_maxitup" id="MixItUp380DA8">
        		    	<%
        		    	ArrayList<FitnessCategory> alCategory = (ArrayList<FitnessCategory>)request.getAttribute("alCategory"); 
        		    	for(FitnessCategory objCategory: alCategory){
        		    	%>
        		    	<div class="col-md-4 col-sm-6 mix Tat-Ca" style="display: inline-block;" data-bound="">
        		    		<div class="portfolio">
        		    			<div class="single_protfolio">
        		    				<div class="prot_imag">
        		    					<a class="venobox vbox-item" href="<%=request.getContextPath() %>/Excercises?cid=<%=objCategory.getId() %>" title="<%=objCategory.getName()%>" target="_blank">
            								<img style = "width:350px; height:200px;"src="<%=request.getContextPath()%>/files/<%=objCategory.getImage() %>" alt="<%=objCategory.getName()%>">
            							</a>
            							<div class="hover_port_text">
            								<h2><a href="<%=request.getContextPath() %>/Excercises?cid=<%=objCategory.getId() %>"><%=objCategory.getName() %></a></h2>
            							</div>
        		    				</div>
        		    			</div>
        		    		</div>   
        		    	</div>
        		    	<%} %>
        		  </div>			
            </div>
        </div>
    </div> 
	<div class="footer">
        <div class="container ">
             <p>Copyright © 2016 - 2017 Thể hình - Tập thể hình - Thể hình đẹp - Phương pháp tập thể hình nam, nữ - Thể lực</p>
             <p>CODE BY: Nguyễn Viết Huy</p>
        </div>
    </div>   
   
  
</body>

</html>
