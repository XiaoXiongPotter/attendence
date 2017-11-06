// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.hangsheng.kaoqin.repository;

import com.hangsheng.kaoqin.domain.Attendance;
import com.hangsheng.kaoqin.domain.AttendanceSignInAndSignOutFormBean;
import com.hangsheng.kaoqin.repository.AttendanceRepositoryCustom;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

privileged aspect AttendanceRepositoryCustom_Roo_Jpa_Repository_Custom {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Attendance> AttendanceRepositoryCustom.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Attendance> AttendanceRepositoryCustom.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Attendance> AttendanceRepositoryCustom.findBySignInAfterAndSignOutBefore(AttendanceSignInAndSignOutFormBean formBean, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param formBean
     * @return Long
     */
    public abstract long AttendanceRepositoryCustom.countBySignInAfterAndSignOutBefore(AttendanceSignInAndSignOutFormBean formBean);
    
}