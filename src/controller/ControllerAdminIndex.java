package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Statictis;
import library.LibraryPer;
import model.ModelMember;

/**
 * Servlet implementation class ControllerAdminIndex
 */

public class ControllerAdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminIndex() {
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
		if(!LibraryPer.isLogin(request, response)){
			return;
		}
		ModelMember mMember = new ModelMember();
		ArrayList<Statictis> alYear = mMember.getYear();
		String yearMax = mMember.getYearMax();
		int total = 0;
		ArrayList<Statictis> alSta = new ArrayList<>();
		for(int i=1;i<=12;i++){
			total = mMember.getTotalPrice(i, yearMax);
			if(total > 0){
				Statictis objSta = new Statictis(i, total);
				alSta.add(objSta);
			}
		}
		int totalUser = mMember.countUser();
		int totalMember = mMember.countMember();
		int totalPost = mMember.countPost();
		request.setAttribute("totalUser", totalUser);
		request.setAttribute("totalMember", totalMember);
		request.setAttribute("totalPost", totalPost);
		request.setAttribute("alSta",alSta);
		request.setAttribute("alYear",alYear );
		RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
		rd.forward(request, response);
	}

}
