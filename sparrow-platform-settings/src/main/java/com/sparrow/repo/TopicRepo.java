package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.TopicEntity;

public interface TopicRepo extends JpaRepository<TopicEntity,Long> {
	@Query(value = "select * from spr_topic where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<TopicEntity> getAllActivelist(@Param("instituteId") Long instituteId);
}
