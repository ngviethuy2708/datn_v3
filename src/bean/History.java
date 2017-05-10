package bean;

import java.sql.Date;

public class History {
	private int id;
	private int memberId;
	private int trainingId;
	private int priceId;
	private int saleId;
	private Date beginDay;
	private int curentPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public int getPriceId() {
		return priceId;
	}
	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public Date getBeginDay() {
		return beginDay;
	}
	public void setBeginDay(Date beginDay) {
		this.beginDay = beginDay;
	}
	public int getCurentPrice() {
		return curentPrice;
	}
	public void setCurentPrice(int curentPrice) {
		this.curentPrice = curentPrice;
	}
	public History(int id, int memberId, int trainingId, int priceId,
			int saleId, Date beginDay, int curentPrice) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.trainingId = trainingId;
		this.priceId = priceId;
		this.saleId = saleId;
		this.beginDay = beginDay;
		this.curentPrice = curentPrice;
	}
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "History [id=" + id + ", memberId=" + memberId + ", trainingId="
				+ trainingId + ", priceId=" + priceId + ", saleId=" + saleId
				+ ", beginDay=" + beginDay + ", curentPrice=" + curentPrice
				+ "]";
	}
	
	
}
