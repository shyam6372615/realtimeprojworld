package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AcademicSubjectEntity;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.AdministratorEntity;

public interface AcademicYearRepo extends JpaRepository<AcademicYearEntity,Long>{

	@Query(value = "select * from spr_academic_year where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<AcademicYearEntity> getAllActivelist(@Param("instituteId") Long instituteId);

}
