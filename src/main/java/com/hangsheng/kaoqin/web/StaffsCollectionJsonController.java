package com.hangsheng.kaoqin.web;
import com.hangsheng.kaoqin.domain.Staff;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = StaffsCollectionJsonController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Staff.class, type = ControllerType.COLLECTION)
@RooJSON
public class StaffsCollectionJsonController {
}
