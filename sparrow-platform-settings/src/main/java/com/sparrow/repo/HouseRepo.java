package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.HouseEntity;

public interface HouseRepo extends JpaRepository<HouseEntity,Long> {

	@Query(value = "select * from spr_house where is_active=1 AND fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<HouseEntity> getAllActivelist(@Param("instituteId") Long instituteId);

}
