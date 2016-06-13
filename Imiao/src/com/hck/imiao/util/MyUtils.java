package com.hck.imiao.util;

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
}
