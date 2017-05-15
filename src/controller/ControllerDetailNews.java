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
import model.ModelPost;
import model.modelProduct;

/**
 * Servlet implementation class ControllerDetailIntroduce
 */
public class ControllerDetailNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDetailNews() {
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
		ModelPost mPost = new ModelPost();
		modelProduct mPro = new modelProduct();
		int id = 0;
		if(request.getParameter("id") != null){
			id = Integer.parseInt(request.getParameter("id"));
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
		request.setAttribute("alProduct", alPro);
		request.setAttribute("objNews", mPost.getItem(id));
		RequestDispatcher rd = request.getRequestDispatcher("/public/detailNews.jsp");
		rd.forward(request, response);
	}

}
