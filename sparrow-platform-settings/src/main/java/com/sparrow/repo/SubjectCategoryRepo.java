package com.sparrow.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.SessionClassTimingEntity;
import com.sparrow.entity.SubjectCategoryEntity;

public interface SubjectCategoryRepo extends JpaRepository<SubjectCategoryEntity, Long> {
	@Query(value = "select * from spr_subject_category where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	List<SubjectCategoryEntity> getAllActivelist(@Param("instituteId") Long instituteId);
    
	@Query(value = "select * from spr_subject_category where is_active=1 And fk_institute_id = :#{#instituteId} And subject_category_id= :#{#subjectcategoryId} ",nativeQuery = true)
	Optional<SubjectCategoryEntity> getSubjectCategoryById(@Param("instituteId") Long instituteId,@Param("subjectcategoryId") Long subjectcategoryId);
}
