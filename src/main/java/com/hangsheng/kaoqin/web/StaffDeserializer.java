package com.hangsheng.kaoqin.web;
import com.hangsheng.kaoqin.domain.Staff;
import com.hangsheng.kaoqin.service.api.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = StaffDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Staff.class)
public class StaffDeserializer extends JsonObjectDeserializer<Staff> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StaffService staffService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param staffService
     * @param conversionService
     */
    @Autowired
    public StaffDeserializer(@Lazy StaffService staffService, ConversionService conversionService) {
        this.staffService = staffService;
        this.conversionService = conversionService;
    }
}
