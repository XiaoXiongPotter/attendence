package com.hangsheng.kaoqin;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hangsheng.kaoqin.domain.Attendance;
import com.hangsheng.kaoqin.service.api.AttendanceService;
import com.hangsheng.kaoqin.util.MacUtil;
import com.hangsheng.kaoqin.web.MainController;

/**
 * = AttendanceApplication
 *
 * TODO Auto-generated class documentation
 *
 */
@SpringBootApplication
public class AttendanceApplication {
	static Logger log = LoggerFactory.getLogger(AttendanceApplication.class);
	private static long PERIOD_DAY = 24 * 60 * 60 * 1000;

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AttendanceApplication.class, args);
		processTimeOutAttendance(ctx,12,0);
		processTimeOutAttendance(ctx,17,30);
		processTimeOutAttendance(ctx,22,00);
	//	processOfflineAttendanceAttendance(ctx);
	}

	private static void processOfflineAttendanceAttendance(ApplicationContext ctx) {
		// TODO Auto-generated method stub
		AttendanceService as = ctx.getBean(AttendanceService.class);
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				for (Attendance a : as.findBySignOutIsNull(null).getContent()) {
					if (MacUtil.getMac(a.getIp()) == null) {
						log.info("sign out:" + a.getStaff().getName());
						a.setSignOut(Calendar.getInstance());
						as.save(a);
					}
					;
				}
			}
		}, (long) 5 * 1000, (long) 90 * 1000);
	}

	private static void processTimeOutAttendance(ApplicationContext ctx,int hour,int minute) {
		// TODO Auto-generated method stub
		AttendanceService as = ctx.getBean(AttendanceService.class);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, 0);

		long initDelay = c.getTime().getTime() - new Date().getTime();
		initDelay = (initDelay > 0) ? initDelay : (PERIOD_DAY + initDelay);

		Executors.newScheduledThreadPool(2).scheduleAtFixedRate(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				for (Attendance a : as.findBySignOutIsNull(null).getContent()) {
					log.info("sign out:" + a.getStaff().getName());
					a.setSignOut(Calendar.getInstance());
					as.save(a);
				}
			}
		}, initDelay, PERIOD_DAY, TimeUnit.MILLISECONDS);
	}
}