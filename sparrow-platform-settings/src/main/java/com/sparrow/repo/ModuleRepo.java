package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparrow.entity.ModulesEntity;

public interface ModuleRepo extends JpaRepository<ModulesEntity,Long> {

	@Query(value = "select * from spr_modules where is_active=1 ",nativeQuery = true)
	List<ModulesEntity> getAllActivelist();
}
