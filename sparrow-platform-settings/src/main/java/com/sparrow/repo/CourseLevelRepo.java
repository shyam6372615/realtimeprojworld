package com.sparrow.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.CourseLevelEntity;

public interface CourseLevelRepo extends JpaRepository<CourseLevelEntity, Long> {
	@Query(value = "select * from spr_course_level where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<CourseLevelEntity> getAllActivelist(@Param("instituteId") Long instituteId);
	
//	//String getCourselevelById()
//	@Query(value = "SELECT course_level_name From spr_course_level WHERE is_active=1 AND course_level_id = :#{#levelId} ", nativeQuery = true)
//    String findCourseLevelNameById(@Param("levelId") Long levelId);
	@Query(value = "select * from spr_course_level where is_active=1 And fk_institute_id= :#{#instituteId} and course_level_id= :#{#courseLevelId}",nativeQuery = true)
	Optional<CourseLevelEntity> getCourseLevelById(@Param("instituteId") Long instituteId,@Param("courseLevelId") Long courseLevelId);
}
