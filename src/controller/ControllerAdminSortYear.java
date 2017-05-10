package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelMember;
import bean.Statictis;

/**
 * Servlet implementation class ControllerAdminSortYear
 */
public class ControllerAdminSortYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSortYear() {
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
		String year = "";
		int total = 0;
		String result = "";
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		ModelMember mMember = new ModelMember();
		if(request.getParameter("year") != null){
			year = request.getParameter("year");
			ArrayList<Statictis> alSta = new ArrayList<>();
			for(int i=1;i<=12;i++){
				total = mMember.getTotalPrice(i, year);
				if(total > 0){
					Statictis objSta = new Statictis(i, total);
					alSta.add(objSta);
				}
			}
			for(Statictis objSta:alSta){
				String price = String.format("%,d", objSta.getTotal());
				result += "<tr>";
				result += 	"<td>THÁNG "+objSta.getMonth()+"</td>";
				result += 	"<td>"+price+" VND </td>";
				result += "</tr>";
			}
			out.print(result);
		}
	}

}
