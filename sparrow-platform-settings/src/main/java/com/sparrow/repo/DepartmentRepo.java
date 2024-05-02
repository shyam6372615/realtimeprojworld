package com.sparrow.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.DepartmentEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity,Long>{
	
//	@Query(value = "SELECT * FROM spr_department WHERE is_active=1 AND fk_program_id = :#{#programId} ", nativeQuery = true)
//	List<DepartmentEntity> findAllDepartmentByProgramId(@Param("programId") Long programId);
//	
//	@Query(value = "SELECT department_name From spr_department WHERE is_active=1 AND department_id = :#{#departmentId} ", nativeQuery = true)
//    String findDepartmentNameById(@Param("departmentId") Long departmentId);
	
	@Query(value = "select * from spr_department where is_active=1 And fk_institute_id = :#{#instituteId}",nativeQuery = true)
	List<DepartmentEntity> getAllActivelist(@Param("instituteId") Long instituteId);


	@Query(value = "select * from spr_department where is_active=1 and fk_institute_id= :#{#instituteId}  And department_id= :#{#departmentId} ",nativeQuery = true)
	Optional<DepartmentEntity> getDepartmentById(@Param("instituteId")Long instituteId,@Param("departmentId") Long departmentId);

}
