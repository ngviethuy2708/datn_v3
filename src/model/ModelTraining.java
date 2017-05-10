package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
















import library.LibraryString;
import library.TimeConvert;
import bean.SearchForDate;
import bean.Search;
import bean.Training;
import bean.User;


public class ModelTraining {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<Training> getList(){
		ArrayList<Training> alTraining = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM training";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				Date dateCreate = rs.getDate("day_create");
				Boolean active = rs.getBoolean("active");
				Training objTraining = new Training(id, name, preview, picture, dayOfTraining, priceId, saleId, dateCreate, active);
				alTraining.add(objTraining);
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
		return alTraining;
	}
	public ArrayList<Training> getListForMember(){
		ArrayList<Training> alTraining = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM training where active = true";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				Date dateCreate = rs.getDate("day_create");
				Boolean active = rs.getBoolean("active");
				Training objTraining = new Training(id, name, preview, picture, dayOfTraining, priceId, saleId, dateCreate, active);
				alTraining.add(objTraining);
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
		return alTraining;
	}
	public Training getItemForMemberSale(int id){
		Training objTraining = null;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT training.id,training.name,training.price_id,training.sale_id,training.day_of_training,price.price,sale.discount,sale.from_date,sale.to_date FROM training JOIN price ON training.price_id = price.id JOIN sale ON training.sale_id = sale.id WHERE training.id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				int price = rs.getInt("price");
				int discount = rs.getInt("discount");
				Date fromDate = rs.getDate("from_date");
				Date toDate = rs.getDate("to_date");
				objTraining = new Training(id, name, dayOfTraining, priceId, saleId, price, discount, fromDate, toDate);
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
		return objTraining;
	}
	public Training getItemForMemberNoSale(int id){
		Training objTraining = null;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT training.id,training.name,training.price_id,training.sale_id,training.day_of_training,price.price FROM training JOIN price ON training.price_id = price.id WHERE training.id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				int price = rs.getInt("price");
				objTraining = new Training(id, name, dayOfTraining, priceId, saleId, price);
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
		return objTraining;
	}
	public ArrayList<Training> getListForPaginator(int offset, int rowCount){
		ArrayList<Training> alTraining = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM training  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				Date dateCreate = rs.getDate("day_create");
				Boolean active = rs.getBoolean("active");
				Training objTraining = new Training(id, name, preview, picture, dayOfTraining, priceId, saleId, dateCreate, active);
				alTraining.add(objTraining);
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
		return alTraining;
	}
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(id) AS sodong FROM training ";
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
	public int getPrice(int id){
		int price = 0;
		String sql ="SELECT price.price AS price from training JOIN price ON price.id = training.price_id where training.id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				price = rs.getInt("price");	
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
		return price;
	}
	public int getPriceOfSale(int id){
		int curent_price = 0;
		int price = 0;
		int discount = 0;
		String from = "";
		String to = "";
		String sql ="SELECT price.price AS price,sale.discount AS discount ,sale.from_date AS from_date, sale.to_date AS to_date FROM training JOIN price ON price.id = training.price_id JOIN sale ON sale.id = training.sale_id WHERE training.id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				price = rs.getInt("price");
				discount = rs.getInt("discount");
				Date fromSql = rs.getDate("from_date");
				java.util.Date fromUtil = TimeConvert.getNormalDate(fromSql);
				from = TimeConvert.getStringDatetime(fromUtil);
				Date toSql = rs.getDate("to_date");
				java.util.Date toUtil = TimeConvert.getNormalDate(toSql);
				to = TimeConvert.getStringDatetime(toUtil);
			}
			if(discount != 0){
				if(TimeConvert.checkSale(from,to) == true){
					curent_price = price - ((price*discount)/100);
				}else{
					curent_price = price;
				}
			}else{
				curent_price = price;
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
		return curent_price;
	}
	public int getDiscount(int id){
		int discount = 0;
		String from = "";
		String to = "";
		String sql = "SELECT sale.discount AS discount ,sale.from_date AS from_date, sale.to_date AS to_date FROM training JOIN sale ON sale.id = training.sale_id WHERE training.id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				discount = rs.getInt("discount");
				Date fromSql = rs.getDate("from_date");
				java.util.Date fromUtil = TimeConvert.getNormalDate(fromSql);
				from = TimeConvert.getStringDatetime(fromUtil);
				Date toSql = rs.getDate("to_date");
				java.util.Date toUtil = TimeConvert.getNormalDate(toSql);
				to = TimeConvert.getStringDatetime(toUtil);
			}
			if(discount != 0){
				if(TimeConvert.checkSale(from,to) == true){
					discount = discount;
				}else{
					discount = 0;
				}
			}else{
				discount = 0;
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
		return discount;
	}
	public int setActive(int nid, int active) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(active == 0){
				String sql = "UPDATE training SET active = 1 WHERE id = ?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}else{
				String sql = "UPDATE training SET active = 0 WHERE id = ?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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
	public ArrayList<Training> getListForSearch(Search item){
		ArrayList<Training> alTraining = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "select * from training where (active = '"+item.getType()+"' and  name like '%"+item.getSomething()+"%') or (active = '"+item.getType()+"' and  preview like '%"+item.getSomething()+"%')";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				Date dateCreate = rs.getDate("day_create");
				Boolean active = rs.getBoolean("active");
				Training objTraining = new Training(id, name, preview, picture, dayOfTraining, priceId, saleId, dateCreate, active);
				alTraining.add(objTraining);
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
		return alTraining;
	}
	public ArrayList<Training> getListForSearchDate(SearchForDate item){
		ArrayList<Training> alTraining = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "select * from training where (active = '"+item.getType()+"' and  day_create = '"+item.getDate()+"') ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				Date dateCreate = rs.getDate("day_create");
				Boolean active = rs.getBoolean("active");
				Training objTraining = new Training(id, name, preview, picture, dayOfTraining, priceId, saleId, dateCreate, active);
				alTraining.add(objTraining);
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
		return alTraining;
	}
	public int addItem(Training objTraining){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO training(name,preview,picture,price_id,sale_id,day_of_training,day_create,active) VALUES (?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objTraining.getName());
			pst.setString(2, objTraining.getPreview());
			pst.setString(3, objTraining.getPicture());
			pst.setInt(4, objTraining.getPriceId());
			pst.setInt(5, objTraining.getSaleId());
			pst.setInt(6, objTraining.getDayOfTraining());
			pst.setDate(7, objTraining.getDateCreate());
			pst.setBoolean(8, objTraining.isActive());
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
	public int editItem(Training objTraining){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="UPDATE training SET picture = ?,preview = ? ,price_id = ?, sale_id = ?, day_create = ? WHERE id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objTraining.getPicture());
			pst.setString(2, objTraining.getPreview());
			pst.setInt(3, objTraining.getPriceId());
			pst.setInt(4, objTraining.getSaleId());
			pst.setDate(5, objTraining.getDateCreate());
			pst.setInt(6, objTraining.getId());
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
	public Training getItem(int id){
		Training objTraining = null;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM training where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				Date dateCreate = rs.getDate("day_create");
				Boolean active = rs.getBoolean("active");
				objTraining = new Training(id, name, preview, picture, dayOfTraining, priceId, saleId, dateCreate, active);
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
		return objTraining;
	}
	public Training getItemSale(int id){
		Training objTraining = null;
		conn = mConnect.getConnectSQL();
		String sql = "select training.name,training.preview,training.picture,training.day_of_training,price.price,sale.discount,sale.from_date,sale.to_date from training join price on training.price_id = price.id join sale on training.sale_id = sale.id where training.id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int price = rs.getInt("price");
				int discount = rs.getInt("discount");
				Date fromDate = rs.getDate("from_date");
				Date toDate = rs.getDate("to_date");
				objTraining = new Training(id, name, preview, picture, dayOfTraining, price, discount, fromDate, toDate);
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
		return objTraining;
	}
	public Training getItemNoSale(int id){
		Training objTraining = null;
		conn = mConnect.getConnectSQL();
		String sql = "select training.name,training.preview,training.picture,training.day_of_training,price.price from training join price on training.price_id = price.id  where training.id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int price = rs.getInt("price");
				objTraining = new Training(id, name, preview, picture, dayOfTraining, price);
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
		return objTraining;
	}
	public ArrayList<Training> getListForPublic(){
		ArrayList<Training> alTraining = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM `training` WHERE active = true ORDER BY id DESC LIMIT 3";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String preview = rs.getString("preview");
				String picture = rs.getString("picture");
				int dayOfTraining = rs.getInt("day_of_training");
				int priceId = rs.getInt("price_id");
				int saleId = rs.getInt("sale_id");
				Date dateCreate = rs.getDate("day_create");
				Boolean active = rs.getBoolean("active");
				Training objTraining = new Training(id, name, preview, picture, dayOfTraining, priceId, saleId, dateCreate, active);
				alTraining.add(objTraining);
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
		return alTraining;
	}
	/*public int delItem(int tid){
		int result = 0;
		String sql = "DELETE FROM trainingschedule WHERE Idtraining = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, tid);
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
	
	public Training getItem(int tid){
		Training objTraining = null;
		String sql = "SELECT * FROM trainingschedule WHERE Idtraining = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, tid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idTraining = rs.getInt("Idtraining");
				String nameTraining = rs.getString("Trainingname");
				int dayTraining = rs.getInt("Trainingday");
				int priceTraining = rs.getInt("Trainingprice");
				objTraining = new Training(idTraining, nameTraining, dayTraining, priceTraining); 
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
		return objTraining;
	}
	
	public int editItem(Training objTraining){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE trainingschedule SET  Trainingname = ?,Trainingday = ?, Trainingprice = ? WHERE Idtraining = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objTraining.getNameTraining());
			pst.setInt(2, objTraining.getDayTraining());
			pst.setInt(3, objTraining.getPriceTraining());
			pst.setInt(4, objTraining.getIdTraining());
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
	*/
}
