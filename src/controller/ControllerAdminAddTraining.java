package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import library.TimeConvert;
import model.ModelPrice;
import model.ModelSale;
import model.ModelTraining;
import model.ModelUser;
import bean.Price;
import bean.Sale;
import bean.Training;
import bean.User;

/**
 * Servlet implementation class ControllerAdminAddUsers
 */

public class ControllerAdminAddTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddTraining() {
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
		if("load".equals(request.getParameter("type"))){
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addTraining.jsp");
			rd.forward(request, response);
		}else{
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
			List<FileItem> fileItems = null;
			try {
				fileItems = sfu.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = "";
			int price = 0;
			int dayOfTraining = 0;
			String discount = "";
			String dateFrom = "";
			String dateTo = "";
			String preview = "";
			String picture = "";
			String pictureNew = "";
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					String fileName = fileItem.getFieldName();
					String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch (fileName) {
					case "trainName":
						name = fileValue;
						break;
					case "price":
						price = Integer.parseInt(fileValue);
						break;
					case "dayOfTraining":
						dayOfTraining = Integer.parseInt(fileValue);
						break;
					case "discount":
						discount = fileValue;
						break;
					case "from":
						dateFrom = fileValue;
						break;
					case "to":
						dateTo = fileValue;
						break;
					case "preview":
						preview = fileValue;
						break;
					default:
						break;
					}
				}else{ // nếu là file
					picture = fileItem.getName();
					if(!picture.isEmpty()){ // có upload
						// đổi tên ảnh
						pictureNew = FilenameUtils.getBaseName(picture) + System.nanoTime() + "." + FilenameUtils.getExtension(picture);
						String filePath = request.getServletContext().getRealPath("")+ File.separator + "files" + File.separator + pictureNew;
						File file = new File(filePath);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(request.getServletContext().getRealPath(""));
					}
			
				}
			}
			ModelTraining mTraining = new ModelTraining();
			ModelPrice mPrice = new ModelPrice();
			ModelSale mSale = new ModelSale();
			Training objTraining = null;
			if(!discount.isEmpty() ){
				int idPrice = 0;
				int idSale = 0;
				int discount2 = Integer.parseInt(discount);
				Price objPrice = new Price(0, price);
				int resultPrice  =  mPrice.addItem(objPrice);
				if(resultPrice > 0){
					idPrice = mPrice.getIdPrice();
				}
				java.util.Date fromDateUtil = TimeConvert.getDateTime(dateFrom);
				Date fromDateSQL = TimeConvert.getSqlDate(fromDateUtil);
				java.util.Date toDateUtil = TimeConvert.getDateTime(dateTo);
				Date toDateSQl = TimeConvert.getSqlDate(toDateUtil);
				Sale objSale = new Sale(0, discount2, fromDateSQL, toDateSQl);
				int resultSale = mSale.addItem(objSale);
				if(resultSale > 0){
					idSale = mSale.getIdSale();
				}
				String dateCreate = TimeConvert.getDateNow();
				java.util.Date dateCreateUtil = TimeConvert.getDateTime(dateCreate);
				Date dateCreatSql = TimeConvert.getSqlDate(dateCreateUtil);
				objTraining = new Training(0, name, preview, pictureNew, dayOfTraining, idPrice, idSale, dateCreatSql, false);
			}else{
				int idPrice = 0;
				int idSale = 0;
				Price objPrice = new Price(0, price);
				int resultPrice  =  mPrice.addItem(objPrice);
				if(resultPrice > 0){
					idPrice = mPrice.getIdPrice();
				}
				String dateCreate = TimeConvert.getDateNow();
				java.util.Date dateCreateUtil = TimeConvert.getDateTime(dateCreate);
				Date dateCreatSql = TimeConvert.getSqlDate(dateCreateUtil);
				objTraining = new Training(0, name, preview, pictureNew, dayOfTraining, idPrice, idSale, dateCreatSql, false);
			}
			if(mTraining.addItem(objTraining) > 0){
				response.sendRedirect(request.getContextPath() + "/admin/indexTraining");
				return ;
			}else{
				response.sendRedirect(request.getContextPath() + "/admin/addTraining");
				return ;
			}

		}
	}
}
