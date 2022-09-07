package br.com.btf.spring.data.service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Teste {

	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		String t = "02:20:00";
		Time time = Time.valueOf(t);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		LocalTime tempo = LocalTime.parse(t, sdf);
		
		System.out.println(time);

	}

}
