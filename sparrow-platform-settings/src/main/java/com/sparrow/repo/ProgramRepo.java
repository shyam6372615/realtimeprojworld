package com.sparrow.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sparrow.entity.ProgramEntity;



public interface ProgramRepo extends JpaRepository<ProgramEntity, Long> {
	//@Query(value = "select * from spr_program where is_active=1",nativeQuery = true)
	//List<ProgramEntity> getAllActivelist();
	
	
//	@Query(value = "SELECT * FROM spr_program WHERE is_active=1 AND fk_level_id = :#{#levelId} ", nativeQuery = true)
//	List<ProgramEntity> findAllProgramByLevelId(@Param("levelId") Long LevelId);
//	
//	@Query(value = "SELECT programe_name From spr_program WHERE is_active=1 AND program_id = :#{#programId} ", nativeQuery = true)
//    String findProgramNameById(@Param("programId") Long programId);
    

	@Query(value = "select * from spr_program where is_active=1 and fk_institute_id=:#{#instituteId}",nativeQuery = true)
	List<ProgramEntity> getAllActivelist(@Param("instituteId") Long instituteId);
	
	@Query(value = "select * from spr_program where is_active=1 and fk_institute_id= :#{#instituteId} And program_id= :#{#programId}",nativeQuery = true)
	Optional<ProgramEntity> getProgramById(@Param("instituteId") Long instituteId,@Param("programId") Long programId );
}
