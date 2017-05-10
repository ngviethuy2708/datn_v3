package library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeConvert {
	public static String getStringDatetime(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return dateFormat.format(cal.getTime());
	}
	public static Date getDateTime(String stringDate) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			Date date = df.parse(stringDate);
			return date;
		}
		catch (ParseException ex){
			return null;
		}
	}
	public static java.sql.Date getSqlDate(Date normalDate){
		return new java.sql.Date(normalDate.getTime());
	}
	public static Date getNormalDate(java.sql.Date sqlDate){
		return new Date(sqlDate.getTime());
	}
	public static boolean isDate(String something){
		boolean result = false;
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(something);
			result = true;
			} catch (Exception ex) {
				
			}
		return result;
	}
	public static String getDateNow(){
		Date today=new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = timeFormat.format(today.getTime());
		return dateStr;
	}
	public static boolean isEnddate(String dateSql,String dateNow){
		boolean result;
		if(dateSql.equals(dateNow)){
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	public static boolean checkSale(String from,String to){
		Boolean check = false;
		String curentDateStr = getDateNow();
		Date curentDateUntil = getDateTime(curentDateStr);
		java.sql.Date curentDateSql = getSqlDate(curentDateUntil);
		Date fromUntil = getDateTime(from);
		java.sql.Date fromSQl = getSqlDate(fromUntil);
		Date toUntil = getDateTime(to);
		java.sql.Date toSql = getSqlDate(toUntil);
		if (from != null && to != null) {
	        if ((curentDateSql.after(fromSQl) || curentDateSql.equals(fromSQl)) && (curentDateSql.before(toSql) || curentDateSql.equals(toSql))) {
	            check = true;
	        }
	        else {
	            check = false;
	        }
	    }
		return check;
	}
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	public static Date removeTime(Date date) {    
	    Calendar cal = Calendar.getInstance();  
	    cal.setTime(date);  
	    cal.set(Calendar.HOUR_OF_DAY, 0);  
	    cal.set(Calendar.MINUTE, 0);  
	    cal.set(Calendar.SECOND, 0);  
	    cal.set(Calendar.MILLISECOND, 0);  
	    return cal.getTime(); 
	}
}
