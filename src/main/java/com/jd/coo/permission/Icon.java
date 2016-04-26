package com.jd.coo.permission;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


/**
 * 配置级别
 *
 */
public enum Icon {
	dept("dept","glyphicon glyphicon-tasks"),
	app("app","glyphicon glyphicon-th"),
	user("param","glyphicon glyphicon-tags"),
	resource("user","glyphicon glyphicon-user"),
	param("role","glyphicon glyphicon-pause"),
	role("resource","glyphicon glyphicon-th-list");
	
	private  String code;
	private String value;
	
	
	public static final Map<String, String> icon_map = new HashMap<String, String>();
	
	 static {
	        for (Icon e : EnumSet.allOf(Icon.class)) {
	        	icon_map.put(e.code, e.value);
	        }
	    }
	  
	private Icon(String code, String value) {
		this.code = code;
		this.value = value;
	}
	
	  public static String getIcon(String key) {
	        return icon_map.get(key);
	    }
}
