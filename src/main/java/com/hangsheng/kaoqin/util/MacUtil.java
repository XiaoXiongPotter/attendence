package com.hangsheng.kaoqin.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;

public class MacUtil {
	public static String getLocalIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getMac(HttpServletRequest request) {
		String ip = getLocalIp(request);
		return getMac(ip);
	}

	public static String getMac(String ip) {
		String str = null;
		String macAddress = null;
		System.out.println("ip:" + ip);
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -a " + ip);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			while ((str = input.readLine()) != null) {
			//	System.out.println("line:" + str);
				if (str.indexOf("MAC Address") > 1) {
					macAddress = str.substring(str.indexOf("MAC Address") + 14);
					break;
				}
				if (str.indexOf("MAC") > 1) {
					macAddress = str.substring(str.indexOf("MAC") + 10);
					break;
				}
			}
		} catch (IOException e) {
			// e.printStackTrace(System.out);
			return null;
		}
		return macAddress;
	}

	public static String getArpMac(String ip) {
		String macAdd = "";
		String arpCMD = "arp -a ";
		try {
			String string;
			Process process = Runtime.getRuntime().exec(arpCMD + ip);
			InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
			LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
			for (int i = 0; i < 100; i++) {
				string = lineNumberReader.readLine();
				// System.out.println(string);
				if (string != null) {
					if (string.indexOf(ip) > 1) {
						macAdd = string.substring(string.indexOf("at") + 3, string.indexOf("at") + 20);
						return macAdd;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		return macAdd;
	}

	public String getIp(HttpServletRequest request) throws Exception {
	    String ip = request.getHeader("X-Forwarded-For");
	    if (ip != null) {
	        if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
	            int index = ip.indexOf(",");
	            if (index != -1) {
	                return ip.substring(0, index);
	            } else {
	                return ip;
	            }
	        }
	    }
	    ip = request.getHeader("X-Real-IP");
	    if (ip != null) {
	        if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	    }
	    ip = request.getHeader("Proxy-Client-IP");
	    if (ip != null) {
	        if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	    }
	    ip = request.getHeader("WL-Proxy-Client-IP");
	    if (ip != null) {
	        if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
	            return ip;
	        }
	    }
	    ip =  request.getRemoteAddr();
	    return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	
	
	
}
