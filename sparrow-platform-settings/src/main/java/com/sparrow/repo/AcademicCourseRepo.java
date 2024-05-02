package com.sparrow.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.SectionEntity;


public interface AcademicCourseRepo extends JpaRepository<AcademicCourseEntity, Long> {
	@Query(value = "select * from spr_academic_courses where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	Page<AcademicCourseEntity> getAllActivelist(@Param("instituteId") Long instituteId , Pageable pageable);
	
	
	@Query(value = "select * from spr_academic_courses where is_active=1 And fk_institute_id = :#{#instituteId} And academic_course_id= :#{#academicCourseId} ",nativeQuery = true)
	Optional<AcademicCourseEntity> getAcademicCourseById(@Param("instituteId") Long instituteId,@Param("academicCourseId") Long academicCourseId);
	
	@Query(value = "select * from spr_academic_courses where is_active=1 And fk_institute_id = :#{#instituteId} And academic_course_id= :#{#academicCouirseId} ",nativeQuery = true)
	Optional<AcademicCourseEntity> findByInstituteIdAndCourseId(@Param("instituteId")Long instituteId, @Param("academicCouirseId")Long academicCouirseId);

}
