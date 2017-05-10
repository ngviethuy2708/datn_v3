package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import library.LibraryString;
import library.TimeConvert;
import bean.DayOff;
import bean.History;
import bean.User;

public class ModelHistory {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public int addItem(History objHistory){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO history(member_id,training_id,price_id,sale_id,begin_day,curent_price) VALUES (?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objHistory.getMemberId());
			pst.setInt(2,objHistory.getTrainingId());
			pst.setInt(3, objHistory.getPriceId());
			pst.setInt(4, objHistory.getSaleId());
			pst.setDate(5, objHistory.getBeginDay());
			pst.setInt(6, objHistory.getCurentPrice());
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
	public int getIdMax(){
		int id = 0;
		String sql = "SELECT id FROM history WHERE id=(SELECT max(id) FROM history)";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				id = rs.getInt("id");
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
	public int getDayOff(int current_history_id){
		int dayOff = 0;
		String sql = "SELECT * FROM `day_off` WHERE history_id = ?";
		ArrayList<DayOff> alDayOff = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, current_history_id);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int history_id = rs.getInt("history_id");
				Date start_day = rs.getDate("start_day");
				Date end_day = rs.getDate("end_day");
				DayOff objDayOff = new DayOff(id, history_id, start_day, end_day);
				alDayOff.add(objDayOff);
			}
			if(alDayOff == null){
				dayOff = 0;
			}else {
				for(DayOff objDayOff2:alDayOff){
					dayOff += TimeConvert.getDateDiff(objDayOff2.getStart_day(), objDayOff2.getEnd_day(), TimeUnit.DAYS);
				}
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
		return dayOff;
	}
	public ArrayList<DayOff> getDayOff(){
		int dayOff = 0;
		String sql = "SELECT * FROM `day_off`";
		ArrayList<DayOff> alDayOff = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int history_id = rs.getInt("history_id");
				Date start_day = rs.getDate("start_day");
				Date end_day = rs.getDate("end_day");
				DayOff objDayOff = new DayOff(id, history_id, start_day, end_day);
				alDayOff.add(objDayOff);
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
		return alDayOff;
	}
}
