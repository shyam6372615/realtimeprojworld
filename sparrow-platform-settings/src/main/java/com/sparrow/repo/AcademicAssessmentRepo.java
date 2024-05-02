package com.sparrow.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AcademicAssessmentEntity;

public interface AcademicAssessmentRepo extends JpaRepository<AcademicAssessmentEntity,Long> {

	@Query(value = "select * from spr_academic_assessment where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	Page<AcademicAssessmentEntity> getAllActivelist(@Param("instituteId") Long instituteId , Pageable pageable);
	
	@Query(value = "select * from spr_academic_assessment where is_active=1 And fk_institute_id = :#{#instituteId} And assessment_id= :#{#assessmentId} ",nativeQuery = true)
	Optional<AcademicAssessmentEntity> getAssessmentById(@Param("instituteId") Long instituteId,@Param("assessmentId") Long assessmentId);

	@Query(value = "select * from spr_academic_assessment where is_active=1 And fk_institute_id = :#{#instituteId} And assessment_id= :#{#assessmentId} ",nativeQuery = true)
	Optional<AcademicAssessmentEntity> findByinstituteIdAssessmentId(@Param("instituteId") Long instituteId,@Param("assessmentId") Long assessmentId);

	
	 
	@Query(value = "select * from spr_academic_assessment where is_active=1 And fk_institute_id = :#{#instituteId} And assessment_id= :#{#assessmentId} ",nativeQuery = true)
	Optional<AcademicAssessmentEntity> getAssessmentById1(@Param("instituteId") Long instituteId,@Param("assessmentId") Long assessmentId);
	
}
