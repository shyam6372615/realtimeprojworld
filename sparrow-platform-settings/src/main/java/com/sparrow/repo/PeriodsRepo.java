package com.sparrow.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.PeriodsEntity;

public interface PeriodsRepo extends JpaRepository<PeriodsEntity, Long> {

	@Query(value = "select * from spr_periods where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	Page<PeriodsEntity> getAllActivelist(@Param("instituteId") Long instituteId,Pageable pageable);
	
	@Query(value = "select * from spr_periods where is_active=1 And fk_institute_id = :#{#instituteId} And period_id= :#{#periodsId} ",nativeQuery = true)
	PeriodsEntity getPeriodsById(@Param("instituteId") Long instituteId,@Param("periodsId") Long periodsId);

	@Query(value = "select * from spr_periods where is_active=1 And fk_institute_id = :#{#instituteId} And period_id= :#{#periodsId} ",nativeQuery = true)
	Optional<PeriodsEntity> findByinstitueIdPeriodId(@Param("instituteId")Long instituteId,@Param("periodsId")Long sessionId);
}
