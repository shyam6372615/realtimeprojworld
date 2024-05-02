package com.sparrow.repo;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.CourseLevelEntity;
import com.sparrow.entity.SectionEntity;
import com.sparrow.entity.SessionClassTimingEntity;

public interface SessionClassTimingRepo extends JpaRepository<SessionClassTimingEntity, Long> {

	@Query(value = "select * from spr_sessions_class_timing where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	Page<SessionClassTimingEntity> getAllActivelist(@Param("instituteId") Long instituteId, org.springframework.data.domain.Pageable pageable);
		
	@Query(value = "select * from spr_sessions_class_timing where is_active=1 And session_id= :#{#sessionId} and fk_institute_id= :#{#instituteId}",nativeQuery = true)
	Optional<SessionClassTimingEntity> getSessionClassTimingById(@Param("sessionId") Long sessionId,@Param("instituteId") Long instituteId);
	
	@Query(value = "select * from spr_sessions_class_timing where is_active=1 And session_id= :#{#sessionId} and fk_institute_id= :#{#instituteId}",nativeQuery = true)
	SessionClassTimingEntity getSessionClassTimingById1(@Param("sessionId") Long sessionId,@Param("instituteId") Long instituteId);

	@Query(value = "select * from spr_sessions_class_timing where is_active=1 And fk_institute_id = :#{#instituteId} And session_id= :#{#sessionId} ",nativeQuery = true)
	Optional<SessionClassTimingEntity> findByinstituteIdClassTimingId(@Param("instituteId") Long instituteId,@Param("sessionId") Long sessionId);
}
