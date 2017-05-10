package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.modelProduct;
import bean.HistoryOrder;
import bean.Product;

/**
 * Servlet implementation class ControllerAdminSearchOrder
 */
public class ControllerAdminSearchOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchOrder() {
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
		modelProduct mPro = new modelProduct();
		if(request.getParameter("submit") != null){
			String nameProduct = request.getParameter("nameProduct");
			ArrayList<Product> alId = mPro.getId(nameProduct);
			ArrayList<HistoryOrder> alOrder = mPro.getHistoryOrderSearch(alId);
			request.setAttribute("alOrder",alOrder );
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchOrder.jsp");
		rd.forward(request, response);
	}

}
