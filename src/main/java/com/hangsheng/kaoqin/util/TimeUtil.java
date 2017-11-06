package com.hangsheng.kaoqin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	 public static boolean isInTime(String sourceTime, Date curTime)
	  {
	    if ((sourceTime == null) || (!sourceTime.contains("-")) || (!sourceTime.contains(":"))) {
	      throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
	    }
	    SimpleDateFormat ddf = new SimpleDateFormat("yyyy-MM-dd");
	    String dayDate =   ddf.format(curTime);
	    String[] args = sourceTime.split("-");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    try {
	      long now = curTime.getTime();
	      long start = sdf.parse(dayDate+" "+args[0]).getTime();
	      long end = sdf.parse(dayDate+" "+args[1]).getTime();
	      
	   //   System.out.println("now:"+now);
	   //   System.out.println("start:"+start);
	   //   System.out.println("end:"+end);
	      if (args[1].equals("00:00")) {
	        args[1] = "24:00";
	      }
	      if (end < start) {
	        if ((now >= end) && (now < start)) {
	          return false;
	        }
	        return true;
	      }

	      if ((now >= start) && (now < end)) {
	        return true;
	      }
	      return false;
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
	  }
}
