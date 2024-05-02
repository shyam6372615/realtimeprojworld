package com.sparrow.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.SectionEntity;

public interface SectionRepo extends JpaRepository<SectionEntity, Long> {
//	@Query(value = "SELECT * FROM spr_section WHERE is_active=1 AND fk_department_id = :#{#departmentId} ", nativeQuery = true)
//	List<SectionEntity> findAllSectionByDepartmentId(@Param("departmentId") Long departmentId);
//	
//	@Query(value = "SELECT seats FROM spr_section WHERE is_active=1 AND fk_department_id = :#{#departmentId} AND section_id = :#{#sectionId}", nativeQuery = true)
//    Integer findNoStudentsBySection(@Param("sectionId") Long sectionId ,@Param("departmentId") Long  departmentId);
//	
//	@Query(value = "SELECT section_name From spr_section WHERE is_active=1 AND section_id = :#{#sectionId} ", nativeQuery = true)
//    String findSectionNameById(@Param("sectionId") Long sectionId);
	
	@Query(value = "select * from spr_section where is_active=1 and fk_institute_id=:#{#instituteId}",nativeQuery = true)
	List<SectionEntity> getAllActivelist(@Param("instituteId") Long instituteId);
	
	@Query(value = "select * from spr_section where is_active=1 and fk_institute_id= :#{#instituteId} And section_id= :#{#sectionId} ",nativeQuery = true)
	Optional<SectionEntity> getSectionById(@Param("instituteId") Long instituteId,@Param("sectionId") Long sectionId);
}
