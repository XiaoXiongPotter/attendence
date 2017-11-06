package com.hangsheng.kaoqin.web;
import com.hangsheng.kaoqin.domain.Attendance;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = AttendancesCollectionJsonController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Attendance.class, type = ControllerType.COLLECTION)
@RooJSON
public class AttendancesCollectionJsonController {
}
