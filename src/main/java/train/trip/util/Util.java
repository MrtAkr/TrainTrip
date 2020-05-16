package train.trip.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

public class Util {

	public static Converter<Date, String> cnvDateToString() {
		return new AbstractConverter<Date, String>() {
		    @Override
		    protected String convert(Date source) {
		    	if (source == null) {
		    		return "";
		    	}
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        return sdf.format(source);
		    }
		};
	}
	
	public static Date cnvUtcDate(Date source) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.parse(sdf.format(source));
	}
	
	public static Date cnvJstDate(Date source) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		return sdf.parse(sdf.format(source));
	}
	
	public static Date adjustUtcDate(Date source) throws ParseException {
		Calendar cl = Calendar.getInstance();
		cl.setTime(source);
		cl.add(Calendar.DATE, 1);
		return cl.getTime();
	}
}
