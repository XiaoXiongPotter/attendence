// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.hangsheng.kaoqin.web;

import com.hangsheng.kaoqin.service.api.AttendanceService;
import com.hangsheng.kaoqin.web.AttendancesItemThymeleafController;

privileged aspect AttendancesItemThymeleafController_Roo_Controller {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private AttendanceService AttendancesItemThymeleafController.attendanceService;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return AttendanceService
     */
    public AttendanceService AttendancesItemThymeleafController.getAttendanceService() {
        return attendanceService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param attendanceService
     */
    public void AttendancesItemThymeleafController.setAttendanceService(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
    
}