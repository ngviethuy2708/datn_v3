package bean;

import java.sql.Date;

public class Statictis {
	private String year;
	private int month;
	private int total;
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Statictis(String year) {
		super();
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Statictis(int month, int total) {
		super();
		this.month = month;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Statictis [year=" + year + ", month=" + month + ", total="
				+ total + "]";
	}
	
	
	
}
