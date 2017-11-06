package com.hangsheng.kaoqin.domain;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * = AttendanceSignInAndSignOutFormBean
 TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
public class AttendanceSignInAndSignOutFormBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
 //   @DateTimeFormat(style = "M-")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar signIn;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
  //  @DateTimeFormat(style = "M-")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar signOut;

	public AttendanceSignInAndSignOutFormBean(Calendar signIn, Calendar signOut) {
		super();
		this.signIn = signIn;
		this.signOut = signOut;
	}

	public AttendanceSignInAndSignOutFormBean() {
		super();
	}
    
   
}
