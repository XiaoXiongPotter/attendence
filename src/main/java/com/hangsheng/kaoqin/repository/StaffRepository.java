package com.hangsheng.kaoqin.repository;
import com.hangsheng.kaoqin.domain.Staff;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;

/**
 * = StaffRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Staff.class, finders = { @RooFinder(value = "findByMacAllIgnoreCase", returnType = Staff.class) })
public interface StaffRepository {
}
