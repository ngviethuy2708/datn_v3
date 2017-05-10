package controller;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import bean.Product;
import model.ModelFitnessExcercises;
import model.modelProduct;


/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerIndexExcercises extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndexExcercises() {
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
		int cid = 0;
		ModelFitnessExcercises mEx = new ModelFitnessExcercises();
		modelProduct mPro = new modelProduct();
		if(request.getParameter("cid") != null){
			cid = Integer.parseInt(request.getParameter("cid"));
		}
		ArrayList<Product> alPro = mPro.getListForPublic();
		for (Product objPro : alPro) {
			if(objPro.getSale_id() != 0){
				int curentPrice = mPro.getPriceOfSale(objPro.getId());
				objPro.setPrice(curentPrice);
				int discount = mPro.getDiscount(objPro.getId());
				objPro.setDiscount(discount);
			}else{
				int curentPrice = mPro.getPrice(objPro.getId());
				objPro.setPrice(curentPrice);
				objPro.setDiscount(0);
			}
		}
		request.setAttribute("alEx", mEx.getExcercises(cid));
		request.setAttribute("alProduct", alPro);
		RequestDispatcher rd  = request.getRequestDispatcher("/public/indexExcercises.jsp");
		rd.forward(request, response);
		
	}

}
