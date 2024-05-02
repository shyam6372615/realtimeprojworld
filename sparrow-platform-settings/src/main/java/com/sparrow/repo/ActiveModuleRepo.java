package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.ActiveModuleEntity;

public interface ActiveModuleRepo extends JpaRepository<ActiveModuleEntity,Long> {
	@Query(value = "select * from spr_active_module where is_active=1 and fk_institute_id = :#{#instituteId} and fk_package_id = :#{#packageId} and fk_mod_id = :#{#modId} ",nativeQuery = true)
	ActiveModuleEntity getAllActiveModuleById(@Param("instituteId") Long instituteId,@Param("packageId") Long packageId,@Param("modId") Long modId);
	
	@Query(value = "select * from spr_active_module where is_active=1 and fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<ActiveModuleEntity> getAllActiveList(@Param("instituteId") Long instituteId);
}
