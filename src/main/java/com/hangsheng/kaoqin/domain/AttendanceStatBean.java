package com.hangsheng.kaoqin.domain;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 * = AttendanceStatBean
 TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
public class AttendanceStatBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
   // @DateTimeFormat(style = "M-")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar beginTime;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
   // @DateTimeFormat(style = "M-")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar endTime;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private float totalHours;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private float validHours;
    
    private Staff staff;
}
