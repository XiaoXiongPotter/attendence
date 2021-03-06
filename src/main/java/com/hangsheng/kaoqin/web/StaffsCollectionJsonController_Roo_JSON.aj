// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.hangsheng.kaoqin.web;

import com.hangsheng.kaoqin.domain.Staff;
import com.hangsheng.kaoqin.service.api.StaffService;
import com.hangsheng.kaoqin.web.StaffsCollectionJsonController;
import com.hangsheng.kaoqin.web.StaffsItemJsonController;
import io.springlets.data.domain.GlobalSearch;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

privileged aspect StaffsCollectionJsonController_Roo_JSON {
    
    declare @type: StaffsCollectionJsonController: @RestController;
    
    declare @type: StaffsCollectionJsonController: @RequestMapping(value = "/staffs", name = "StaffsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE);
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param staffService
     */
    @Autowired
    public StaffsCollectionJsonController.new(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Staff>> StaffsCollectionJsonController.list(GlobalSearch globalSearch, Pageable pageable) {
        
        Page<Staff> staffs = getStaffService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(staffs);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return UriComponents
     */
    public static UriComponents StaffsCollectionJsonController.listURI() {
        return MvcUriComponentsBuilder
            .fromMethodCall(
                MvcUriComponentsBuilder.on(StaffsCollectionJsonController.class).list(null, null))
            .build().encode();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param staff
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> StaffsCollectionJsonController.create(@Valid @RequestBody Staff staff, BindingResult result) {
        
        if (staff.getId() != null || staff.getVersion() != null) {        
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        Staff newStaff = getStaffService().save(staff);
        UriComponents showURI = StaffsItemJsonController.showURI(newStaff);
        
        return ResponseEntity.created(showURI.toUri()).build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param staffs
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> StaffsCollectionJsonController.createBatch(@Valid @RequestBody Collection<Staff> staffs, BindingResult result) {
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        getStaffService().save(staffs);
        
        return ResponseEntity.created(listURI().toUri()).build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param staffs
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> StaffsCollectionJsonController.updateBatch(@Valid @RequestBody Collection<Staff> staffs, BindingResult result) {
        
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        
        getStaffService().save(staffs);
        
        return ResponseEntity.ok().build();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> StaffsCollectionJsonController.deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        
        getStaffService().delete(ids);
        
        return ResponseEntity.ok().build();
    }
    
}
