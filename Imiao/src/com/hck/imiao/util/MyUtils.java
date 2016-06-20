package com.hck.imiao.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MyUtils {
	public static String[] getStrings(String msg) {
		String[] data = msg.split(",");
		return data;
	}

	public static String getUUID() {
		String uuidString = UUID.randomUUID().toString();
		return uuidString.replaceAll("-", "");
	}
	public static Date getNowDate() {
		   Date currentTime = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String dateString = formatter.format(currentTime);
		   ParsePosition pos = new ParsePosition(8);
		   Date currentTime_2 = formatter.parse(dateString, pos);
		   return currentTime_2;
		}

}
