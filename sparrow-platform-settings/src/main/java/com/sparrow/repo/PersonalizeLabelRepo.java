package com.sparrow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.PersonalizeLabelEntity;

public interface PersonalizeLabelRepo extends JpaRepository<PersonalizeLabelEntity,Long> {

	@Query(value = "SELECT * From spr_perso_labels WHERE is_active=1 And fk_institute_id = :#{#instituteId} AND personalize_label_id = :#{#id} ", nativeQuery = true)
	PersonalizeLabelEntity deactivatePesonalizeLabel(@Param("instituteId") Long instituteId,@Param("id") Long id);

}
