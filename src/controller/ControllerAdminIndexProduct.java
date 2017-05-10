package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import bean.Training;
import library.LibraryConstant;
import library.LibraryPer;
import library.TimeConvert;
import model.ModelTraining;
import model.modelProduct;

/**
 * Servlet implementation class ControllerAdminIndexTraining
 */

public class ControllerAdminIndexProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminIndexProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!LibraryPer.isLogin(request, response)){
			return;
		}
		ModelTraining mTraining = new ModelTraining();
		modelProduct mProduct = new modelProduct();
		int tongSoDong = mProduct.getSum();
		int soTrang = (int)Math.ceil((float)tongSoDong/LibraryConstant.ROW_COUNT);
		int currentPage = 1;
		if(request.getParameter("page") != null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("soTrang", soTrang);
		int offset = (currentPage-1) * LibraryConstant.ROW_COUNT;
		ArrayList<Product> alPro = mProduct.getListForPaginator(offset, LibraryConstant.ROW_COUNT);
		for (Product objPro : alPro) {
			if(objPro.getSale_id() != 0){
				int curentPrice = mProduct.getPriceOfSale(objPro.getId());
				objPro.setPrice(curentPrice);
				int discount = mProduct.getDiscount(objPro.getId());
				objPro.setDiscount(discount);
			}else{
				int curentPrice = mProduct.getPrice(objPro.getId());
				objPro.setPrice(curentPrice);
				objPro.setDiscount(0);
			}
		}
		request.setAttribute("alProduct", alPro);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexProduct.jsp");
		rd.forward(request, response);
	}
}
