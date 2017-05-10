package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Training;
import library.LibraryConstant;
import library.LibraryPer;
import library.TimeConvert;
import model.ModelTraining;

/**
 * Servlet implementation class ControllerAdminIndexTraining
 */

public class ControllerAdminIndexTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminIndexTraining() {
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
		int tongSoDong = mTraining.getSum();
		int soTrang = (int)Math.ceil((float)tongSoDong/LibraryConstant.ROW_COUNT);
		int currentPage = 1;
		if(request.getParameter("page") != null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("soTrang", soTrang);
		int offset = (currentPage-1) * LibraryConstant.ROW_COUNT;
		ArrayList<Training> alTraining = mTraining.getListForPaginator(offset, LibraryConstant.ROW_COUNT);
		for (Training objTraining : alTraining) {
			if(objTraining.getSaleId() != 0){
				int curentPrice = mTraining.getPriceOfSale(objTraining.getId());
				objTraining.setPrice(curentPrice);
				int discount = mTraining.getDiscount(objTraining.getId());
				objTraining.setDiscount(discount);
			}else{
				int curentPrice = mTraining.getPrice(objTraining.getId());
				objTraining.setPrice(curentPrice);
				objTraining.setDiscount(0);
			}
		}
		request.setAttribute("alTraining", alTraining);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexTraining.jsp");
		rd.forward(request, response);
	}
}
