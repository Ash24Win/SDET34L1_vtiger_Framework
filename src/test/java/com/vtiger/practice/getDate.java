package com.vtiger.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		// to get date in simple format
		SimpleDateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss");
		String date1 = df.format(date);
		System.out.println(date1);
		
	}

}
