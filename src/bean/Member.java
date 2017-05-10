package bean;

import java.sql.Date;

public class Member {
	private int id;
	private int userId;
	private int curentHistoryId;
	private Boolean isExpired;
	private String fullName;
	private String userName;
	private String trainingName;
	private int dayOfTraining;
	private int dayOff;
	private Date beginDay;
	private java.util.Date endDay;
	private int current_price;
	private int historyId;
	private Date expectedDate;
	private Date startDayOff;
	private Date endDayOff;
	private String trainingImage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCurentHistoryId() {
		return curentHistoryId;
	}
	public void setCurentHistoryId(int curentHistoryId) {
		this.curentHistoryId = curentHistoryId;
	}
	public Boolean getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public int getDayOfTraining() {
		return dayOfTraining;
	}
	public void setDayOfTraining(int dayOfTraining) {
		this.dayOfTraining = dayOfTraining;
	}
	public Date getBeginDay() {
		return beginDay;
	}
	public void setBeginDay(Date beginDay) {
		this.beginDay = beginDay;
	}
	public java.util.Date getEndDay() {
		return endDay;
	}
	public void setEndDay(java.util.Date endDay) {
		this.endDay = endDay;
	}
	
	public int getDayOff() {
		return dayOff;
	}
	public void setDayOff(int dayOff) {
		this.dayOff = dayOff;
	}
	
	public int getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(int current_price) {
		this.current_price = current_price;
	}
	
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	
	public Date getStartDayOff() {
		return startDayOff;
	}
	public void setStartDayOff(Date startDayOff) {
		this.startDayOff = startDayOff;
	}
	public Date getEndDayOff() {
		return endDayOff;
	}
	public void setEndDayOff(Date endDayOff) {
		this.endDayOff = endDayOff;
	}
	
	public String getTrainingImage() {
		return trainingImage;
	}
	public void setTrainingImage(String trainingImage) {
		this.trainingImage = trainingImage;
	}
	public Member(int id, int userId, int curentHistoryId, Boolean isExpired,
			String fullName, String userName, String trainingName,
			int dayOfTraining, Date beginDay, java.util.Date endDay) {
		super();
		this.id = id;
		this.userId = userId;
		this.curentHistoryId = curentHistoryId;
		this.isExpired = isExpired;
		this.fullName = fullName;
		this.userName = userName;
		this.trainingName = trainingName;
		this.dayOfTraining = dayOfTraining;
		this.beginDay = beginDay;
		this.endDay = endDay;
	}
	public Member(int id, int userId, int curentHistoryId) {
		super();
		this.id = id;
		this.userId = userId;
		this.curentHistoryId = curentHistoryId;
	}
	public Member(int id, int userId, int curentHistoryId, Boolean isExpired) {
		super();
		this.id = id;
		this.userId = userId;
		this.curentHistoryId = curentHistoryId;
		this.isExpired = isExpired;
	}
	public Member(int id,int curentHistoryId, Boolean isExpired, String fullName, String userName,
			String trainingName, int dayOfTraining, Date beginDay) {
		super();
		this.id = id;
		this.curentHistoryId = curentHistoryId;
		this.isExpired = isExpired;
		this.fullName = fullName;
		this.userName = userName;
		this.trainingName = trainingName;
		this.dayOfTraining = dayOfTraining;
		this.beginDay = beginDay;
	}
	
	public Member(String trainingName, int dayOfTraining, Date beginDay,
			int current_price, int historyId, Boolean isExpired) {
		super();
		this.trainingName = trainingName;
		this.dayOfTraining = dayOfTraining;
		this.beginDay = beginDay;
		this.current_price = current_price;
		this.historyId = historyId;
		this.isExpired = isExpired;
	}
	public Member(String trainingName, int dayOfTraining,String picTure, Date beginDay,
			int current_price, int historyId, Boolean isExpired) {
		super();
		this.trainingName = trainingName;
		this.dayOfTraining = dayOfTraining;
		this.trainingImage = picTure;
		this.beginDay = beginDay;
		this.current_price = current_price;
		this.historyId = historyId;
		this.isExpired = isExpired;
	}
	public Member(int id, int userId, int curentHistoryId, Boolean isExpired,
			String fullName, String userName, String trainingName,
			int dayOfTraining, int dayOff, Date beginDay,
			java.util.Date endDay, int current_price, int historyId,
			Date expectedDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.curentHistoryId = curentHistoryId;
		this.isExpired = isExpired;
		this.fullName = fullName;
		this.userName = userName;
		this.trainingName = trainingName;
		this.dayOfTraining = dayOfTraining;
		this.dayOff = dayOff;
		this.beginDay = beginDay;
		this.endDay = endDay;
		this.current_price = current_price;
		this.historyId = historyId;
		this.expectedDate = expectedDate;
	}
	
	public Member(int id, int curentHistoryId) {
		super();
		this.id = id;
		this.curentHistoryId = curentHistoryId;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", userId=" + userId + ", curentHistoryId="
				+ curentHistoryId + ", isExpired=" + isExpired + ", fullName="
				+ fullName + ", userName=" + userName + ", trainingName="
				+ trainingName + ", dayOfTraining=" + dayOfTraining
				+ ", dayOff=" + dayOff + ", beginDay=" + beginDay + ", endDay="
				+ endDay + "]";
	}
	
	
	
	
	
}
