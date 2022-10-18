package com.bicimoto.app.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	public static Date convertirStringFecha(String fecha, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(fecha);
	}

	public static String dateToString(Date date,String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static LocalDate getDateFormatter(String format, Date fecha) {

		SimpleDateFormat formateador = new SimpleDateFormat(format);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		String fechaString = formateador.format(fecha);
		LocalDate fechaFormatter = LocalDate.parse(fechaString, formatter);

		return fechaFormatter;
	}

	public static String parseDateTime(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		try {
			Date date1 = format.parse(date.replace("T"," "));
			String d= new SimpleDateFormat("yyyy/dd/MM HH:mm:ss").format(date1);
			return d;
		}catch (Exception e){
			e.printStackTrace();
		}
		return "";
	}

	public static String formatTime(String hora) {

		String[] valorHora = hora.split(":");
		int hour = Integer.valueOf(valorHora[0]);
		int minutes = Integer.valueOf(valorHora[1]);

		String meridiem = hour > 11 ? "PM" : "AM";
		// trim "0-23 hour" to "0-11 hour", then replace "0" with "12"
		hour = (hour %= 12) == 0 ? (meridiem.equals("AM") ? 0: 12) : hour;
		// Apply desired format "HH:MM AM/PM"
		return String.format("%02d:%02d %s", hour, minutes, meridiem );
	}

	public static Date sumarRestarDiasFecha(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();

	}

}
