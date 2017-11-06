package com.hangsheng.kaoqin.web;

import com.hangsheng.kaoqin.domain.Attendance;
import com.hangsheng.kaoqin.domain.AttendanceSignInAndSignOutFormBean;
import com.hangsheng.kaoqin.domain.Staff;
import com.hangsheng.kaoqin.service.api.StaffService;
import com.hangsheng.kaoqin.util.GetMacAddress;
import com.hangsheng.kaoqin.util.MacUtil;
import com.hangsheng.kaoqin.util.TimeUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * = AttendancesCollectionThymeleafController TODO Auto-generated class
 * documentation
 *
 */
@RooController(entity = Attendance.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class AttendancesCollectionThymeleafController {
	static Logger log = LoggerFactory.getLogger(AttendancesCollectionThymeleafController.class);
	@Autowired
	HttpServletRequest request;

	@Autowired
	StaffService staffService;

	@GetMapping(value = { "/signIn" }, name = "signIn")
	public ModelAndView signIn(@ModelAttribute Attendance attendance, Model model) {
		String ip = request.getRemoteAddr();
		String mac = GetMacAddress.getMacInWindows(ip);   
		log.info(mac+":signIn:"+Calendar.getInstance().getTimeInMillis());
		// System.out.println("mac:" + mac);
		if(!ip.contains("192.168")){
			model.addAttribute("hint", "please enter local network");
		}
		if (mac != null && mac.length()>0) {
			List<Staff> ss = staffService.findByMacAllIgnoreCase(mac, null).getContent();
			if (ss.size() > 0) {
				List<Attendance> as = getAttendanceService().findBySignOutIsNullAndIp(ip, null).getContent();
				if(as.size()>0){
					model.addAttribute("hint", "already sign in");
				}
				else{
					if(TimeUtil.isInTime("7:30-10:30", new Date())||TimeUtil.isInTime("12:30-16:00", new Date())||TimeUtil.isInTime("18:30-21:30", new Date())){
						Attendance a = new Attendance();
						a.setIp(ip);
						a.setSignIn(Calendar.getInstance());
						a.setStaff(ss.get(0));
						getAttendanceService().save(a);
						
						model.addAttribute("attendances",  getAttendanceService().findTodayAttendances());
						new ModelAndView("attendances/list");
					}
					else{
						model.addAttribute("hint", "please have a rest");
					}
				}
			}
			else{
				model.addAttribute("hint", "Sorry,you are not company staff");
			}
		}
		return new ModelAndView("attendances/list");
	}

	@GetMapping(value = { "/signOut" }, name = "signOut")
	public ModelAndView signOut(@ModelAttribute Attendance attendance, Model model) {
		String ip = request.getRemoteAddr();
		String mac = GetMacAddress.getMacInWindows(ip); 
		log.info(mac+":signOut:"+Calendar.getInstance().getTimeInMillis());
		// System.out.println("mac:" + mac);
		if(!ip.contains("192.168")){
			model.addAttribute("hint", "please enter local network");
		}
		if (mac != null && mac.length()>0) {
			List<Staff> ss = staffService.findByMacAllIgnoreCase(mac, null).getContent();
			if (ss.size() > 0) {
				List<Attendance> as = getAttendanceService().findBySignOutIsNullAndStaff(ss.get(0), null).getContent();
				if(as.size()>0){
					Attendance a = as.get(0);
					a.setIp(ip);
					a.setSignOut(Calendar.getInstance());
					getAttendanceService().save(a);
					
					model.addAttribute("attendances",  getAttendanceService().findTodayAttendances());
					new ModelAndView("attendances/list");
					
				}
				else{
					model.addAttribute("hint", "already sign out");
					
				}
			}
			else{
				model.addAttribute("hint", "not company staff");
			}
		}
		return new ModelAndView("attendances/list");
	}


}
