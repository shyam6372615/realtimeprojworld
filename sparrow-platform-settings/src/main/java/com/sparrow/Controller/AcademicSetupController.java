package com.sparrow.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.dto.AcademicSubjectDTO;
import com.sparrow.dto.PeriodsDTO;
import com.sparrow.dto.Response;
import com.sparrow.dto.ResponseData;
import com.sparrow.dto.ScheduleDayDTO;
import com.sparrow.dto.SessionDTOSave;
import com.sparrow.entity.AcademicAssessmentEntity;
import com.sparrow.entity.AcademicBatchYearEntity;
import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.AcademicSubjectEntity;
import com.sparrow.entity.AcademicYearEntity;
import com.sparrow.entity.ClassGroupEntity;
import com.sparrow.entity.CommonsDataEntity;
import com.sparrow.entity.CourseLevelEntity;
import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.GradingTittleEntity;
import com.sparrow.entity.HouseEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.ModulesEntity;
import com.sparrow.entity.PeriodsEntity;
import com.sparrow.entity.ProgramEntity;
import com.sparrow.entity.ScheduleClassEntity;
import com.sparrow.entity.ScheduleDayEntity;
import com.sparrow.entity.SectionEntity;
import com.sparrow.entity.SessionAcademicYear;
import com.sparrow.entity.SubjectCategoryEntity;
import com.sparrow.entity.SubjectDetailsEntity;
import com.sparrow.entity.SubjectGroupEntity;
import com.sparrow.entity.SubjectMasterEntity;
import com.sparrow.entity.TopicEntity;
import com.sparrow.service.AcademicSetupService;
import com.sparrow.service.ValidationService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/sparrow/api/v1/platformsettings")
@RestController
@CrossOrigin
@Slf4j
public class AcademicSetupController {
	@Autowired
	private AcademicSetupService academicSetupService;

	@Autowired
	private ValidationService validationService;

	@PostMapping("/addSessionAcademicYears")
	public ResponseEntity<ResponseData<SessionAcademicYear>> addSessionAcademicYear(
			@Valid @RequestBody SessionAcademicYear sessionAcademicYear) {
		try {

			Response<?> response = academicSetupService.addSessionAcademicYear(sessionAcademicYear);
			return ResponseEntity
					.ok(new ResponseData<>(0, "SessionAcademicYear added successfully", sessionAcademicYear));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(-1, "Failed to add SessionAcademicYear", null));
		}
	}

	@GetMapping("/getAllSessionAcademicYear/{instituteId}")
	public ResponseEntity<ResponseData<Page<SessionAcademicYear>>> getAllSessionAcademicYear(
			@PathVariable("instituteId") Long instituteId, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "100") int size) {

		Page<SessionAcademicYear> sessionAcademicYears = academicSetupService.getAllSessionAcademicYear(instituteId,
				page, size);

		if (!sessionAcademicYears.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", sessionAcademicYears));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Session Academic Year not found with provioded Id", null));
		}
	}

	@PutMapping("/updateSessionAcademicYear")
	public ResponseEntity<?> updateSessionAcademicYear(@RequestBody SessionAcademicYear sessionAcademicYear) {
		SessionAcademicYear updateYear = academicSetupService.updateSessionAcademicYear(sessionAcademicYear);
		if (updateYear != null) {
			return ResponseEntity.ok(new ResponseData<>(0, "Session Academic Year update successfully", updateYear));
		} else {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to update Session Academic Year", null));
		}
	}

	

	

	

	

	

	
	@DeleteMapping("/deactivate/academicCourse/{instituteId}/{id}")
	public ResponseEntity<?> deactivateAcademicCourse(@PathVariable Long instituteId, @PathVariable Long id) {
		Response<?> response = academicSetupService.deactivateAcademicCourse(instituteId, id);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/deactivate/SessionacademicYear/{instituteId}/{id}")
	public ResponseEntity<?> deactivateSessionAcademicYear(@PathVariable Long instituteId, @PathVariable Long id) {
		Response<?> response = academicSetupService.deactivateSessionAcademicYear(instituteId, id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//@PostMapping("/addAcademicCourse")
//public ResponseEntity<ResponseData<AcademicCourseEntity>> addAcademicCourse(@Valid @RequestBody AcademicCourseEntity academicCourseEntity){
//	
//	try {
//		AcademicCourseEntity response = academicSetupService.addAcademicCourse(academicCourseEntity);
//		return ResponseEntity.ok(new ResponseData<>(0, "Academic Course added successfully", response));
//	}catch(Exception e){
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ResponseData<>(-1, "Failed to add Academic Course",null));
//		
//	}
//}

@PostMapping("/addCourseLevel")
public ResponseEntity<ResponseData<CourseLevelEntity>> addCourseLevel( @RequestBody CourseLevelEntity courseLevelEntity){
	
	try {
		CourseLevelEntity response = academicSetupService.addCourseLevel(courseLevelEntity);
		return ResponseEntity.ok(new ResponseData<>(0, "CourseLevel added successfully", response));
	}catch(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseData<>(1, "Course Level name or Course Short form Already Exist",null));
		
	}
}
@PostMapping("/addProgram")
public ResponseEntity<ResponseData<ProgramEntity>> addProgram( @RequestBody ProgramEntity programEntity){
	
	try {
		ProgramEntity response = academicSetupService.addProgram(programEntity);
		return ResponseEntity.ok(new ResponseData<>(0, "Program added successfully", response));
	}catch(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseData<>(1, "program or program short form already exist",null));
		
	}
}
@PostMapping("/addSection")
public ResponseEntity<ResponseData<SectionEntity>> addSection( @RequestBody SectionEntity sectionEntity){
	
	try {
		SectionEntity response = academicSetupService.addSection(sectionEntity);
		return ResponseEntity.ok(new ResponseData<>(0, "Section added successfully", response));
	}catch(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseData<>(1, "Failed to add Section",null));
		
	}
}
@PostMapping("/addDepartment")
public ResponseEntity<ResponseData<DepartmentEntity>> addDepartment( @RequestBody DepartmentEntity departmentEntity){
	
	try {
		DepartmentEntity response = academicSetupService.addDepartment(departmentEntity);
		return ResponseEntity.ok(new ResponseData<>(0, "Department added successfully", response));
	}catch(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseData<>(1, "Department or Department short form may exist ",null));
		
	}
}
@GetMapping("/getAllAcademicCourse/{instituteId}")
public ResponseEntity<?> getAllAcademicCourse(@PathVariable("instituteId") Long instituteId ,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size){
	Page<AcademicCourseEntity> list= academicSetupService.getAllAcademicCourse(instituteId,page,size);
	if(!list.isEmpty()) {
        return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
    }else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseData<>(1, "Session Academic Course not found with provioded Id", null));
    }
}
@GetMapping("/getAcademicCourseById/{instituteId}/{academicCourseId}")
public ResponseEntity<?> getAcademicCourseById(@PathVariable("instituteId") long instituteId,@PathVariable("academicCourseId") long academicCourseId) {
	Optional<AcademicCourseEntity> academicCourseData = academicSetupService.getAcademicCourseById(instituteId, academicCourseId);
	if (academicCourseData!=null) {
		return new ResponseEntity<>(academicCourseData, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

//@GetMapping("/get/section/by/{instituteId}")
//public ResponseEntity<?> getAllSection(@PathVariable("instituteId") Long instituteId){
//	List<SectionEntity> list= academicSetupService.getAllSection(instituteId);
//	if(!list.isEmpty()) {
//        return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
//    }else {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(new ResponseData<>(1, "Section not found with provioded deoartmentId", null));
//    }
//}
//@GetMapping("/getAllDepartment/{instituteId}")
//public ResponseEntity<?> getAllDepartment(@PathVariable("instituteId") Long instituteId) {
//    
//    List<DepartmentEntity> departmentEntity = academicSetupService.getAllDepartment(instituteId);
//    
//	if(!departmentEntity.isEmpty()) {
//    return ResponseEntity.ok(new ResponseData<>(0, "Success", departmentEntity));
//}else {
//    return ResponseEntity.status(HttpStatus.NOT_FOUND)
//            .body(new ResponseData<>(1, "Section not found with provioded Id", null));
//}
//}
//@GetMapping("/getAllSection/{instituteId}")
//public ResponseEntity<?> getAllSection(  @PathVariable("instituteId") Long instituteId) {
//    
//    List<SectionEntity> sectionEntity = academicSetupService.getAllSection(instituteId);
//    
//	if(!sectionEntity.isEmpty()) {
//    return ResponseEntity.ok(new ResponseData<>(0, "Success", sectionEntity));
//}else {
//    return ResponseEntity.status(HttpStatus.NOT_FOUND)
//            .body(new ResponseData<>(1, "Section not found with provioded Id", null));
//}
//}
//@GetMapping("get/program/by/{levelId}")
//public ResponseEntity<?> getSbuByStateId(@PathVariable("levelId") Long LevelId) {
//	List<ProgramEntity> response = academicSetupService.getAllProgramByLevelId(LevelId);
//	if(!response.isEmpty()) {
//        return ResponseEntity.ok(new ResponseData<>(0, "Success", response));
//    }else {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(new ResponseData<>(1, "program not found with provioded Id", null));
//    }
//}
//@GetMapping("/getAllProgram/{instituteId}")
//public ResponseEntity<?> getAllProgram(  @PathVariable("instituteId") Long instituteId){
//        
//    List<ProgramEntity> programEntity = academicSetupService.getAllProgram(instituteId);
//    
//	if(!programEntity.isEmpty()) {
//    return ResponseEntity.ok(new ResponseData<>(0, "Success", programEntity));
//}else {
//    return ResponseEntity.status(HttpStatus.NOT_FOUND)
//            .body(new ResponseData<>(1, "Program Year not found with provioded Id", null));
//}
//}
//@GetMapping("/getAllCourseLevel/{instituteId}")
//public ResponseEntity<?> getAllCourseLevel(@PathVariable("instituteId") Long instituteId){
//	List<CourseLevelEntity> list= academicSetupService.getAllCourseLevel(instituteId);
//	if(!list.isEmpty()) {
//        return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
//    }else {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(new ResponseData<>(1, "Courselevel not found with provioded Id", null));
//    }
//}

//@GetMapping("/get/department/by/{programId}")
//public ResponseEntity<?> getAllDepartment(@PathVariable("programId") Long programId){
//	List<DepartmentEntity> list= academicSetupService.getAllDepartmentByProgramId(programId);
//	if(!list.isEmpty()) {
//        return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
//    }else {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(new ResponseData<>(1, "department not found with provioded programId", null));
//    }
//}
//@PutMapping("/updateAcademicCourse")
//public ResponseEntity<?> updateAcademicCourse(@RequestBody AcademicCourseEntity academicCourseEntity) {
//	try {
//	AcademicCourseEntity academicCourseData = academicSetupService.updateAcademicCourse(academicCourseEntity);
//	 return ResponseEntity.ok(new ResponseData<>(0, "Session Academic Year updated successfully", academicCourseData));
//} catch(NoSuchElementException e) {
//    return ResponseEntity.status(HttpStatus.NOT_FOUND)
//            .body(new ResponseData<>(1, "Session Academic Year not found with id "+academicCourseEntity.getAcademicCouirseId(), null));
//}
//}

//@PostMapping("/addSession")
//public ResponseEntity<?> addSessioin(@Valid @RequestBody SessionClassTimingDTO sessionClassTimingDto){
//	try {
//	ArrayList<PeriodsEntity> periodsList=new ArrayList<PeriodsEntity>();
//	
//	
//	InstituteEntity instituteEntity = new InstituteEntity();
//	instituteEntity.setInstituteId(sessionClassTimingDto.getInstituteId());
//	SessionClassTimingEntity sessionEntity=new SessionClassTimingEntity();
//	
//	
//	ClassGroupEntity classgroupEntity = new ClassGroupEntity();
//	classgroupEntity.setClassId(sessionClassTimingDto.getFkClassGroups());
//	
//	sessionEntity.setEndTime(sessionClassTimingDto.getEndTime());
//	sessionEntity.setFkClassGroups(classgroupEntity);
//	sessionEntity.setIsFri(sessionClassTimingDto.getIsFri());
//	sessionEntity.setIsMon(sessionClassTimingDto.getIsMon());
//	sessionEntity.setIsSat(sessionClassTimingDto.getIsSat());
//	sessionEntity.setIsSun(sessionClassTimingDto.getIsSun());
//	sessionEntity.setIsthu(sessionClassTimingDto.getIsthu());
//	sessionEntity.setIsTue(sessionClassTimingDto.getIsTue());
//	sessionEntity.setIsWed(sessionClassTimingDto.getIsWed());
//	sessionEntity.setDefaultDuration(sessionClassTimingDto.getDefaultDuration());
//	sessionEntity.setInstituteId(instituteEntity);
//	sessionEntity.setStartTime(sessionClassTimingDto.getStartTime());
//	SessionClassTimingEntity sessionClassTimingEntity=academicSetupService.addSessionClassTiming(sessionEntity);
//	
//	for(PeriodsDTO periods:sessionClassTimingDto.getPeriodsDto()) {
//		PeriodsEntity periodsENtity=new PeriodsEntity();
//		periodsENtity.setEndTime(periods.getEndTime());
//		periodsENtity.setFkSessionClassId(sessionClassTimingEntity);
//		periodsENtity.setInstituteId(instituteEntity);
//		periodsENtity.setPeriodId(periods.getPeriodId());
//		periodsENtity.setSlotName(periods.getSlotName());
//		periodsENtity.setStartTime(periods.getStartTime());
//		periodsList.add(periodsENtity);
//	}
//	academicSetupService.addPeriods(periodsList);
//	
//	return ResponseEntity.ok(new ResponseData<>(0, "Session added successfully", sessionClassTimingEntity));
//	}catch(Exception e){
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ResponseData<>(-1, "Failed to add Session", null));
//		
//	}
//	
//}

	@GetMapping("/getAllPeriods/{instituteId}")
	public ResponseEntity<?> getAllPeriods(@PathVariable("instituteId") Long instituteId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Page<PeriodsEntity> list = academicSetupService.getAllPeriods(instituteId, page, size);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Period not found with provioded Id", null));
		}
	}

	@GetMapping("/getPeriodsById/{instituteId}/{PeriodsId}")
	public ResponseEntity<?> getPeriodsById(@PathVariable("instituteId") Long instituteId,
			@PathVariable("PeriodsId") long PeriodsId) {
		PeriodsEntity periodsData = academicSetupService.getPeriodsById(instituteId, instituteId);
		if (periodsData != null) {
			return new ResponseEntity<>(periodsData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("deactivate/periods/{id}")
	public ResponseEntity<?> deactivatePeriods(@PathVariable Long id) {
		Response<?> response = academicSetupService.deactivatePeriods(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getAllAcademicBatchYear/{instituteId}") // to be discuss
	public ResponseEntity<?> getAllAcademicBatchYear(@PathVariable("instituteId") Long instituteId) {
		List<AcademicBatchYearEntity> list = academicSetupService.getAllAcademicBatchYear(instituteId);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Session Academic Year not found with provioded Id", null));
		}
	}

	@PostMapping("/addAcademicSubject")
	public ResponseEntity<ResponseData<AcademicSubjectEntity>> addAcademicSubject(
			@Valid @RequestBody AcademicSubjectEntity academicSubjectEntity) {

		try {
			AcademicSubjectEntity response = academicSetupService.addAcademicSubject(academicSubjectEntity);
			return ResponseEntity.ok(new ResponseData<>(0, "Subject added successfully", response));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(-1, "Subject or Subject Code already exist", null));

		}

	}

	@GetMapping("/getAllAcademicSubject/{instituteId}")
	public ResponseEntity<?> getAllAcademicSubject(@PathVariable("instituteId") Long instituteId) {
		List<AcademicSubjectDTO> list = academicSetupService.getAllAcademicSubjects(instituteId);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Session Academic Year not found with provioded Id", null));
		}
	}

	@GetMapping("/getAcademicSubjectById/{instituteId}/{id}")
	public ResponseEntity<?> getAcademicSubjectById(@PathVariable("instituteId") Long instituteId,
			@PathVariable("id") long academicSubjectId) {
		AcademicSubjectEntity academicSubjectData = academicSetupService.getAcademicSubjectById(instituteId,
				academicSubjectId);
		if (academicSubjectData != null) {
			return new ResponseEntity<>(academicSubjectData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateAcademicSubject")
	public ResponseEntity<?> updateAcademicSubject(@RequestBody AcademicSubjectEntity academicSubjectEntity) {
		AcademicSubjectEntity academicSubjectData = academicSetupService.updateAcademicSubject(academicSubjectEntity);
		if (academicSubjectData != null) {
			return new ResponseEntity<>(academicSubjectData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deactivate/AcademicSubject/{instituteId}/{id}")
	public ResponseEntity<?> deactivateAcademicSubject(@PathVariable Long instituteId, @PathVariable Long id) {
		Response<?> response = academicSetupService.deactivateAcademicSubject(instituteId, id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/*
	 * @PostMapping("/addSubjectGroup") public ResponseEntity<?>
	 * addSubjectGroup(@RequestBody SubjectGroupEntity subjectGroupEntity){
	 * Response<?> validationResponse =
	 * validationService.validateForSubjectGroupAdd(subjectGroupEntity); if
	 * (validationResponse.getResponseCode() == HttpStatus.OK.value()) { Response<?>
	 * response = academicSetupService.addSubjectGroup(subjectGroupEntity); return
	 * new ResponseEntity<>(response,
	 * HttpStatus.valueOf(response.getResponseCode())); } else { return new
	 * ResponseEntity<>(validationResponse,
	 * HttpStatus.valueOf(validationResponse.getResponseCode())); } }
	 */
//@PostMapping("/addSubjectGroup")
//public ResponseEntity<ResponseData<SubjectGroupEntity>> addAcademicSubject(@Valid @RequestBody SubjectGroupEntity subjectGroupEntity){
//	
//	try {
//		SubjectGroupEntity subjectGroupData = academicSetupService.addSubjectGroup(subjectGroupEntity);
//		return ResponseEntity.ok(new ResponseData<>(0, "SubjectGroup added successfully", subjectGroupData));
//	}catch(Exception e){
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseData<>(1, "Failed to add SubjectGroup",null));
//	}
//}
	@GetMapping("/getAllSubjectGroup/{instituteId}")
	public ResponseEntity<?> getAllSubjectGroup(@PathVariable("instituteId") Long instituteId) {
		List<SubjectGroupEntity> list = academicSetupService.getAllSubjectGroup(instituteId);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Subject group not found with provioded Id", null));
		}
	}


	@PostMapping("/addSubjectCategory")
	public ResponseEntity<ResponseData<SubjectCategoryEntity>> addSubjectCategory(
			@Valid @RequestBody SubjectCategoryEntity subjectCategoryEntity) {

		try {
			SubjectCategoryEntity response = academicSetupService.addSubjectCategory(subjectCategoryEntity);
			return ResponseEntity.ok(new ResponseData<>(0, "Subject Category added successfully", response));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(-1, "Failed to add Subject Category", null));

		}
	}

	@GetMapping("/getAllSubjectCategory/{instituteId}")
	public ResponseEntity<?> getAllSubjectCategory(@PathVariable("instituteId") Long instituteId) {
		List<SubjectCategoryEntity> list = academicSetupService.getAllSubjectCategory(instituteId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/*
	 * @PostMapping("/addSubjectMaster") public ResponseEntity<?>
	 * addSubjectMaster(@RequestBody SubjectMasterDTO SubjectMasterDTO){
	 * 
	 * ArrayList<SubjectMasterEntity> subjectMasterList=new
	 * ArrayList<SubjectMasterEntity>();
	 * 
	 * SubjectMasterEntity subjectMasterEntity=new SubjectMasterEntity();
	 * InstituteEntity instituteEntity = new InstituteEntity();
	 * instituteEntity.setInstituteId(SubjectMasterDTO.getInstituteId());
	 * subjectMasterEntity.setFkinstituteId(instituteEntity);
	 * 
	 * SubjectGroupEntity subjectGroupEntity=new SubjectGroupEntity();
	 * subjectGroupEntity.setSubGroupId(SubjectMasterDTO.getFkSubjectGroupId());
	 * subjectMasterEntity.setFkSubjectGroupId(subjectGroupEntity);
	 * 
	 * 
	 * 
	 * for(SubjectDetailsDTO
	 * subjectDetailsDTO:SubjectMasterDTO.getSubjectDetailsDTO()) {
	 * AcademicSubjectEntity academicSubjectEntity=new AcademicSubjectEntity();
	 * academicSubjectEntity.setAcdmSubId(subjectDetailsDTO.getFkAcademicSubId());
	 * 
	 * subjectMasterEntity.setFkAcademicSubId(academicSubjectEntity);
	 * SubjectCategoryEntity subjectCategoryEntity=new SubjectCategoryEntity();
	 * 
	 * subjectCategoryEntity.setSubCategoryId(subjectDetailsDTO.getFkSubCategoryId()
	 * ); subjectMasterEntity.setFkSubCategoryId(subjectCategoryEntity);
	 * 
	 * subjectMasterList.add(subjectMasterEntity);
	 * academicSetupService.addSubjectMaster(subjectMasterEntity);
	 * subjectCategoryEntity=null; } return new
	 * ResponseEntity<>("SubjectMaster Data Added sucessfully", HttpStatus.CREATED);
	 * }
	 */
	@PostMapping("/addSubjectMaster")
	public ResponseEntity<?> addSubjectMaster(@RequestBody SubjectMasterEntity subjectMasterEntity) {
		Response<?> validationResponse = validationService.validateForSubjectMasterAdd(subjectMasterEntity);
		if (validationResponse.getResponseCode() == HttpStatus.OK.value()) {
			Response<?> response = academicSetupService.addSubjectMaster(subjectMasterEntity);
			return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
		} else {
			return new ResponseEntity<>(validationResponse, HttpStatus.valueOf(validationResponse.getResponseCode()));
		}
	}

	@GetMapping("/getSubjectMasterbroupId/{instituteId}/{id}")
	public ResponseEntity<?> getSubjectMasterbroupId(@PathVariable("instituteId") Long instituteId,
			@PathVariable("id") long subGroupId) {
		List<SubjectMasterEntity> subjectMasterEntity = academicSetupService
				.getSubjectMasterBySubjectGroupId(instituteId, subGroupId);
		if (subjectMasterEntity != null) {
			return new ResponseEntity<>(subjectMasterEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}/*
		 * @PostMapping("/addGradingTittle") public ResponseEntity<?>
		 * addGradingTittle(@RequestBody GradingTittleEntity academicCourseEntity){
		 * Response<?> validationResponse =
		 * validationService.validateForGradingtittleAdd(academicCourseEntity); if
		 * (validationResponse.getResponseCode() == HttpStatus.OK.value()) { Response<?>
		 * response = academicSetupService.addSGradingTittle(academicCourseEntity);
		 * return new ResponseEntity<>(response,
		 * HttpStatus.valueOf(response.getResponseCode())); } else { return new
		 * ResponseEntity<>(validationResponse,
		 * HttpStatus.valueOf(validationResponse.getResponseCode())); } }
		 */

	@GetMapping("/getAllCommonsData/{instituteId}/{keyword}")
	public ResponseEntity<?> getAllCommonsData(@PathVariable("instituteId") Long instituteId,@PathVariable("keyword") String keyword) {
		List<CommonsDataEntity> list = academicSetupService.getAllCommonsData(instituteId,keyword);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Commons Data Failed To Retrive", null));
		}
	}
	@GetMapping("/getAllCommonsData")
	public ResponseEntity<?> getAllCommonsData1() {
		List<CommonsDataEntity> list = academicSetupService.getAllCommonsData1();
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Commons Data Failed To Retrive", null));
		}
	}

	@GetMapping("/getAllModules")
	public ResponseEntity<?> getAllModules() {
		List<ModulesEntity> list = academicSetupService.getAllModules();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@PostMapping("/addModule")
	public ResponseEntity<ResponseData<ModulesEntity>> addModule(@RequestBody ModulesEntity modulesEntity) {
		try {

			Response<?> response = academicSetupService.addModule(modulesEntity);
			return ResponseEntity.ok(new ResponseData<>(0, "Module added successfully", modulesEntity));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to add Module", null));
		}
	}

	@PostMapping("/addAssessment")
	public ResponseEntity<ResponseData<AcademicAssessmentEntity>> addAssessment(
			@Valid @RequestBody AcademicAssessmentEntity academicAssessmentEntity) {

		try {
			AcademicAssessmentEntity assessmentData = academicSetupService.addAssesment(academicAssessmentEntity);
			return ResponseEntity.ok(new ResponseData<>(0, "Assessment added successfully", assessmentData));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to add Assessment", null));
		}
	}

	@GetMapping("/getGradingTittle/{instituteId}")
	public ResponseEntity<?> getAllGradingTittle(@PathVariable("instituteId") Long instituteId) {
		List<GradingTittleEntity> list = academicSetupService.getAllGradingTittle(instituteId);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Grading Tittle Failed To Retrive", null));
		}
	}

	@GetMapping("/getAllAssessment/{instituteId}")
	public ResponseEntity<?> getAllAssessment(@PathVariable("instituteId") Long instituteId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Page<AcademicAssessmentEntity> list = academicSetupService.getAllAssessment(instituteId, page, size);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "AcademicAssessment not found with provioded Id", null));
		}
	}

	@PostMapping("/addClassGroup")
	public ResponseEntity<ResponseData<ClassGroupEntity>> addClassGroup(
			@Valid @RequestBody ClassGroupEntity classGroupEntity) {

		try {

			Response<?> response = academicSetupService.addClassGroup(classGroupEntity);
			return ResponseEntity.ok(new ResponseData<>(0, "ClassGroup added successfully", classGroupEntity));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to add ClassGroup", null));
		}
	}

	@GetMapping("/getAllClassGroup/{instituteId}")
	public ResponseEntity<?> getAllClassGroup(@PathVariable("instituteId") Long instituteId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Page<ClassGroupEntity> list = academicSetupService.getAllClassGroup(instituteId, page, size);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "success", list));

		} else {

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseData<>(1, "ClassGroup not found with provided id", null));
	}



	@GetMapping("/getAllAcademicYear/{instituteId}")
	public ResponseEntity<?> getAllAcademicYear(@PathVariable("instituteId") Long instituteId) {
		List<AcademicYearEntity> list = academicSetupService.getAllAcademicYear(instituteId);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, " Academic Year not found with provioded Id", null));
		}
	}

	@PostMapping("/addSubjectGroup")
	public ResponseEntity<ResponseData<SubjectGroupEntity>> addSubjectGroup(
			@Valid @RequestBody SubjectGroupEntity subjectGroupEntity) {

		try {
			SubjectGroupEntity subjectGroupData = academicSetupService.addSubjectGroup(subjectGroupEntity);
			return ResponseEntity.ok(new ResponseData<>(0, "SubjectGroup added successfully", subjectGroupData));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to add SubjectGroup", null));
		}
	}


	@DeleteMapping("/deactivate/ClassGroup/{classId}")
	public ResponseEntity<?> deactivateClassGroup(@PathVariable Long classId) {
		Response<?> response = academicSetupService.deactivateClassGroup(classId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//	@GetMapping("/getAssessmentById/{instituteId}/{assessmentId}")
//	public ResponseEntity<?> getAssessmentById(@PathVariable("instituteId") Long instituteId,
//			@PathVariable("assessmentId") long assessmentId) {
//		Optional<AcademicAssessmentEntity> academicAssessmentEntity = academicSetupService.getAssessmentById(instituteId,
//				assessmentId);
//		if (academicAssessmentEntity != null) {
//			return ResponseEntity.ok(new ResponseData<>(0, "Success", academicAssessmentEntity));
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.body(new ResponseData<>(1, "Assessment Failed to Retrive", null));
//		}
//	}

	@PutMapping("/updateAcademicCourse")
	public ResponseEntity<?> updateAcademicCourse(@RequestBody AcademicCourseEntity academicCourseEntity) {

		AcademicCourseEntity updatedAcademicCourse = academicSetupService.updateAcademicCourse(academicCourseEntity);
		if (updatedAcademicCourse != null) {
			return ResponseEntity
					.ok(new ResponseData<>(0, "Academic Course  update successfully", updatedAcademicCourse));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to update Academic Course", null));
		}

	}

	@GetMapping("/getClassGroupById/{instituteId}/{classId}")
	public ResponseEntity<?> getClassGroupById(@PathVariable("instituteId") long instituteId,
			@PathVariable("classId") long classId) {
		ClassGroupEntity classGroupData = academicSetupService.getClassGroupById(instituteId, classId);
		if (classGroupData != null) {
			return new ResponseEntity<>(classGroupData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deactivate/ClassGroup/{instituteId}/{classId}")
	public ResponseEntity<?> deactivateClassGroup(@PathVariable Long instituteId, @PathVariable Long classId) {
		Response<?> response = academicSetupService.deactivateClassGroup(instituteId, classId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getAssessmentById/{instituteId}/{assessmentId}")
	public ResponseEntity<?> getAssessmentById(@PathVariable("instituteId") Long instituteId,
			@PathVariable("assessmentId") long assessmentId) {
		Optional<AcademicAssessmentEntity> academicAssessmentEntity = academicSetupService
				.getAssessmentById(instituteId, assessmentId);
		if (academicAssessmentEntity != null) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", academicAssessmentEntity));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Assessment Failed to Retrive", null));
		}
	}

	@DeleteMapping("/deactivate/assessment/{assessmentId}")
	public ResponseEntity<?> deactivateAssessment(@PathVariable Long assessmentId) {
		Response<?> response = academicSetupService.deactivateAssessment(assessmentId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getAllTableData/{instituteId}")
	public ResponseEntity<Map<String, Object>> getAllTableData(@PathVariable("instituteId") Long instituteId) {
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("courseLevelData", academicSetupService.getAllCourseLevel(instituteId));
		responseData.put("departmentData", academicSetupService.getAllDepartment(instituteId));
		responseData.put("programData", academicSetupService.getAllProgram(instituteId));
		responseData.put("sectionData", academicSetupService.getAllSection(instituteId));
		return ResponseEntity.ok(responseData);
	}

	@PostMapping("/addAcademicCourse")
	public ResponseEntity<ResponseData<AcademicCourseEntity>> addAcademicCourse(
			@Valid @RequestBody AcademicCourseEntity academicCourseEntity) {
		try {

			AcademicCourseEntity response = academicSetupService.addAcademicCourse(academicCourseEntity);
			return ResponseEntity
					.ok(new ResponseData<>(0, "Academic Course  added successfully", academicCourseEntity));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to add Academic Cour"
							+ "se", null));
		}
	}
//	@PostMapping("/addSessions")
//	private ResponseEntity<ResponseData<ScheduleDayEntity>> addSessions(@Valid @RequestBody ScheduleDayDTO scheduleDayDTO){
//		log.info("payload   {}", scheduleDayDTO);
//		try {
//			ScheduleDayEntity scheduleDayEntity=ScheduleDayEntity.builder()
//					.scheduleDayName(scheduleDayDTO.getScheduleDayName())
//		        	.fkAcademicCourse(AcademicCourseEntity.builder().academicCourseId(scheduleDayDTO.getFkAcademicCourse()).build())
//		        	.fkInstituteId(InstituteEntity.builder().instituteId(scheduleDayDTO.getFkInstituteId()).build())
//		        	.build();
//			ScheduleDayEntity scheduleDayEntityData = academicSetupService
//		                .addScheduleDay(scheduleDayEntity);
//			List<PeriodsEntity> periodsList = scheduleDayDTO.getPeriodsDTO().stream()
//	                .map(periodDTO  -> {
//	                	PeriodsEntity periodsEntity=PeriodsEntity.builder()
//	                			//.fkScheduleDay(ScheduleDayEntity.builder().scheduleDayId(periodDTO.getFkScheduleDay()).build())
//	                			.FkInstituteId(InstituteEntity.builder().instituteId(periodDTO.getFkInstituteId()).build())
//	                			//.periodId(periodDTO.getPeriodId())
//	                			.StartTime(periodDTO.getStartTime())
//	                			.EndTime(periodDTO.getEndTime())
//	                			.slotName(periodDTO.getSlotName())
//	                			.build();
//	                	return periodsEntity;
//	                })
//	                .collect(Collectors.toList());
//			 academicSetupService.addPeriods(periodsList);
//	                			
//	                			
//			 return ResponseEntity.ok(new ResponseData<>(0, "Session added successfully", scheduleDayEntityData));
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                .body(new ResponseData<>(1, "Failed to add Session", null));
//	    }
//	}
	
	
//	@PostMapping("/addSessions")
//	private ResponseEntity<ResponseData<ScheduleDayEntity>> addSessions(@Valid @RequestBody ScheduleDayDTO scheduleDayDTO) {
//	    log.info("payload   {}", scheduleDayDTO);
//	    try {
//	        ScheduleDayEntity scheduleDayEntity = ScheduleDayEntity.builder()
//	                .scheduleDayName(scheduleDayDTO.getScheduleDayName())
//	                .fkAcademicCourse(AcademicCourseEntity.builder().academicCourseId(scheduleDayDTO.getFkAcademicCourse()).build())
//	                .fkInstituteId(InstituteEntity.builder().instituteId(scheduleDayDTO.getFkInstituteId()).build())
//	                .build();
//
//	        ScheduleDayEntity scheduleDayEntityData = academicSetupService.addScheduleDay(scheduleDayEntity);
//
//	        if (scheduleDayDTO.getPeriodsDTO() != null) {
//	            List<PeriodsEntity> periodsList = scheduleDayDTO.getPeriodsDTO().stream()
//	                    .map(periodDTO -> {
//	                        PeriodsEntity periodsEntity = PeriodsEntity.builder()
//	                                .fkScheduleDay(scheduleDayEntityData)
//	                                .FkInstituteId(InstituteEntity.builder().instituteId(periodDTO.getFkInstituteId()).build())
//	                                .periodId(periodDTO.getPeriodId())
//	                                .StartTime(periodDTO.getStartTime())
//	                                .EndTime(periodDTO.getEndTime())
//	                                .slotName(periodDTO.getSlotName())
//	                                .build();
//	                        return periodsEntity;
//	                    })
//	                    .collect(Collectors.toList());
//
//	            academicSetupService.addPeriods(periodsList);
//	        }
//
//	        return ResponseEntity.ok(new ResponseData<>(0, "Session added successfully", scheduleDayEntityData));
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                .body(new ResponseData<>(1, "Failed to add Session", null));
//	    }
//	}

	@PostMapping("/addSessions")
	private ResponseEntity<ResponseData<ScheduleDayEntity>> addSessions(@Valid @RequestBody SessionDTOSave sessionDTOSave) {
	    log.info("payload   {}", sessionDTOSave);
		try {
			ArrayList<PeriodsEntity> periodsList = new ArrayList<PeriodsEntity>();
			
			ScheduleDayEntity scheduleDayEntity=new ScheduleDayEntity();
			ScheduleDayDTO scheduleDayDTO=sessionDTOSave.getScheduleDayDTO();
			scheduleDayEntity.setScheduleDayId(scheduleDayDTO.getScheduleDayId());
			InstituteEntity instituteEntity = new InstituteEntity();
			instituteEntity.setInstituteId(scheduleDayDTO.getFkInstituteId());
			AcademicCourseEntity academicCourseEntity=new AcademicCourseEntity();
			academicCourseEntity.setAcademicCourseId(scheduleDayDTO.getFkAcademicCourse());
			scheduleDayEntity.setFkAcademicCourse(academicCourseEntity);
			scheduleDayEntity.setScheduleDayName(scheduleDayDTO.getScheduleDayName());
			ScheduleDayEntity scheduleDayEntityData = academicSetupService
					.addScheduleDay(scheduleDayEntity);
			for (PeriodsDTO periods : sessionDTOSave.getPeriodsDTO()) {
				PeriodsEntity periodsENtity = new PeriodsEntity();
				periodsENtity.setEndTime(periods.getEndTime());
				periodsENtity.setFkScheduleDay(scheduleDayEntityData);
				periodsENtity.setFkInstituteId(instituteEntity);
				periodsENtity.setPeriodId(periods.getPeriodId());
				periodsENtity.setSlotName(periods.getSlotName());
				periodsENtity.setStartTime(periods.getStartTime());
				periodsList.add(periodsENtity);
			}
			academicSetupService.addPeriods(periodsList);

			return ResponseEntity.ok(new ResponseData<>(0, "Session added successfully", scheduleDayEntityData));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to add Session", null));

		}
	}
	
	@GetMapping("/getScheduleDayById/{instituteId}/{scheduleDayId}")
	public ResponseEntity<?> getScheduleDayById(@PathVariable("instituteId") long instituteId,
			@PathVariable("scheduleDayId") long scheduleDayId) {
		Optional<ScheduleDayEntity> sessionData = academicSetupService.getScheduleDayById(instituteId, scheduleDayId);
		if (sessionData != null) {
			return ResponseEntity.ok(new ResponseData<>(0, "success", sessionData));

		} else {

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseData<>(1, "Session not found with provided id", null));

	}

	@GetMapping("/getAllScheduleDay/{instituteId}")
	public ResponseEntity<?> getAllScheduleDay(@PathVariable("instituteId") Long instituteId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Page<ScheduleDayEntity> list = academicSetupService.getAllScheduleDay(instituteId, page, size);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "success", list));

		} else {

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseData<>(1, "Schedule Day not found with provided id", null));

	}

	@GetMapping("/getScheduleClassById/{instituteId}/{scheduleClassId}")
	public ResponseEntity<?> getScheduleClassById(@PathVariable("instituteId") long instituteId,
			@PathVariable("scheduleClassId") long scheduleClassId) {
		Optional<ScheduleClassEntity> classData = academicSetupService.getScheduleClassById(instituteId,
				scheduleClassId);
		if (classData != null) {
			return ResponseEntity.ok(new ResponseData<>(0, "success", classData));

		} else {

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseData<>(1, "Schedule Class not found with provided id", null));

	}

	@GetMapping("/getAllScheduleClass/{instituteId}")
	public ResponseEntity<?> getAllScheduleClass(@PathVariable("instituteId") Long instituteId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Page<ScheduleClassEntity> list = academicSetupService.getAllScheduleClass(instituteId, page, size);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "success", list));

		} else {

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseData<>(1, "Schedule Class not found with provided id", null));

	}

	@DeleteMapping("/deactivate/academicCourseLevel/{instituteId}/{courseLevelId}")
	public ResponseEntity<?> deactivateCourseLevel(@PathVariable("instituteId") Long instituteId,
			@PathVariable("courseLevelId") Long courseLevelId) {
		Response<?> response = academicSetupService.deactivateCourseLevel(instituteId, courseLevelId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deactivate/program/{instituteId}/{programId}")
	public ResponseEntity<?> deactivateProgarm(@PathVariable("instituteId") Long instituteId,
			@PathVariable("programId") Long programId) {
		Response<?> response = academicSetupService.deactivateProgarm(instituteId, programId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deactivate/department/{instituteId}/{departmentId}")
	public ResponseEntity<?> deactivateDepartment(@PathVariable("instituteId") Long instituteId,
			@PathVariable("departmentId") Long departmentId) {
		Response<?> response = academicSetupService.deactivateDepartment(instituteId, departmentId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deactivate/section/{instituteId}/{sectionId}")
	public ResponseEntity<?> deactivateSection(@PathVariable("instituteId") Long instituteId,
			@PathVariable("sectionId") Long sectionId) {
		Response<?> response = academicSetupService.deactivateSection(instituteId, sectionId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deactivate/SubjectCategory/{instituteId}/{subjectcategoryId}")
	public ResponseEntity<?> deactivateSubjectCategory(@PathVariable("instituteId") Long instituteId,
			@PathVariable("subjectcategoryId") Long subjectcategoryId) {
		Response<?> response = academicSetupService.deactivateSubjectCategory(instituteId, subjectcategoryId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@DeleteMapping("/deactivate/ScheduleDay/{instituteId}/{scheduleDayId}")
	public ResponseEntity<?> deactivateScheduleDay(@PathVariable("instituteId") Long instituteId,
			@PathVariable("scheduleDayId") Long scheduleDayId) {
		Response<?> response = academicSetupService.deactivateScheduleDay(instituteId, scheduleDayId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/deactivate/ScheduleClass/{instituteId}/{scheduleClassId}")
	public ResponseEntity<?> deactivateScheduleClass(@PathVariable("instituteId") Long instituteId,
			@PathVariable("scheduleClassId") Long scheduleClassId) {
		Response<?> response = academicSetupService.deactivateScheduleDay(instituteId, scheduleClassId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/getAllHouse/{instituteId}")
	public ResponseEntity<?> getAllHouse(@PathVariable("instituteId") Long instituteId) {
		List<HouseEntity> list = academicSetupService.getAllHouse(instituteId);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "House not found with provioded Id", null));
		}
	}
	@PostMapping("/addSubjectDetails")
	public ResponseEntity<ResponseData<SubjectDetailsEntity>> addSubjectDetails(
			 @RequestBody SubjectDetailsEntity subjectDetailsEntity) {

		try {
			SubjectDetailsEntity subjectDetailData = academicSetupService.addSubjectDetails(subjectDetailsEntity);
			return ResponseEntity.ok(new ResponseData<>(0, "SubjectDetails added successfully", subjectDetailsEntity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseData<>(1, "Failed to add SubjectDetails", null));
		}
	}

	@GetMapping("/getAllTopics/{instituteId}")
	public ResponseEntity<?> getAllTopics(@PathVariable("instituteId") Long instituteId){
		List<TopicEntity> list= academicSetupService.getAllTopics(instituteId);
		if(!list.isEmpty()) {
	        return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
	    }else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(new ResponseData<>(1, "Topics not found with provioded Id", null));
	    }
	}
	@GetMapping("/getSubjectGroupById/{instituteId}/{subGroupId}")
	public ResponseEntity<?> getSubjectGroupById(@PathVariable("instituteId") Long instituteId,
			@PathVariable("subGroupId") Long subGroupId) {
		Optional<SubjectGroupEntity> subjectGroupData = academicSetupService.getSubjectGroupById(instituteId, subGroupId);
		if (subjectGroupData != null) {
			return new ResponseEntity<>(subjectGroupData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
