package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.LibraryString;
import bean.DayOff;
import bean.FitnessCategory;
import bean.FitnessExcercises;
import bean.History;
import bean.Training;
import bean.User;

public class ModelFitnessExcercises {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<FitnessCategory> getFinessCategory(){
		String sql = "SELECT * FROM `fitness_category`";
		ArrayList<FitnessCategory> alCategory = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int finessCalendarId = rs.getInt("fitness_calendar_id");
				String image = rs.getString("image");
				FitnessCategory objCategory = new FitnessCategory(id, name, finessCalendarId,image);
				alCategory.add(objCategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return alCategory;
	}
	public ArrayList<FitnessCategory> getFinessCategoryForPaginator(int offset, int rowCount){
		String sql = "SELECT * FROM `fitness_category` LIMIT ?,?";
		ArrayList<FitnessCategory> alCategory = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int finessCalendarId = rs.getInt("fitness_calendar_id");
				String image = rs.getString("image");
				FitnessCategory objCategory = new FitnessCategory(id, name, finessCalendarId,image);
				alCategory.add(objCategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return alCategory;
	}
	public int getIdFinessCalendar(int type,int time,int limit){
		String sql = "SELECT id FROM `fitness_calendar` where type_training_id = ? and time_training_id = ? and limit_training_id = ? limit 1";
		int id = 0;
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, type);
			pst.setInt(2, time);
			pst.setInt(3, limit);
			rs = pst.executeQuery();
			if(rs.next()){
				id =  rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return id;
	}
	public int addFitnessCategory(FitnessCategory objCategory){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO fitness_category(name,fitness_calendar_id,image) VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCategory.getName());
			pst.setInt(2, objCategory.getFinessCalendarId());
			pst.setString(3, objCategory.getImage());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(id) AS sodong FROM fitness_category ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				sodong = rs.getInt("sodong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sodong;
	}
	public int deleteCategory(int id){
		int result = 0;
		String sql ="DELETE FROM `fitness_category` WHERE id = ? ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<FitnessCategory> getFinessCategoryForSort(int idCalendar){
		String sql = "SELECT * FROM `fitness_category` WHERE fitness_calendar_id = ?";
		ArrayList<FitnessCategory> alCategory = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCalendar);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int finessCalendarId = rs.getInt("fitness_calendar_id");
				String image = rs.getString("image");
				FitnessCategory objCategory = new FitnessCategory(id, name, finessCalendarId,image);
				alCategory.add(objCategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return alCategory;
	}
	public ArrayList<FitnessExcercises> getExcercises(int idCategory){
		String sql = "SELECT * FROM `fitness_excercises` WHERE finess_category_id = ?";
		ArrayList<FitnessExcercises> alEx = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCategory);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String deatail = rs.getString("detail");
				String video = rs.getString("video");
				String result = rs.getString("result");
				int fitnessCategoryId = rs.getInt("finess_category_id");
				FitnessExcercises objEx = new FitnessExcercises(id, name, image, preview, deatail, video, result, fitnessCategoryId);
				alEx.add(objEx);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return alEx;
	}
	public int addExcercises(FitnessExcercises objEx){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO fitness_excercises(name,image,preview,detail,video,result,finess_category_id) VALUES (?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objEx.getName());
			pst.setString(2, objEx.getImage());
			pst.setString(3, objEx.getPreview());
			pst.setString(4, objEx.getDeatail());
			pst.setString(5, objEx.getVideo());
			pst.setString(6, objEx.getResult());
			pst.setInt(7, objEx.getFitnessCategoryId());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public FitnessExcercises getItem(int eid){
		String sql = "SELECT * FROM `fitness_excercises` WHERE id = ? limit 1";
		FitnessExcercises objEx = null;
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, eid);
			rs = pst.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String preview = rs.getString("preview");
				String deatail = rs.getString("detail");
				String video = rs.getString("video");
				String result = rs.getString("result");
				int fitnessCategoryId = rs.getInt("finess_category_id");
				objEx = new FitnessExcercises(id, name, image, preview, deatail, video, result, fitnessCategoryId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return objEx;
	}
	public int editExcercises(FitnessExcercises objEx){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE fitness_excercises SET name = ? , image = ? , preview = ?, detail = ?,video = ?,result = ?,finess_category_id = ? WHERE id = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst = conn.prepareStatement(sql);
			pst.setString(1, objEx.getName());
			pst.setString(2, objEx.getImage());
			pst.setString(3, objEx.getPreview());
			pst.setString(4, objEx.getDeatail());
			pst.setString(5, objEx.getVideo());
			pst.setString(6, objEx.getResult());
			pst.setInt(7, objEx.getFitnessCategoryId());
			pst.setInt(8, objEx.getId());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				result = 0;
				e.printStackTrace();
			}
		}
		return result;
	}
	public int deleteExcercisesInCategory(int id){
		int result = 0;
		String sql ="DELETE FROM `fitness_excercises` WHERE finess_category_id = ? ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int deleteExcercises(int id){
		int result = 0;
		String sql ="DELETE FROM `fitness_excercises` WHERE id = ? ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
