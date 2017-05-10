package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelFitnessExcercises;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.FitnessCategory;

/**
 * Servlet implementation class ControllerAdminAddFitnessCategory
 */
public class ControllerAdminAddFitnessCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddFitnessCategory() {
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
		int type = 0;
		int time = 0;
		int limit = 0;
		String picture = "";
		String pictureNew = "";
		for (FileItem fileItem : fileItems) {
			if(fileItem.isFormField()){
				String fileName = fileItem.getFieldName();
				String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
				switch (fileName) {
				case "nameCategory":
					name = fileValue;
					break;
				case "typeCategory":
					type = Integer.parseInt(fileValue);
					break;
				case "timeCategory":
					time = Integer.parseInt(fileValue);
					break;
				case "limitCategory":
					limit = Integer.parseInt(fileValue);
					break;
				default:
					break;
				}
			}else{
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
		ModelFitnessExcercises mFitNess = new ModelFitnessExcercises();
		int idFitnessCalendar = mFitNess.getIdFinessCalendar(type, time, limit);
		FitnessCategory objCategory = new FitnessCategory(0, name, idFitnessCalendar, pictureNew);
		int result = mFitNess.addFitnessCategory(objCategory);
		if(result > 0){
			response.sendRedirect(request.getContextPath() + "/admin/fitnessCategory");
			return ;
		}
	}

}
