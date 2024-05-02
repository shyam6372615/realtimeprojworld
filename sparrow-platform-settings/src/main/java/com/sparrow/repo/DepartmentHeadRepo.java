package com.sparrow.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.CourseLevelEntity;
import com.sparrow.entity.DepartmentHeadEntity;

public interface DepartmentHeadRepo extends JpaRepository<DepartmentHeadEntity,Long> {

	@Query(value = "select * from spr_dept_head where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	Page<DepartmentHeadEntity> getAllActivelist(@Param("instituteId") Long instituteId , Pageable pageable);
	
	@Query(value = "select * from spr_dept_head where is_active=1 ",nativeQuery = true)
	List<DepartmentHeadEntity> getAllActivelist2();
	
	@Query(value = "select * from spr_dept_head where is_active=1 And fk_institute_id= :#{#instituteId} and fk_employee_id= :#{#fkEmployeeId}",nativeQuery = true)
	Optional<DepartmentHeadEntity> getdeptHeadById(@Param("instituteId") Long instituteId,@Param("fkEmployeeId") Long fkEmployeeId);
	
	@Query(value = "select * from spr_dept_head where is_active=1 And fk_institute_id= :#{#instituteId} and fk_employee_id= :#{#fkEmployeeId}",nativeQuery = true)
	Optional<DepartmentHeadEntity> getheadempById(@Param("instituteId") Long instituteId,@Param("fkEmployeeId") Long fkEmployeeId);

}


