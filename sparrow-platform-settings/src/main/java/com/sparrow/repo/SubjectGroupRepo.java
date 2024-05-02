package com.sparrow.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.SubjectGroupEntity;

public interface SubjectGroupRepo extends JpaRepository<SubjectGroupEntity, Long> {
	@Query(value = "select * from spr_subject_group where is_active=1 And fk_institute_id = :#{#instituteId} ",nativeQuery = true)
	List<SubjectGroupEntity> getAllActivelist(@Param("instituteId") Long instituteId);


	@Query(value = "select * from spr_subject_group where is_active=1 And fk_institute_id = :#{#instituteId} And sub_group_id= :#{#subGroupId} ",nativeQuery = true)
	Optional<SubjectGroupEntity> getSubjectGroupById(@Param("instituteId") Long instituteId,@Param("subGroupId") Long subGroupId);


	void save(Optional<SubjectGroupEntity> subjectGroupData);

//	@Query(value = "select * from spr_subject_group where is_active=1 And fk_institute_id = :#{#instituteId} And sub_group_id = :#{#subGroupId} ",nativeQuery = true)
//	Optional<SubjectGroupEntity> findByinstituteIdSubjectGroupId(@Param("instituteId") Long instituteId,@Param("subGroupId") Long subGroupId);



}
