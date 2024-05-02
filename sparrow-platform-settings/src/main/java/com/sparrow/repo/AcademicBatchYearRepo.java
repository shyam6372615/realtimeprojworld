package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AcademicBatchYearEntity;

public interface AcademicBatchYearRepo extends JpaRepository<AcademicBatchYearEntity, Long> {
	@Query(value = "select * from spr_batch_year where is_active=1 AND fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<AcademicBatchYearEntity> getAllActivelist(@Param("instituteId") Long instituteId);


}
