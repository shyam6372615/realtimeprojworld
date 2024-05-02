package com.sparrow.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.DepartmentHeadEntity;
import com.sparrow.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long>{
	
	@Query(value = "select * from spr_employee where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<EmployeeEntity> getAllActivelist(@Param("instituteId") Long instituteId);
	
	
}
