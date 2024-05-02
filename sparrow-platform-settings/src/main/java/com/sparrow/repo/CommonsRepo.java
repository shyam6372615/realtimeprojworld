package com.sparrow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.CommonsDataEntity;

public interface CommonsRepo extends JpaRepository<CommonsDataEntity, Long> {
  
	@Query(value = "select * from spr_commons where is_active=1 and fk_institute_id = :#{#instituteId} and keyword = :#{#keyword}  ",nativeQuery = true)
	List<CommonsDataEntity> getAllActivelist(@Param("instituteId") Long instituteId,@Param("keyword") String keyword);
    
	@Query(value = "select * from spr_commons where is_active=1 ",nativeQuery = true)
	List<CommonsDataEntity> getAllActivelist1();

}
