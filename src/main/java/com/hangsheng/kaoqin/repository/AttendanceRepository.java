package com.hangsheng.kaoqin.repository;
import com.hangsheng.kaoqin.domain.Attendance;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import com.hangsheng.kaoqin.domain.AttendanceSignInAndSignOutFormBean;
import com.hangsheng.kaoqin.domain.AttendanceSignInFormBean;

/**
 * = AttendanceRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Attendance.class, finders = { @RooFinder(value = "findBySignOutIsNullAndStaff", returnType = Attendance.class), @RooFinder(value = "findBySignOutIsNull", returnType = Attendance.class), @RooFinder(value = "findBySignOutIsNullAndIp", returnType = Attendance.class), @RooFinder(value = "findBySignInAfterAndSignOutBefore", returnType = Attendance.class, formBean = AttendanceSignInAndSignOutFormBean.class) })
public interface AttendanceRepository {
}
