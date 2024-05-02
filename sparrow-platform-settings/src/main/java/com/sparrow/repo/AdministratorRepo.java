package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.AdministratorEntity;

public interface AdministratorRepo extends JpaRepository<AdministratorEntity,Long>{
	@Query(value = "select * from spr_institute_adminstrator where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<AdministratorEntity> getAllActivelist(@Param("instituteId") Long instituteId);
}
