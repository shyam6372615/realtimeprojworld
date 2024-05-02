package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.ProgramEntity;
import com.sparrow.entity.SubjectMasterEntity;

public interface SubjectMasterRepo extends JpaRepository<SubjectMasterEntity, Long> {
	@Query(value = "SELECT * FROM spr_subject_master WHERE is_active=1 AND fk_institute_id = :#{#instituteId} And fk_subject_grp_id = :#{#groupId} ", nativeQuery = true)
	List<SubjectMasterEntity> findSubjectMasterByGroupId(@Param("instituteId") Long instituteId,@Param ("groupId") Long groupId);

}
