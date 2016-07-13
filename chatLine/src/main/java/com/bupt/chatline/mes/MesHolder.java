package com.bupt.chatline.mes;

import java.util.regex.Pattern;

public class MesHolder {
	public static String sendToUri = "/topic/cMes/";
	public static Pattern pattern = Pattern.compile("[1-9][0-9]{10}");
}
