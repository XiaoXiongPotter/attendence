// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.hangsheng.kaoqin.web;

import com.hangsheng.kaoqin.service.api.AttendanceService;
import com.hangsheng.kaoqin.web.AttendancesSearchJsonController;

privileged aspect AttendancesSearchJsonController_Roo_Controller {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private AttendanceService AttendancesSearchJsonController.attendanceService;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return AttendanceService
     */
    public AttendanceService AttendancesSearchJsonController.getAttendanceService() {
        return attendanceService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param attendanceService
     */
    public void AttendancesSearchJsonController.setAttendanceService(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
    
}
