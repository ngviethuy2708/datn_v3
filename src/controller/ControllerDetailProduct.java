package controller;

import java.io.IOException;

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
 * Servlet implementation class ControllerDetailProduct
 */
public class ControllerDetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDetailProduct() {
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
		ModelPost mPost = new ModelPost();
		int idProduct = Integer.parseInt(request.getParameter("id"));
		Product objPro = mPro.getItem(idProduct);
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
		request.setAttribute("objPro",objPro);
		request.setAttribute("alPost", mPost.getIntroDuceForDetail());
		RequestDispatcher rd = request.getRequestDispatcher("/public/detailProduct.jsp");
		rd.forward(request, response);
	}

}
