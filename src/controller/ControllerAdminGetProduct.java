package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.modelProduct;
import bean.Product;

/**
 * Servlet implementation class ControllerAdminGetProduct
 */
public class ControllerAdminGetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminGetProduct() {
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
		int id = 0;
		PrintWriter out = response.getWriter();
		String result = "";
		modelProduct mPro = new modelProduct();
		if(request.getParameter("idProduct") != null){
			id = Integer.parseInt(request.getParameter("idProduct"));
			Product objPro = mPro.getItem(id);
			if(objPro.getSale_id() == 0){
				objPro = mPro.getItemNoSale(id);
			}else{
				objPro = mPro.getItemSale(id);
			}
			if(objPro.getSale_id() != 0){
				int curentPrice = mPro.getPriceOfSale(objPro.getId());
				objPro.setPrice(curentPrice);
			}else{
				int curentPrice = mPro.getPrice(objPro.getId());
				objPro.setPrice(curentPrice);
			}
			result += objPro.getId()+"|"+objPro.getName()+"|"+objPro.getImage()+"|"+objPro.getQuatity()+"|"+objPro.getPrice();
			out.print(result);
		}
	}

}
