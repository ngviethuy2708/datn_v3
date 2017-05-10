package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.zip.Adler32;

import library.LibraryString;
import bean.DayOff;
import bean.Member;
import bean.Statictis;
import bean.Training;
import bean.User;

public class ModelMember {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public int addItem(Member objMember){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO member(user_id,curent_history_id,is_expired) VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objMember.getUserId());
			pst.setInt(2, 0);
			pst.setBoolean(3, true);
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
		String sql = "SELECT id FROM member WHERE id=(SELECT max(id) FROM member)";
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
	public int editItem(Member objMember){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="UPDATE member SET curent_history_id = ? WHERE id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objMember.getCurentHistoryId());
			pst.setInt(2, objMember.getId());
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
	public ArrayList<Member> getListForPaginator(int offset, int rowCount){
		ArrayList<Member> alMember = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT member.id, member.curent_history_id, user.user_name, user.full_name ,training.name, training.day_of_training,  history.begin_day, history.curent_price, member.is_expired FROM member JOIN user ON member.user_id = user.id JOIN history ON member.curent_history_id = history.id JOIN training ON history.training_id = training.id limit ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int curentHistoryId = rs.getInt("curent_history_id");
				Boolean isExpired = rs.getBoolean("is_expired");
				String fullName = rs.getString("full_name");
				String userName = rs.getString("user_name");
				String trainingName = rs.getString("name");
				int dayOfTraining = rs.getInt("day_of_training");
				Date beginDay = rs.getDate("begin_day");
				Member objMember = new Member(id, curentHistoryId, isExpired, fullName, userName, trainingName, dayOfTraining, beginDay);
				alMember.add(objMember);
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
		return alMember;
	}
	public ArrayList<Member> getList(){
		ArrayList<Member> alMember = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT member.id, member.curent_history_id, user.user_name, user.full_name ,training.name, training.day_of_training,  history.begin_day, history.curent_price, member.is_expired FROM member JOIN user ON member.user_id = user.id JOIN history ON member.curent_history_id = history.id JOIN training ON history.training_id = training.id";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int curentHistoryId = rs.getInt("curent_history_id");
				Boolean isExpired = rs.getBoolean("is_expired");
				String fullName = rs.getString("full_name");
				String userName = rs.getString("user_name");
				String trainingName = rs.getString("name");
				int dayOfTraining = rs.getInt("day_of_training");
				Date beginDay = rs.getDate("begin_day");
				Member objMember = new Member(id, curentHistoryId, isExpired, fullName, userName, trainingName, dayOfTraining, beginDay);
				alMember.add(objMember);
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
		return alMember;
	}
	public ArrayList<Member> getListForViewHistory(int memberId){
		ArrayList<Member> alMember = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT training.name, training.day_of_training,history.begin_day,history.curent_price,history.id,member.is_expired FROM history JOIN training ON history.training_id = training.id JOIN member ON history.member_id = member.id WHERE history.member_id =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, memberId);
			rs = pst.executeQuery();
			while(rs.next()){
				String trainingName = rs.getString("name");
				int dayOfTraining = rs.getInt("day_of_training");
				Date beginDay = rs.getDate("begin_day");
				int current_price = rs.getInt("curent_price");
				int historyId = rs.getInt("id");
				Boolean isExpired = rs.getBoolean("is_expired");
				Member objMember = new Member(trainingName, dayOfTraining, beginDay, current_price, historyId,isExpired);
				alMember.add(objMember);
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
		return alMember;
	}
	public ArrayList<Member> getListKeyWord(String keyword){
		ArrayList<Member> alMember = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT member.id, member.curent_history_id, user.user_name, user.full_name ,training.name, training.day_of_training,  history.begin_day, history.curent_price, member.is_expired FROM member JOIN user ON member.user_id = user.id JOIN history ON member.curent_history_id = history.id JOIN training ON history.training_id = training.id WHERE user.user_name like '%"+keyword+"%' or user.full_name like '%"+keyword+"%'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int curentHistoryId = rs.getInt("curent_history_id");
				Boolean isExpired = rs.getBoolean("is_expired");
				String fullName = rs.getString("full_name");
				String userName = rs.getString("user_name");
				String trainingName = rs.getString("name");
				int dayOfTraining = rs.getInt("day_of_training");
				Date beginDay = rs.getDate("begin_day");
				Member objMember = new Member(id, curentHistoryId, isExpired, fullName, userName, trainingName, dayOfTraining, beginDay);
				alMember.add(objMember);
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
		return alMember;
	}
	public int getIdMember(int uid){
		int id = 0;
		String sql = "SELECT id FROM member WHERE user_id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
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
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(id) AS sodong FROM member ";
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
	public int setExprired(int id) {
		int result = 0;
		String sql ="UPDATE member set is_expired = false where id = ?";
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
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int setExpriredForAddHistory(int id) {
		int result = 0;
		String sql ="UPDATE member set is_expired = true where id = ?";
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
	public Member getListForDayOff(int historyid){
		Member objMember = null; 
		conn = mConnect.getConnectSQL();
		String sql = "SELECT member.id, member.curent_history_id, user.user_name, user.full_name ,training.name, training.day_of_training,  history.begin_day, history.curent_price, member.is_expired FROM member JOIN user ON member.user_id = user.id JOIN history ON member.curent_history_id = history.id JOIN training ON history.training_id = training.id WHERE history.id = ? limit 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, historyid);
			rs = pst.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				int curentHistoryId = rs.getInt("curent_history_id");
				Boolean isExpired = rs.getBoolean("is_expired");
				String fullName = rs.getString("full_name");
				String userName = rs.getString("user_name");
				String trainingName = rs.getString("name");
				int dayOfTraining = rs.getInt("day_of_training");
				Date beginDay = rs.getDate("begin_day");
				objMember = new Member(id, curentHistoryId, isExpired, fullName, userName, trainingName, dayOfTraining, beginDay);
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
		return objMember;
	}
	public ArrayList<Statictis> getYear(){
		ArrayList<Statictis> alSta = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT year(begin_day) as year FROM `history` group by year(begin_day) DESC";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				String year = rs.getString("year");
				Statictis objSta = new Statictis(year);
				alSta.add(objSta);
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
		return alSta;
	}
	public String getYearMax(){
		String yearMax = "";
		conn = mConnect.getConnectSQL();
		String sql = "SELECT year(begin_day) as year FROM `history` group by year(begin_day) DESC limit 1";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				yearMax = rs.getString("year");
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
		return yearMax;
	}
	public int  getTotalPrice(int month,String year){
		int total = 0;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT sum(curent_price) as total FROM `history` WHERE year(begin_day) = "+year+" and month(begin_day) = "+month+" group by month(begin_day)";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	public int  countUser(){
		int total = 0;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT count(id) as total from user where is_member = false";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	public int  countMember(){
		int total = 0;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT count(user.id) as total from user join member on user.id = member.user_id where user.is_member = true";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	public int  countPost(){
		int total = 0;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT count(id) as total from post ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				total = rs.getInt("total");
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
		return total;
	}
	public ArrayList<Member> getListForViewHistoryPublic(int memberId){
		ArrayList<Member> alMember = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT training.name, training.day_of_training,training.picture, history.begin_day,history.curent_price,history.id,member.is_expired FROM history JOIN training ON history.training_id = training.id JOIN member ON history.member_id = member.id WHERE history.member_id =? order by history.id DESC";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, memberId);
			rs = pst.executeQuery();
			while(rs.next()){
				String trainingName = rs.getString("name");
				int dayOfTraining = rs.getInt("day_of_training");
				String picture = rs.getString("picture");
				Date beginDay = rs.getDate("begin_day");
				int current_price = rs.getInt("curent_price");
				int historyId = rs.getInt("id");
				Boolean isExpired = rs.getBoolean("is_expired");
				Member objMember = new Member(trainingName, dayOfTraining,picture, beginDay, current_price, historyId,isExpired);
				alMember.add(objMember);
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
		return alMember;
	}
	public int getCurrentHistoryId(int mid){
		int id = 0;
		String sql = "SELECT curent_history_id FROM member WHERE id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mid);
			rs = pst.executeQuery();
			if(rs.next()){
				id = rs.getInt("curent_history_id");
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
	public DayOff getDayOffForHistoryMember(int historyid){
		DayOff objDayoff = null;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM `day_off` WHERE history_id = ? order by id DESC LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, historyid);
			rs = pst.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				int history_id = rs.getInt("history_id");
				Date start_day = rs.getDate("start_day");
				Date end_day = rs.getDate("end_day");
				objDayoff = new DayOff(id, history_id, start_day, end_day);
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
		return objDayoff;
	}
	public ArrayList<DayOff> getAlDayOff(int historyid){
		ArrayList<DayOff> alDayOff = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM `day_off` WHERE history_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, historyid);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int history_id = rs.getInt("history_id");
				Date start_day = rs.getDate("start_day");
				Date end_day = rs.getDate("end_day");
				DayOff objDayoff = new DayOff(id, history_id, start_day, end_day);
				alDayOff.add(objDayoff);
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
		return alDayOff;
	}
	public int addDayOff(DayOff objDayOff){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO day_off(history_id,start_day,end_day) VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objDayOff.getHistory_id());
			pst.setDate(2, objDayOff.getStart_day());
			pst.setDate(3, objDayOff.getEnd_day());
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
}
