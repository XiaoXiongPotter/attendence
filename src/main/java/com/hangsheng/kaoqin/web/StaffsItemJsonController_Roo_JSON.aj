// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.hangsheng.kaoqin.web;

import com.hangsheng.kaoqin.domain.Staff;
import com.hangsheng.kaoqin.service.api.StaffService;
import com.hangsheng.kaoqin.web.StaffsItemJsonController;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

privileged aspect StaffsItemJsonController_Roo_JSON {
    
    declare @type: StaffsItemJsonController: @RestController;
    
    declare @type: StaffsItemJsonController: @RequestMapping(value = "/staffs/{staff}", name = "StaffsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE);
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param staffService
     */
    @Autowired
    public StaffsItemJsonController.new(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Staff
     */
    @ModelAttribute
    public Staff StaffsItemJsonController.getStaff(@PathVariable("staff") Long id) {
        Staff staff = staffService.findOne(id);
        if (staff == null) {
            throw new NotFoundException(String.format("Staff with identifier '%s' not found",id));
        }
        return staff;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param staff
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> StaffsItemJsonController.show(@ModelAttribute Staff staff) {
        return ResponseEntity.ok(staff);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param staff
     * @return UriComponents
     */
    public static UriComponents StaffsItemJsonController.showURI(Staff staff) {
        return MvcUriComponentsBuilder
            .fromMethodCall(
                MvcUriComponentsBuilder.on(StaffsItemJsonController.class).show(staff))
            .buildAndExpand(staff.getId()).encode();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param storedStaff
     * @param staff
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> StaffsItemJsonController.update(@ModelAttribute Staff storedStaff, @Valid @RequestBody Staff staff, BindingResult result) {
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        staff.setId(storedStaff.getId());
        getStaffService().save(staff);
        return ResponseEntity.ok().build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param staff
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> StaffsItemJsonController.delete(@ModelAttribute Staff staff) {
        getStaffService().delete(staff);
        return ResponseEntity.ok().build();
    }
    
}
