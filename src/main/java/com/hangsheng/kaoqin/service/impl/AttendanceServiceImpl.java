package com.hangsheng.kaoqin.service.impl;
import com.hangsheng.kaoqin.domain.Attendance;
import com.hangsheng.kaoqin.domain.AttendanceSignInAndSignOutFormBean;
import com.hangsheng.kaoqin.domain.AttendanceStatBean;
import com.hangsheng.kaoqin.domain.Staff;
import com.hangsheng.kaoqin.service.api.AttendanceService;
import com.hangsheng.kaoqin.util.MacUtil;
import com.hangsheng.kaoqin.util.TimeUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;

/**
 * = AttendanceServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = AttendanceService.class)
public class AttendanceServiceImpl implements AttendanceService {
	public void processOfflineAttendances() {
	    List<Attendance> as = getAttendanceRepository().findBySignOutIsNull(null).getContent();

	    HashSet<String> macset = new HashSet<String> ();
	    String ip = "192.168.0.";
	    for (int i = 1; i < 255; i++) {
	      String mac = "";
	      if ((mac = MacUtil.getMac(ip + i)) != null) {
	        macset.add(mac);
	      }
	    }

	    ip = "192.168.1.";
	    String mac;
	    for (int i = 1; i < 255; i++) {
	      mac = "";
	      if ((mac = MacUtil.getMac(ip + i)) != null) {
	        macset.add(mac);
	      }
	    }
	    for (Attendance a : as)
	    	
	      if (!macset.contains(a.getStaff().getMac()))
	      {
	        a.setSignOut(Calendar.getInstance());
	        getAttendanceRepository().save(a);
	      }
	  }

	  public void processTimeOutAttendances()
	  {
	    List<Attendance> as = getAttendanceRepository().findBySignOutIsNull(null).getContent();
	    for (Attendance a : as) {
	    	  a.setSignOut(Calendar.getInstance());
		        getAttendanceRepository().save(a);
	    }
	  }
	  
	 
	  public List<Attendance> findTodayAttendances(){
			Calendar begin = Calendar.getInstance();
			begin.set(Calendar.HOUR_OF_DAY, 6);
			begin.set(Calendar.SECOND,0);
			begin.set(Calendar.MINUTE,0);
			
			Calendar end = Calendar.getInstance();
			end.set(Calendar.HOUR_OF_DAY, 23);
			end.set(Calendar.SECOND,0);
			end.set(Calendar.MINUTE,0);
			AttendanceSignInAndSignOutFormBean formBean = new AttendanceSignInAndSignOutFormBean(begin,end);
			return getAttendanceRepository().findBySignInAfterAndSignOutBefore(formBean, null, null).getContent();
		}
	 
	  
		public List<AttendanceStatBean> statBySignInAfterAndSignOutBefore(AttendanceSignInAndSignOutFormBean formBean){
			List<Attendance> ads = getAttendanceRepository().findBySignInAfterAndSignOutBefore(formBean, null,null).getContent();
			List<AttendanceStatBean> asbs = new ArrayList<AttendanceStatBean>();
			HashSet<Staff> ss = new HashSet<Staff>();
			for(Attendance a:ads){
				ss.add(a.getStaff());
			}
			for(Staff s:ss){
				AttendanceStatBean asb = new AttendanceStatBean();
				List<Attendance> sas = new ArrayList<Attendance>();
				float th=0;
				for(Attendance a:ads){
					long begin = a.getSignOut().getTimeInMillis();
					long end = a.getSignIn().getTimeInMillis();
					th += (float)((begin-end)/(1000 * 60 * 60));
					if(a.getStaff().getId()==s.getId()){
						sas.add(a);
					}
				}
				BigDecimal   bth= new BigDecimal(th);  
				asb.setTotalHours(bth.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue()); 
				BigDecimal   vth= new BigDecimal(computeValidHours(s,sas));  
				asb.setValidHours(vth.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue()); 
				
				asb.setBeginTime(formBean.getSignIn());
				asb.setEndTime(formBean.getSignOut());
				asb.setStaff(s);
				
			}
			return null;
		}

		private float computeValidHours(Staff s,List<Attendance> sas){
			HashSet<Integer> ads = new HashSet<Integer>();  
			for(Attendance a:sas){
				ads.add(a.getSignIn().getTime().getDate());
			}
			float validHours=0;
			for(int day:ads){
				float dth=0;
				for(Attendance a:sas){
					if(a.getSignIn().getTime().getDate()==day){
						long begin = a.getSignOut().getTimeInMillis();
						long end = a.getSignIn().getTimeInMillis();
						dth += (float)((begin-end)/(1000 * 60 * 60));
					}
				}
				if(dth>11){
					dth=11;
				}
				else if(dth>8){
					dth=8;
				}
				validHours+=dth;
			}
			return validHours;
		}
}
