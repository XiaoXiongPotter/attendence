package com.hangsheng.kaoqin.web;
import com.hangsheng.kaoqin.domain.Attendance;
import com.hangsheng.kaoqin.service.api.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = AttendanceDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Attendance.class)
public class AttendanceDeserializer extends JsonObjectDeserializer<Attendance> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private AttendanceService attendanceService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param attendanceService
     * @param conversionService
     */
    @Autowired
    public AttendanceDeserializer(@Lazy AttendanceService attendanceService, ConversionService conversionService) {
        this.attendanceService = attendanceService;
        this.conversionService = conversionService;
    }
}
