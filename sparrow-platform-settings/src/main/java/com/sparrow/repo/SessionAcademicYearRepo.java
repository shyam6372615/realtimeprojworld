package com.sparrow.repo;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.SessionAcademicYear;

public interface SessionAcademicYearRepo extends JpaRepository<SessionAcademicYear, Long> {
	@Query(value = "select * from spr_session_academic_year where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	 Page<SessionAcademicYear> getAllActivelist(@Param("instituteId") Long instituteId,Pageable pageable);
	
	@Query(value = "SELECT * From spr_session_academic_year WHERE is_active=1 And fk_institute_id = :#{#instituteId} AND academic_setup_id = :#{#id} ", nativeQuery = true)
	SessionAcademicYear findSessionAcademicYearById(@Param("instituteId") Long instituteId,@Param("id") Long id);

	@Query(value = "SELECT * From spr_session_academic_year WHERE is_active=1 And fk_institute_id = :#{#instituteId} AND academic_setup_id = :#{#id} ", nativeQuery = true)
	Optional<SessionAcademicYear> findByInstituteIdAndId(@Param("instituteId")Long instituteId,@Param("id") Long id);
}
