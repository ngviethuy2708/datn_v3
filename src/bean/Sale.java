package bean;

import java.sql.Date;

public class Sale {
	private int id;
	private int discount;
	private Date fromDate;
	private Date toDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Sale(int id, int discount, Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.discount = discount;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
