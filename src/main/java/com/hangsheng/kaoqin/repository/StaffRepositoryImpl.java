package com.hangsheng.kaoqin.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.hangsheng.kaoqin.domain.Staff;

/**
 * = StaffRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = StaffRepositoryCustom.class)
public class StaffRepositoryImpl extends QueryDslRepositorySupportExt<Staff> {

    /**
     * TODO Auto-generated constructor documentation
     */
    StaffRepositoryImpl() {
        super(Staff.class);
    }
}