package com.hangsheng.kaoqin.domain;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Calendar;

/**
 * = AttendanceSignInFormBean
 TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
public class AttendanceSignInFormBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar signIn;
}
