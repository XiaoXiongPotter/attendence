// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.hangsheng.kaoqin.domain;

import com.hangsheng.kaoqin.domain.AttendanceStatBean;
import com.hangsheng.kaoqin.domain.Staff;
import java.util.Calendar;

privileged aspect AttendanceStatBean_Roo_JavaBean {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Calendar
     */
    public Calendar AttendanceStatBean.getBeginTime() {
        return this.beginTime;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param beginTime
     */
    public void AttendanceStatBean.setBeginTime(Calendar beginTime) {
        this.beginTime = beginTime;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Calendar
     */
    public Calendar AttendanceStatBean.getEndTime() {
        return this.endTime;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param endTime
     */
    public void AttendanceStatBean.setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Float
     */
    public float AttendanceStatBean.getTotalHours() {
        return this.totalHours;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param totalHours
     */
    public void AttendanceStatBean.setTotalHours(float totalHours) {
        this.totalHours = totalHours;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Float
     */
    public float AttendanceStatBean.getValidHours() {
        return this.validHours;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param validHours
     */
    public void AttendanceStatBean.setValidHours(float validHours) {
        this.validHours = validHours;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Staff
     */
    public Staff AttendanceStatBean.getStaff() {
        return this.staff;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param staff
     */
    public void AttendanceStatBean.setStaff(Staff staff) {
        this.staff = staff;
    }
    
}