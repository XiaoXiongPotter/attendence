package com.hangsheng.kaoqin.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.hangsheng.kaoqin.domain.Attendance;

/**
 * = AttendanceRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = AttendanceRepositoryCustom.class)
public class AttendanceRepositoryImpl extends QueryDslRepositorySupportExt<Attendance> {

    /**
     * TODO Auto-generated constructor documentation
     */
    AttendanceRepositoryImpl() {
        super(Attendance.class);
    }
}