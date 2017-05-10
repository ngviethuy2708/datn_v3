package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;





import bean.Product;
import bean.Training;
import library.LibraryConstant;
import library.LibraryPer;
import library.TimeConvert;
import model.ModelPost;
import model.ModelTraining;
import model.ModelUser;
import model.modelProduct;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndex() {
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
		ModelTraining mTraining = new ModelTraining();
		request.setAttribute("alIntro", mPost.getIntroDuceForPuclin());
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
		ArrayList<Training> alTraining = mTraining.getListForPublic();
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
		request.setAttribute("alProduct", alPro);
		RequestDispatcher rd = request.getRequestDispatcher("/public/index.jsp");
		rd.forward(request, response);
	}

}
