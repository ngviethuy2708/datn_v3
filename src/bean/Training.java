package bean;

import java.sql.Date;

public class Training {
	private int id;
	private String name;
	private String preview;
	private String picture;
	private int dayOfTraining;
	private int priceId;
	private int saleId;
	private int price;
	private Date dateCreate;
	private boolean active;
	private int discount;
	private Date fromDate;
	private Date toDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getDayOfTraining() {
		return dayOfTraining;
	}
	public void setDayOfTraining(int dayOfTraining) {
		this.dayOfTraining = dayOfTraining;
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
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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
	public Training(int id, String name, String preview, String picture,
			int dayOfTraining, int priceId, int saleId, int price,
			Date dateCreate, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.picture = picture;
		this.dayOfTraining = dayOfTraining;
		this.priceId = priceId;
		this.saleId = saleId;
		this.price = price;
		this.dateCreate = dateCreate;
		this.active = active;
	}
	
	public Training(int id, String name, String preview, String picture,
			int dayOfTraining, int priceId, int saleId, Date dateCreate,
			boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.picture = picture;
		this.dayOfTraining = dayOfTraining;
		this.priceId = priceId;
		this.saleId = saleId;
		this.dateCreate = dateCreate;
		this.active = active;
	}
	
	public Training(int id, String name, String preview, String picture,
			int dayOfTraining, int priceId, Date dateCreate, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.picture = picture;
		this.dayOfTraining = dayOfTraining;
		this.priceId = priceId;
		this.dateCreate = dateCreate;
		this.active = active;
	}
	
	public Training(int id, String name, String preview, String picture,
			int dayOfTraining, int price, int discount, Date fromDate,
			Date toDate) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.picture = picture;
		this.dayOfTraining = dayOfTraining;
		this.price = price;
		this.discount = discount;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public Training(int id, String name, String preview, String picture,
			int dayOfTraining, int price) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.picture = picture;
		this.dayOfTraining = dayOfTraining;
		this.price = price;
	}
	
	public Training(int id, String preview ,String picture, int priceId, int saleId,
			Date dateCreate) {
		super();
		this.id = id;
		this.preview = preview;
		this.picture = picture;
		this.priceId = priceId;
		this.saleId = saleId;
		this.dateCreate = dateCreate;
	}
	
	
	public Training(int id, String name, int dayOfTraining, int priceId,
			int saleId, int price, int discount, Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.name = name;
		this.dayOfTraining = dayOfTraining;
		this.priceId = priceId;
		this.saleId = saleId;
		this.price = price;
		this.discount = discount;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public Training(int id, String name, int dayOfTraining, int priceId,
			int saleId, int price) {
		super();
		this.id = id;
		this.name = name;
		this.dayOfTraining = dayOfTraining;
		this.priceId = priceId;
		this.saleId = saleId;
		this.price = price;
	}
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Training [id=" + id + ", name=" + name + ", preview=" + preview
				+ ", picture=" + picture + ", dayOfTraining=" + dayOfTraining
				+ ", priceId=" + priceId + ", saleId=" + saleId + ", price="
				+ price + ", dateCreate=" + dateCreate + ", active=" + active
				+ ", discount=" + discount + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	
}
