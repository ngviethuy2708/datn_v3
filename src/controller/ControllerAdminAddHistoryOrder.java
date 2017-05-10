package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HistoryOrder;
import library.TimeConvert;
import model.modelProduct;

/**
 * Servlet implementation class ControllerAdminAddHistoryOrder
 */

public class ControllerAdminAddHistoryOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddHistoryOrder() {
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
		modelProduct mProduct = new modelProduct();
		if(request.getParameter("submit") != null){
			int productId = Integer.parseInt(request.getParameter("idP"));
			int price = Integer.parseInt(request.getParameter("currentPrice"));
			int numOfProduct = Integer.parseInt(request.getParameter("numOfProduct"));
			String curentDateStr = TimeConvert.getDateNow();
			Date curentDateUntil = TimeConvert.getDateTime(curentDateStr);
			java.sql.Date curentDateSql = TimeConvert.getSqlDate(curentDateUntil);
			HistoryOrder objH = new HistoryOrder(0, productId, price, numOfProduct, curentDateSql);
			int result = mProduct.addHistoryOrder(objH);
			if(result > 0){
				int quatity =  Integer.parseInt(request.getParameter("quatityP"));
				int newQuatity = quatity - numOfProduct;
				int result2 = mProduct.editItem(productId, newQuatity);
				if(result2 > 0){
					response.sendRedirect(request.getContextPath()+"/admin/indexProduct?sale=success");
				}
			}
		}
	}

}
