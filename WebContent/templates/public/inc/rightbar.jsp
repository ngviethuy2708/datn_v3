<%@page import="model.modelProduct"%>
<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- right bar -->
					<div class="col-md-4">
						<div class="title-section-rb">
						 		<nav class="navbar navbar-inverse">
  										<p><span class="animated flash animation-delay-11">GYM-SẢN PHẨM MỚI NHẤT</span></p>
								</nav>
						</div>
						<div class="row main-section-rb">
							<div class="col-md-12">
								<%
								modelProduct mPro = new modelProduct();
								ArrayList<Product> alPro = mPro.getListForPublic();
								for(Product objPro:alPro){
								%>
									<div class="row detail-section-rb">
										<a href="" class=""><h4><%=objPro.getName() %></h4></a>
										<div class="col-md-6">
											<div class="col-md-12">
												<img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objPro.getImage()%>" width="150px" height ="150px">
											</div>
										</div>
										<div class="col-md-6">
											<p><%=objPro.getPreview().substring(0, 50) %>...</p>
											<a href="<%=request.getContextPath()%>/detailProduct?pid=<%=objPro.getId()%>"><button type="button" class="btn btn-info">Xem chi tiết</button></a>
										</div>
									</div>
								<%} %>
							</div>
						</div>
						
					</div>
					<!-- end rightbar -->
				</div>
			</div>
		</div><!-- end body -->