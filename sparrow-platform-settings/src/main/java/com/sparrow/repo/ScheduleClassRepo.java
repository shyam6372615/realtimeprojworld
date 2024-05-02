package com.sparrow.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.ScheduleClassEntity;

public interface ScheduleClassRepo extends JpaRepository<ScheduleClassEntity, Long>{
	
	@Query(value = "select * from spr_schedule_class where is_active=1 And fk_institute_id= :#{#instituteId} and schedule_cls_id= :#{#scheduleClassId}",nativeQuery = true)
	Optional<ScheduleClassEntity> getScheduleClassById(@Param("instituteId") Long instituteId, @Param("scheduleClassId") Long scheduleClassId);
	
//	@Query(value = "select * from spr_sessions_class_timing where is_active=1 And session_id= :#{#sessionId} and fk_institute_id= :#{#instituteId}",nativeQuery = true)
//	ScheduleClassEntity getSessionClassTimingById1(@Param("sessionId") Long sessionId,@Param("instituteId") Long instituteId);
	
	@Query(value = "select * from spr_schedule_class where is_active=1 And fk_institute_id = :#{#instituteId}  ",nativeQuery = true)
	Page<ScheduleClassEntity> getAllActivelist(@Param("instituteId") Long instituteId , Pageable pageable);
	
	@Query(value = "select * from spr_schedule_class where is_active=1 And fk_institute_id= :#{#instituteId} and schedule_cls_id= :#{#scheduleClassId}",nativeQuery = true)
	Optional<ScheduleClassEntity> getScheduleClassById1(@Param("instituteId") Long instituteId,@Param("scheduleClassId") Long scheduleClassId);

}
