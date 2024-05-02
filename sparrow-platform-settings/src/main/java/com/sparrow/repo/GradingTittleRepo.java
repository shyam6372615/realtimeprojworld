package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.GradingTittleEntity;

public interface GradingTittleRepo extends JpaRepository<GradingTittleEntity, Long> {
	@Query(value = "select * from spr_grading_tittle where is_active=1 AND fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<GradingTittleEntity> getAllActivelist(@Param("instituteId") Long instituteId);


}
