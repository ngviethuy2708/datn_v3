package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.modelProduct;

/**
 * Servlet implementation class ControllerAdminAddNumOfProduct
 */
public class ControllerAdminAddNumOfProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddNumOfProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modelProduct mPro = new modelProduct();
		int id = 0;
		if(request.getParameter("idP") != null){
			id = Integer.parseInt(request.getParameter("idP"));
			int quatity = Integer.parseInt(request.getParameter("quatityP"));
			int numOfProduct = Integer.parseInt(request.getParameter("numOfProduct"));
			int newQuatity =  quatity+numOfProduct;
			int result = mPro.editItem(id, newQuatity);
			if(result > 0){
				response.sendRedirect(request.getContextPath() + "/admin/indexProduct?add=success");
			}
		}
	}

}
