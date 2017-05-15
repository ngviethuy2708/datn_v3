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

import org.apache.tomcat.jni.Mmap;

import bean.Product;
import library.LibraryConstant;
import library.LibraryPer;
import library.TimeConvert;
import model.ModelPost;
import model.ModelUser;
import model.modelProduct;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerIndexIntroduce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndexIntroduce() {
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
		int tongSoDong = mPost.getSumIntroDuce();
		int soTrang = (int)Math.ceil((float)tongSoDong/LibraryConstant.ROW_COUNT);
		int currentPage = 1;
		if(request.getParameter("page") != null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("soTrang", soTrang);
		int offset = (currentPage-1) * LibraryConstant.ROW_COUNT;
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
		request.setAttribute("alIntro", mPost.getIntroDuceForPuclic(offset,LibraryConstant.ROW_COUNT));
		RequestDispatcher rd = request.getRequestDispatcher("/public/indexIntroduce.jsp");
		rd.forward(request, response);
	}

}
