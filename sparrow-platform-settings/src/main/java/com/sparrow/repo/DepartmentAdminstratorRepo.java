package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.DepartmentAdminStratorEntity;
import com.sparrow.entity.DepartmentEntity;

public interface DepartmentAdminstratorRepo extends JpaRepository<DepartmentAdminStratorEntity, Long> {
	
	@Query(value = "select * from spr_dept_adminstrator where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<DepartmentAdminStratorEntity> getAllActivelist(@Param("instituteId") Long instituteId);

}
