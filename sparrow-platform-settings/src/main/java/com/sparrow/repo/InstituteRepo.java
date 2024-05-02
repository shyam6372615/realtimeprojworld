package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.InstituteEntity;

public interface InstituteRepo extends JpaRepository<InstituteEntity,Long>{
	@Query(value = "select * from spr_institute_basic where is_active=1 And fk_app_user = :#{#userId}",nativeQuery = true)
	List<InstituteEntity> getAllActivelist(@Param("userId") Long userId);


}
