package bean;

import java.sql.Date;

public class DayOff {
	private int id;
	private int history_id;
	private Date start_day;
	private Date end_day;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHistory_id() {
		return history_id;
	}
	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}
	public Date getStart_day() {
		return start_day;
	}
	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}
	public Date getEnd_day() {
		return end_day;
	}
	public void setEnd_day(Date end_day) {
		this.end_day = end_day;
	}
	public DayOff(int id, int history_id, Date start_day, Date end_day) {
		super();
		this.id = id;
		this.history_id = history_id;
		this.start_day = start_day;
		this.end_day = end_day;
	}
	
	@Override
	public String toString() {
		return "DayOff [id=" + id + ", history_id=" + history_id
				+ ", start_day=" + start_day + ", end_day=" + end_day + "]";
	}
	public DayOff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
