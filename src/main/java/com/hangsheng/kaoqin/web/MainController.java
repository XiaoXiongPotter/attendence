package com.hangsheng.kaoqin.web;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleafMainController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hangsheng.kaoqin.domain.Attendance;
import com.hangsheng.kaoqin.domain.Staff;
import com.hangsheng.kaoqin.service.api.AttendanceService;
import com.hangsheng.kaoqin.service.api.StaffService;
import com.hangsheng.kaoqin.util.GetMacAddress;
import com.hangsheng.kaoqin.util.MacUtil;
import com.hangsheng.kaoqin.util.TimeUtil;

/**
 * = MainController
 TODO Auto-generated class documentation
 *
 */
@RooThymeleafMainController
public class MainController {
	  static Logger log = LoggerFactory.getLogger(MainController.class);
	  @Autowired
	  StaffService staffService;

	  @Autowired
	  HttpServletRequest request;
	 
	  @Autowired
	  AttendanceService attendanceService;

	/**
     * TODO Auto-generated method documentation
     * 
     * @param model
     * @return String
     */
    @GetMapping("/")
    public ModelAndView index(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
     /*
        String mac = MacUtil.getMac(this.request);
       // System.out.println("mac:" + mac);

        if (mac != null) {
          List<Staff> ss = staffService.findByMacAllIgnoreCase(mac, null).getContent();
          if(ss.size()>0){
        	  return "attendances/findBySignInAfterAndSignOutBeforeForm";
          }
        }
        */
        String ip = request.getRemoteAddr();
       
		String mac = GetMacAddress.getMacInWindows(ip);   
		log.info("ip"+ip+" "+mac+":"+Calendar.getInstance().getTimeInMillis());
		if(!ip.contains("192.168")){
			model.addAttribute("hint", "please use local network");
		}
		if (mac != null && mac.length()>0) {
			List<Staff> ss = staffService.findByMacAllIgnoreCase(mac, null).getContent();
			if (ss.size() > 0) {
				List<Attendance> as = attendanceService.findBySignOutIsNullAndIp(ip, null).getContent();
				if(as.size()>0){
					model.addAttribute("hint", "already sign in");
					return new ModelAndView("attendances/list");
				}
				else{
					if(TimeUtil.isInTime("7:30-10:30", new Date())||TimeUtil.isInTime("12:30-16:00", new Date())||TimeUtil.isInTime("18:30-21:30", new Date())){
						Attendance a = new Attendance();
						a.setIp(ip);
						a.setSignIn(Calendar.getInstance());
						a.setStaff(ss.get(0));
						attendanceService.save(a);
					//	model.addAttribute("hint", "sign in success");
					//	model.addAttribute("attendances",  attendanceService.findTodayAttendances());
						return new ModelAndView("attendances/list");
					}
					else{
						model.addAttribute("hint", "signin time passed!");
					}
				}
			}
			else{
				
				model.addAttribute("hint", "Sorry,you are not company staff!");
				/*
				  Staff s = new Staff();
				  s.setMac(mac);
				  model.addAttribute("staff",s);
				  
			      return new ModelAndView("staffs/create");
			      */
				
			}
		}

        return new ModelAndView("index");
    }
}
