package com.sparrow.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.DepartmentHeadEntity;
import com.sparrow.entity.HeadInstituteEntity;

public interface HeadInstituteRepo extends JpaRepository<HeadInstituteEntity,Long> {

	@Query(value = "select * from spr_head_institute where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	Page<HeadInstituteEntity> getAllActivelist(@Param("instituteId") Long instituteId , Pageable pageable);
	
	@Query(value = "select * from spr_head_institute where is_active=1 and fk_institute_id= :#{#instituteId}  And fk_employee_id = :#{#fkEmployeeId} ",nativeQuery = true)
	Optional<HeadInstituteEntity> getInstituteHeadById(@Param("instituteId")Long instituteId,@Param("fkEmployeeId") Long fkEmployeeId);
	
	@Query(value = "select * from spr_head_institute where is_active=1 And fk_institute_id= :#{#instituteId} And fk_employee_id= :#{#fkEmployeeId}",nativeQuery = true)
	Optional<HeadInstituteEntity> getheadinstById(@Param("instituteId")Long instituteId,@Param("fkEmployeeId") Long fkEmployeeId);
}
