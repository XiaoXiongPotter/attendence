package com.hangsheng.kaoqin.service.api;
import com.hangsheng.kaoqin.domain.Attendance;
import com.hangsheng.kaoqin.domain.AttendanceSignInAndSignOutFormBean;
import com.hangsheng.kaoqin.domain.AttendanceStatBean;

import java.util.List;

import org.springframework.roo.addon.layers.service.annotations.RooService;

/**
 * = AttendanceService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Attendance.class)
public interface AttendanceService {
	public List<Attendance> findTodayAttendances();

	public List<AttendanceStatBean> statBySignInAfterAndSignOutBefore(AttendanceSignInAndSignOutFormBean formBean);
}
