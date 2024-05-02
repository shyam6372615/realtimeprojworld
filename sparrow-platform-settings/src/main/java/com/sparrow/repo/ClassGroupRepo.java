package com.sparrow.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.ClassGroupEntity;

public interface ClassGroupRepo extends JpaRepository<ClassGroupEntity,Long> {
	@Query(value = "select * from spr_class_groups where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	Page<ClassGroupEntity> getAllActivelist(@Param("instituteId") Long instituteId, org.springframework.data.domain.Pageable pageable);
	
	@Query(value = "select * from spr_class_groups where is_active=1 And fk_institute_id = :#{#instituteId} And class_id= :#{#classId} ",nativeQuery = true)
	ClassGroupEntity getClassGroupById(@Param("instituteId") Long instituteId,@Param("classId") Long classId);
	
	@Query(value = "select * from spr_class_groups where is_active=1 And fk_institute_id = :#{#instituteId} And class_id= :#{#classId} ",nativeQuery = true)
	Optional<ClassGroupEntity> findByinstituteIdClassGroupId(@Param("instituteId") Long instituteId,@Param("classId") Long classId);
}
