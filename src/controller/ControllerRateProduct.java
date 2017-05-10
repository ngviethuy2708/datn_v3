package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ModelDanhGia;
import bean.DanhGia;
import bean.User;

/**
 * Servlet implementation class ControllerRateProduct
 */

public class ControllerRateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRateProduct() {
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
		PrintWriter out = response.getWriter();
		ModelDanhGia mDanhGia = new ModelDanhGia();
		HttpSession ss = request.getSession();
		User objUser = (User)ss.getAttribute("objUser");
		if(objUser == null){
			out.print("error");
		}else{
			int userId =  objUser.getId();
			int productId = Integer.parseInt(request.getParameter("productId"));
			float rate = Float.parseFloat(request.getParameter("rate"));
			DanhGia objDanhGia = new DanhGia(0, userId, productId, rate);
			System.out.println(objDanhGia.toString());
			int count =  mDanhGia.countRate(userId, productId);
			if(count == 1){
				int result = mDanhGia.editItem(objDanhGia);
				out.print("success");
			}else{
				int result = mDanhGia.addItem(objDanhGia);
				out.print("success");
			}
		}
	}

}
