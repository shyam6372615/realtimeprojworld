package com.sparrow.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.ScheduleDayEntity;

public interface ScheduleDayRepo extends JpaRepository<ScheduleDayEntity, Long>{
	@Query(value = "select * from spr_schedule_day where is_active=1 And fk_institute_id= :#{#instituteId} and schedule_day_id= :#{#scheduleDayId}",nativeQuery = true)
	Optional<ScheduleDayEntity> getScheduleDayById(@Param("instituteId") Long instituteId,@Param("scheduleDayId") Long scheduleDayId);
	
	@Query(value = "select * from spr_schedule_day where is_active=1 And fk_institute_id= :#{#instituteId} and schedule_day_id= :#{#scheduleDayId}",nativeQuery = true)
	Optional<ScheduleDayEntity> getScheduleDayById1(@Param("instituteId") Long instituteId,@Param("scheduleDayId") Long scheduleDayId);
	
	@Query(value = "select * from spr_schedule_day where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	Page<ScheduleDayEntity> getAllActivelist(@Param("instituteId") Long instituteId , Pageable pageable);

}
