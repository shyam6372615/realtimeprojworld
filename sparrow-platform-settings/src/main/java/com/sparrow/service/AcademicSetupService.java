package com.sparrow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.AcademicSubjectDTO;
import com.sparrow.dto.Response;
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
import com.sparrow.entity.SessionClassTimingEntity;
import com.sparrow.entity.SubjectCategoryEntity;
import com.sparrow.entity.SubjectDetailsEntity;
import com.sparrow.entity.SubjectGroupEntity;
import com.sparrow.entity.SubjectMasterEntity;
import com.sparrow.entity.TopicEntity;
import com.sparrow.exception.NotFoundException;
import com.sparrow.exception.UpdateFailedException;
import com.sparrow.repo.AcademicAssessmentRepo;
import com.sparrow.repo.AcademicBatchYearRepo;
import com.sparrow.repo.AcademicCourseRepo;
import com.sparrow.repo.AcademicSubjectRepo;
import com.sparrow.repo.AcademicYearRepo;
import com.sparrow.repo.ActiveModuleRepo;
import com.sparrow.repo.ClassGroupRepo;
import com.sparrow.repo.CommonsRepo;
import com.sparrow.repo.CourseLevelRepo;
import com.sparrow.repo.DepartmentRepo;
import com.sparrow.repo.GradingTittleRepo;
import com.sparrow.repo.HouseRepo;
import com.sparrow.repo.ModuleRepo;
import com.sparrow.repo.PeriodsRepo;
import com.sparrow.repo.ProgramRepo;
import com.sparrow.repo.ScheduleClassRepo;
import com.sparrow.repo.ScheduleDayRepo;
import com.sparrow.repo.SectionRepo;
import com.sparrow.repo.SessionAcademicYearRepo;
import com.sparrow.repo.SessionClassTimingRepo;
import com.sparrow.repo.SubjectCategoryRepo;
import com.sparrow.repo.SubjectDetailsRepo;
import com.sparrow.repo.SubjectGroupRepo;
import com.sparrow.repo.SubjectMasterRepo;
import com.sparrow.repo.TopicRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class AcademicSetupService {
	@Autowired
	private SessionAcademicYearRepo sessionAcademicYearRepo;
	@Autowired
	private SectionRepo sectionRepo;
	@Autowired
	private ProgramRepo programRepo;
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private CourseLevelRepo courseLevelRepo;
	@Autowired
	private AcademicCourseRepo academicCourseRepo;
	@Autowired
	private SessionClassTimingRepo sessionClassTimingRepo;
	@Autowired
	private PeriodsRepo periodsRepo;
	@Autowired
	private AcademicYearRepo academicYearRepo;
	@Autowired
	private AcademicBatchYearRepo academicBatchYearRepo;
	@Autowired
	private AcademicSubjectRepo academicSubjectRepo;
	@Autowired
	private SubjectGroupRepo subjectGroupRepo;
	@Autowired
	private SubjectCategoryRepo SubjectCategoryRepo;
	@Autowired
	private SubjectMasterRepo subjectMasterRepo;
	@Autowired
	private GradingTittleRepo gadingTittleRepo;
	@Autowired
	private CommonsRepo commonsRepo;
	@Autowired
	private ModuleRepo moduleRepo;
	@Autowired
	private AcademicAssessmentRepo academicAssessmentRepo;
	@Autowired
	private ClassGroupRepo classGroupRepo;
	@Autowired
	private ActiveModuleRepo activeModuleRepo;
	@Autowired
	private ScheduleClassRepo scheduleClassRepo;
	@Autowired
	private ScheduleDayRepo scheduleDayRepo;
	@Autowired
	private HouseRepo houseRepo;
	@Autowired
	private SubjectDetailsRepo subjectDetailsRepo;
	@Autowired
	private TopicRepo topicRepo;
	@Autowired
	private  EntityManager entityManager;

	public Response<?> addSessionAcademicYear(SessionAcademicYear sessionAcademicYear) {
		try {
			SessionAcademicYear sessionAcademicYearData = sessionAcademicYearRepo.save(sessionAcademicYear);
			return new Response<>(HttpStatus.CREATED.value(), "Academic Year Added Successfully!!",
					sessionAcademicYearData);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Failed to add Academic Year: " + ex.getMessage(), null);
		}
	}

	public Page<SessionAcademicYear> getAllSessionAcademicYear(Long instituteId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return sessionAcademicYearRepo.getAllActivelist(instituteId, pageable);

	}

	public SessionAcademicYear getSessionmAcademicYearById(Long instituteId, Long academicYearId) {
		return sessionAcademicYearRepo.findSessionAcademicYearById(instituteId, academicYearId);

	}

	public SessionAcademicYear updateSessionAcademicYear(SessionAcademicYear sessionAcademicYear) {
		Optional<SessionAcademicYear> optional = sessionAcademicYearRepo
				.findById(sessionAcademicYear.getAcademicSetupId());

		SessionAcademicYear existingSessionAcademicYear = optional.get();

		existingSessionAcademicYear.setEndDate(sessionAcademicYear.getEndDate());
		existingSessionAcademicYear.setFkAcademicYear(sessionAcademicYear.getFkAcademicYear());
		existingSessionAcademicYear.setFkBatchyear(sessionAcademicYear.getFkBatchyear());
		existingSessionAcademicYear.setStartDate(sessionAcademicYear.getStartDate());

		existingSessionAcademicYear.setIsActive(true);
		SessionAcademicYear updatedSessionAcademicYearData = sessionAcademicYearRepo.save(existingSessionAcademicYear);

		return updatedSessionAcademicYearData;

	}

	public Response<?> deactivateSessionAcademicYear(Long instituteId, Long id) {
		Optional<SessionAcademicYear> existingSessionAcdmYearData = sessionAcademicYearRepo
				.findByInstituteIdAndId(instituteId, id);

		if (existingSessionAcdmYearData.isPresent()) {
			existingSessionAcdmYearData.get().setIsActive(false);
			sessionAcademicYearRepo.save(existingSessionAcdmYearData.get());
			return new Response<>(HttpStatus.OK.value(), "Session Academic Year Deactivated successfully", null);
		} else {

			return new Response<>(HttpStatus.NOT_FOUND.value(), " Session Academic Year  not found", null);
		}
	}

	public Page<AcademicCourseEntity> getAllAcademicCourse(Long instituteId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return academicCourseRepo.getAllActivelist(instituteId, pageable);

	}

	public Optional<AcademicCourseEntity> getAcademicCourseById(long instituteId, Long academicCourseId) {
		return academicCourseRepo.getAcademicCourseById(instituteId, academicCourseId);
	}

	public List<SectionEntity> getAllSection(Long instituteId) {
		return sectionRepo.getAllActivelist(instituteId);

	}

//   public List<ProgramEntity> getAllProgramByLevelId(Long levelId){
//		return programRepo.findAllProgramByLevelId(levelId);
//}
	public List<ProgramEntity> getAllProgram(Long instituteId) {
		return programRepo.getAllActivelist(instituteId);
	}

//   public List<DepartmentEntity> getAllDepartmentByProgramId(Long programId){
//		return departmentRepo.findAllDepartmentByProgramId(programId);
//}
	public List<DepartmentEntity> getAllDepartment(Long instituteId) {
		return departmentRepo.getAllActivelist(instituteId);

	}

	public List<CourseLevelEntity> getAllCourseLevel(Long instituteId) {
		return courseLevelRepo.getAllActivelist(instituteId);
	}

	public Response<?> deactivateAcademicCourse(Long instituteId, Long id) {
		Optional<AcademicCourseEntity> existingCourseData = academicCourseRepo.findByInstituteIdAndCourseId(instituteId,
				id);

		if (existingCourseData.isPresent()) {
			existingCourseData.get().setIsActive(false);
			academicCourseRepo.save(existingCourseData.get());
			return new Response<>(HttpStatus.OK.value(), "Academic Course Deactivated successfully", null);
		} else {

			return new Response<>(HttpStatus.NOT_FOUND.value(), "Academic Course not found", null);
		}
	}

	public Response<?> addPeriods(List<PeriodsEntity> periodsEntity) {
		try {
			List<PeriodsEntity> periodsEntityData = periodsRepo.saveAll(periodsEntity);
			return new Response<>(HttpStatus.CREATED.value(), "Period Added Successfully!!", periodsEntityData);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to add Subject: " + ex.getMessage(),
					null);
		}

	}
	

	public SessionClassTimingEntity addSessionClassTiming(SessionClassTimingEntity sessionClassTimingEntity) {
		SessionClassTimingEntity sessionClassTimingEntityData = sessionClassTimingRepo.save(sessionClassTimingEntity);

		return sessionClassTimingEntityData;

	}

	public Page<PeriodsEntity> getAllPeriods(Long instituteId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);

		return periodsRepo.getAllActivelist(instituteId, pageable);
	}

	public PeriodsEntity getPeriodsById(Long instituteId, Long periodsId) {
		return periodsRepo.getPeriodsById(instituteId, periodsId);
	}

//	public PeriodsEntity updatePeriods(PeriodsEntity periodsEntity) {
//		Optional<PeriodsEntity> optional = periodsRepo.findById(periodsEntity.getPeriodId());
//		try {
//			if (optional.isPresent()) {
//				PeriodsEntity existingPeriodsEntity = optional.get();
//				existingPeriodsEntity.setEndTime(periodsEntity.getEndTime());
//				existingPeriodsEntity.setFkSessionClassId(periodsEntity.getFkSessionClassId());
//				existingPeriodsEntity.setInstituteId(periodsEntity.getInstituteId());
//				existingPeriodsEntity.setSlotName(periodsEntity.getSlotName());
//				existingPeriodsEntity.setStartTime(periodsEntity.getStartTime());
//				existingPeriodsEntity.setIsActive(true);
//
//				PeriodsEntity updatedPeriodsData = periodsRepo.save(existingPeriodsEntity);
//
//				return updatedPeriodsData;
//			} else {
//				throw new NotFoundException("period with ID " + periodsEntity.getPeriodId() + " not found");
//			}
//		} catch (Exception ex) {
//
//			ex.printStackTrace();
//			throw new UpdateFailedException("Failed to update period: " + ex.getMessage());
//		}
//	}

	public SessionClassTimingEntity updateSessionClassTiming(SessionClassTimingEntity sessionClassTimingEntity) {
		Optional<SessionClassTimingEntity> optional = sessionClassTimingRepo
				.findById(sessionClassTimingEntity.getSessionId());
		try {
			if (optional.isPresent()) {

				SessionClassTimingEntity existingData = optional.get();
				existingData.setDefaultDuration(sessionClassTimingEntity.getDefaultDuration());
				existingData.setEndTime(sessionClassTimingEntity.getEndTime());
				existingData.setFkClassGroups(sessionClassTimingEntity.getFkClassGroups());
				existingData.setIsActive(true);
				existingData.setIsFri(sessionClassTimingEntity.getIsFri());

				existingData.setIsMon(sessionClassTimingEntity.getIsMon());
				existingData.setIsSun(sessionClassTimingEntity.getIsSun());
				existingData.setIsSat(sessionClassTimingEntity.getIsSat());
				existingData.setIsthu(sessionClassTimingEntity.getIsthu());
				existingData.setIsTue(sessionClassTimingEntity.getIsTue());
				existingData.setIsWed(sessionClassTimingEntity.getIsWed());
				existingData.setStartTime(sessionClassTimingEntity.getStartTime());

				SessionClassTimingEntity updatedData = sessionClassTimingRepo.save(existingData);

				return updatedData;
			} else {
				throw new NotFoundException(
						"sessionTimming with ID " + sessionClassTimingEntity.getSessionId() + " not found");
			}
		} catch (Exception ex) {

			ex.printStackTrace();
			throw new UpdateFailedException("Failed to update SessionTiming: " + ex.getMessage());
		}
	}

	public Response<?> deactivatePeriods(Long id) {
		Optional<PeriodsEntity> existingData = periodsRepo.findById(id);

		if (existingData.isPresent()) {
			existingData.get().setIsActive(false);
			periodsRepo.save(existingData.get());
			return new Response<>(HttpStatus.OK.value(), "periods Deactivated successfully", null);
		} else {

			return new Response<>(HttpStatus.NOT_FOUND.value(), "Periods not found", null);
		}
	}

	public List<AcademicYearEntity> getAllAcademicYear(Long instituteId) {
		return academicYearRepo.getAllActivelist(instituteId);
	}

	public List<AcademicBatchYearEntity> getAllAcademicBatchYear(Long instituteId) {
		return academicBatchYearRepo.getAllActivelist(instituteId);

	}
	/*
	 * public Response<?> addAcademicSubject(AcademicSubjectEntity
	 * acdmSubjectEntity) { try { AcademicSubjectEntity academicSubjectData
	 * =academicSubjectRepo.save(acdmSubjectEntity); return new
	 * Response<>(HttpStatus.CREATED.value(), "Subject Added Successfully!!",
	 * academicSubjectData); } catch (Exception ex) { ex.printStackTrace(); return
	 * new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	 * "Failed to add Subject: " + ex.getMessage(), null); } }
	 */

	public AcademicSubjectEntity addAcademicSubject(AcademicSubjectEntity acdmSubjectEntity) {

		AcademicSubjectEntity academicSubjectData = academicSubjectRepo.save(acdmSubjectEntity);
		return academicSubjectData;
	}

	public CourseLevelEntity addCourseLevel(CourseLevelEntity courseLevelEntity) {
		CourseLevelEntity courseLevelData = courseLevelRepo.save(courseLevelEntity);
		return courseLevelData;
	}

	public ProgramEntity addProgram(ProgramEntity programEntity) {
		ProgramEntity programData = programRepo.save(programEntity);
		return programData;
	}

	public DepartmentEntity addDepartment(DepartmentEntity departmentEntity) {
		DepartmentEntity departmentData = departmentRepo.save(departmentEntity);
		return departmentData;
	}

	public SectionEntity addSection(SectionEntity sectionEntity) {
		SectionEntity sectionData = sectionRepo.save(sectionEntity);
		return sectionData;
	}

	/*
	 * public List<AcademicSubjectEntity> getAllAcademicSubjects(Long instituteId) {
	 * return academicSubjectRepo.getAllActivelist(instituteId);
	 */

	
/*	public List<AcademicSubjectEntity> getAllAcademicSubjects(Long instituteId) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<AcademicSubjectEntity> root = cq.from(AcademicSubjectEntity.class);
        
        Join<AcademicSubjectEntity, InstituteEntity> instituteJoin = root.join("fkInstituteId");
        
        cq.multiselect(root.get("acdmSubId"), root.get("acdmSubTitle"), root.get("acdmSubCode"));
        
        Predicate isActivePredicate = cb.isTrue(root.get("isActive"));
        Predicate instituteIdPredicate = cb.equal(instituteJoin.get("instituteId"), instituteId);
        
        cq.where(cb.and(isActivePredicate, instituteIdPredicate));

        List<Object[]> resultList = entityManager.createQuery(cq).getResultList();
        
        List<AcademicSubjectEntity> academicSubject = resultList.stream()
                .map(this::mapToAcademicSubject)
                .collect(Collectors.toList());

        return academicSubject;


		
	}
	
	private AcademicSubjectEntity mapToAcademicSubject(Object[] result) {
	
		AcademicSubjectEntity academicSubjectEntity = new AcademicSubjectEntity();
		
		academicSubjectEntity.setAcdmSubId((Long)result[0]);
		academicSubjectEntity.setAcdmSubTitle((String)result[1]);
		academicSubjectEntity.setAcdmSubCode((String)result[2]);
		return academicSubjectEntity;
		
	}
	*/
	
	 public List<AcademicSubjectDTO> getAllAcademicSubjects(long instituteId) {
	        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<AcademicSubjectDTO> cq = cb.createQuery(AcademicSubjectDTO.class);
	        Root<AcademicSubjectEntity> root = cq.from(AcademicSubjectEntity.class);

	        
	        Join<AcademicSubjectEntity, InstituteEntity> instituteJoin = root.join("fkInstituteId");

	        // Selecting only specific fields and mapping to DTO
	        cq.select(cb.construct(AcademicSubjectDTO.class,
	                root.get("acdmSubId"),
	                root.get("acdmSubTitle"),
	                root.get("acdmSubCode")));

	        // Adding conditions
	        Predicate isActivePredicate = cb.isTrue(root.get("isActive"));
	        Predicate instituteIdPredicate = cb.equal(instituteJoin.get("instituteId"), instituteId);

	        cq.where(cb.and(isActivePredicate, instituteIdPredicate));

	        return entityManager.createQuery(cq).getResultList();
	    }
	

	public AcademicSubjectEntity getAcademicSubjectById(Long instituteId, Long academicSubId) {
		return academicSubjectRepo.getAcademicSubById(instituteId, academicSubId);
	}

	public AcademicSubjectEntity updateAcademicSubject(AcademicSubjectEntity acdmSubjectEntity) {
		Optional<AcademicSubjectEntity> optional = academicSubjectRepo.findById(acdmSubjectEntity.getAcdmSubId());
		try {
			if (optional.isPresent()) {
				AcademicSubjectEntity existingAcdmSubjectEntity = optional.get();

				existingAcdmSubjectEntity.setAcdmSubCode(acdmSubjectEntity.getAcdmSubCode());
				existingAcdmSubjectEntity.setAcdmSubTitle(acdmSubjectEntity.getAcdmSubTitle());
				existingAcdmSubjectEntity.setFkInstituteId(acdmSubjectEntity.getFkInstituteId());
				existingAcdmSubjectEntity.setFkSubTypeId(acdmSubjectEntity.getFkSubTypeId());
				existingAcdmSubjectEntity.setIsActive(true);
				AcademicSubjectEntity updatedAcademicSubkjectData = academicSubjectRepo
						.saveAndFlush(existingAcdmSubjectEntity);

				return updatedAcademicSubkjectData;
			} else {
				throw new NotFoundException(
						"Academic Subject with ID " + acdmSubjectEntity.getAcdmSubId() + " not found");
			}
		} catch (Exception ex) {

			ex.printStackTrace();
			throw new UpdateFailedException("Failed to update Academic Subject: " + ex.getMessage());
		}

	}

	public Response<?> deactivateAcademicSubject(Long instituteId, Long id) {
		Optional<AcademicSubjectEntity> existingSubjectData = academicSubjectRepo
				.findByinstituteIdSubjectId(instituteId, id);

		if (existingSubjectData.isPresent()) {
			existingSubjectData.get().setIsActive(false);
			academicSubjectRepo.save(existingSubjectData.get());
			return new Response<>(HttpStatus.OK.value(), "Academic Subject Deactivated successfully", null);
		} else {

			return new Response<>(HttpStatus.NOT_FOUND.value(), "Academic Subject not found", null);
		}
	}

	public SubjectGroupEntity addSubjectGroup(SubjectGroupEntity subjectGroupEntity) {

		SubjectGroupEntity subjectGroupEntityData = subjectGroupRepo.save(subjectGroupEntity);
		return subjectGroupEntityData;
	}
	/*
	 * public SubjectGroupEntity addSubjectGroup(SubjectGroupEntity
	 * subjectGroupEntity) {
	 * 
	 * SubjectGroupEntity subjectGroupEntityData
	 * =subjectGroupRepo.save(subjectGroupEntity); return subjectGroupEntityData;
	 *   }
	 */

	public List<SubjectGroupEntity> getAllSubjectGroup(Long instituteId) {
		return subjectGroupRepo.getAllActivelist(instituteId);
	}

	public SubjectCategoryEntity addSubjectCategory(SubjectCategoryEntity subjectCategoryEntity) {
		SubjectCategoryEntity subjectCategoryData = SubjectCategoryRepo.save(subjectCategoryEntity);
		return subjectCategoryData;
	}

	public List<SubjectCategoryEntity> getAllSubjectCategory(Long instituteId) {
		return SubjectCategoryRepo.getAllActivelist(instituteId);
	}

	/*
	 * public Response<?> addSubjectMaster(SubjectMasterEntity SubjectMaster){ try {
	 * SubjectMasterEntity subjectMasterEntityData
	 * =subjectMasterRepo.save(SubjectMaster); return new
	 * Response<>(HttpStatus.CREATED.value(),
	 * "SubjectMaster  Added Successfully!!",subjectMasterEntityData); } catch
	 * (Exception ex) { ex.printStackTrace(); return new
	 * Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	 * "Failed to add Subject: " + ex.getMessage(), null); }
	 */
	public Response<?> addSubjectMaster(SubjectMasterEntity SubjectMaster) {

		try {
			SubjectMasterEntity subjectMasterEntityData = subjectMasterRepo.save(SubjectMaster);
			return new Response<>(HttpStatus.CREATED.value(), "Subject master  Added Successfully!!",
					subjectMasterEntityData);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to add Subject: " + ex.getMessage(),
					null);
		}
	}

	public List<SubjectMasterEntity> getSubjectMasterBySubjectGroupId(Long instituteId, Long groupId) {
		return subjectMasterRepo.findSubjectMasterByGroupId(instituteId, groupId);
	}
	/*
	 * public Response<?> addSGradingScheme(GradingEntity gradingSchemeEntity) {
	 * 
	 * try { GradingSchemeEntity gradingSchemeEntityData
	 * =gadingTittleRepo.save(gradingSchemeEntity); return new
	 * Response<>(HttpStatus.CREATED.value(),
	 * "Subject master  Added Successfully!!", subjectMasterEntityData); } catch
	 * (Exception ex) { ex.printStackTrace(); return new
	 * Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	 * "Failed to add Subject: " + ex.getMessage(), null); } }
	 */

	public List<CommonsDataEntity> getAllCommonsData(Long instituteId,String keyword) {
		return commonsRepo.getAllActivelist(instituteId,keyword);

	}
	public List<CommonsDataEntity> getAllCommonsData1() {
		return commonsRepo.getAllActivelist1();

	}

	public List<ModulesEntity> getAllModules() {
		return moduleRepo.getAllActivelist();
	}

	public Response<?> addModule(ModulesEntity modulesEntity) {
		try {
			ModulesEntity modulesData = moduleRepo.save(modulesEntity);
			return new Response<>(HttpStatus.CREATED.value(), "Module Added Successfully!!", modulesEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to add Module: " + ex.getMessage(),
					null);
		}

	}

	public AcademicAssessmentEntity addAssesment(AcademicAssessmentEntity academicAssessmentEntity) {
		AcademicAssessmentEntity academicAssesmentData = academicAssessmentRepo.save(academicAssessmentEntity);
		return academicAssesmentData;
	}

	public List<GradingTittleEntity> getAllGradingTittle(Long instituteId) {
		return gadingTittleRepo.getAllActivelist(instituteId);
	}

	public Page<AcademicAssessmentEntity> getAllAssessment(Long instituteId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);

		return academicAssessmentRepo.getAllActivelist(instituteId, pageable);
	}

	public Response<?> addClassGroup(ClassGroupEntity classGroupEntity) {
		try {
			ClassGroupEntity classGroupSaved = classGroupRepo.save(classGroupEntity);
			return new Response<>(HttpStatus.CREATED.value(), "Class Group Added Successfully!!", classGroupSaved);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Failed to add Class Group: " + ex.getMessage(), null);
		}
	}

	public Response<?> deactivateClassGroup(Long instituteId, Long classId) {
		Optional<ClassGroupEntity> existingData = classGroupRepo.findByinstituteIdClassGroupId(instituteId, classId);

		if (existingData.isPresent()) {
			existingData.get().setIsActive(false);
			classGroupRepo.save(existingData.get());
			return new Response<>(HttpStatus.OK.value(), "ClassGroup Deactivated successfully", null);
		} else {

			return new Response<>(HttpStatus.NOT_FOUND.value(), "ClassGroup not found", null);
		}
	}

	public ClassGroupEntity getClassGroupById(long instituteId, Long classId) {
		return classGroupRepo.getClassGroupById(instituteId, classId);
	}

	public Response<?> deactivateClassGroup(Long classId) {
		Optional<ClassGroupEntity> existingData = classGroupRepo.findById(classId);

		if (existingData.isPresent()) {
			existingData.get().setIsActive(false);
			classGroupRepo.save(existingData.get());
			return new Response<>(HttpStatus.OK.value(), "ClassGroup Deactivated successfully", null);
		} else {

			return new Response<>(HttpStatus.NOT_FOUND.value(), "ClassGroup not found", null);
		}
	}
//	public SessionClassTimingEntity getSessionClassTimingById(long instituteId, Long sessionId) {
//		return sessionClassTimingRepo.getSessionClassTimingById1(instituteId, sessionId);
//	}
//	
//
//	public Page<SessionClassTimingEntity> getAllSessionClassTiming(Long instituteId, int page, int size) {
//		Pageable pageable = PageRequest.of(page, size);
//		return sessionClassTimingRepo.getAllActivelist(instituteId, pageable);
//	}
//	

	public ClassGroupEntity updateClassGroup(ClassGroupEntity classGroupEntity) {
		Optional<ClassGroupEntity> optional = classGroupRepo.findById(classGroupEntity.getClassId());
		try {
			if (optional.isPresent()) {
				ClassGroupEntity existingClassGroupEntity = new ClassGroupEntity();
				existingClassGroupEntity.setClassId(classGroupEntity.getClassId());
				existingClassGroupEntity.setClassGroupName(classGroupEntity.getClassGroupName());
				existingClassGroupEntity.setInstituteId(classGroupEntity.getInstituteId());
				existingClassGroupEntity.setIsActive(true);

				ClassGroupEntity updatedClassGroup = classGroupRepo.save(existingClassGroupEntity);
				return updatedClassGroup;
			}

			else {
				throw new NotFoundException("ClassGroup with ID " + classGroupEntity.getClassId() + " not found");
			}
		} catch (Exception ex) {
			throw new UpdateFailedException("Failed to update ClassGroup: " + ex.getMessage());
		}
	}

	public AcademicCourseEntity updateAcademicCourse(AcademicCourseEntity academicCourseEntity) {
		Optional<AcademicCourseEntity> optional = academicCourseRepo
				.findById(academicCourseEntity.getAcademicCourseId());
		try {
			if (optional.isPresent()) {
				AcademicCourseEntity existingCourse = new AcademicCourseEntity();
				existingCourse.setFkInstituteId(academicCourseEntity.getFkInstituteId());
				existingCourse.setFkCourseLevelId(academicCourseEntity.getFkCourseLevelId());
				existingCourse.setFkProgramId(academicCourseEntity.getFkProgramId());
				existingCourse.setFkDeptId(academicCourseEntity.getFkDeptId());
				existingCourse.setFkSectionId(academicCourseEntity.getFkSectionId());
				existingCourse.setCourseDuration(academicCourseEntity.getCourseDuration());
				existingCourse.setSectionStudents(academicCourseEntity.getSectionStudents());
				existingCourse.setCourseTitle(academicCourseEntity.getCourseTitle());
				existingCourse.setCourseSemester(academicCourseEntity.getCourseSemester());
				existingCourse.setOddSemesterStDt(academicCourseEntity.getOddSemesterStDt());
				existingCourse.setEvenSemesterStDt(academicCourseEntity.getEvenSemesterStDt());
				existingCourse.setIsActive(true);

				AcademicCourseEntity updatedCourse = academicCourseRepo.save(existingCourse);
				return updatedCourse;
			}

			else {
				throw new NotFoundException(
						"Academic Course with ID " + academicCourseEntity.getAcademicCourseId() + " not found");
			}
		} catch (Exception ex) {
			throw new UpdateFailedException("Failed to update Academic Course: " + ex.getMessage());

		}

	}

	public Optional<AcademicAssessmentEntity> getAssessmentById(Long instituteId, Long assessmentId) {
		return academicAssessmentRepo.getAssessmentById(instituteId, assessmentId);
	}

	public Response<?> deactivateAssessment(Long id) {
		Optional<AcademicAssessmentEntity> assessmentData = academicAssessmentRepo.findById(id);
		if (assessmentData.isPresent()) {
			assessmentData.get().setIsActive(false);
			academicAssessmentRepo.save(assessmentData.get());
			return new Response<>(HttpStatus.OK.value(), "Assessment status deleted successfully");
		} else {
			return new Response<>(HttpStatus.NOT_FOUND.value(), "Assessment not found", null);
		}
	}

	public AcademicCourseEntity addAcademicCourse(AcademicCourseEntity academicCourseEntity) {
		AcademicCourseEntity academicCourseData = academicCourseRepo.save(academicCourseEntity);
		return academicCourseData;

	}

	public Response<?> deactivateCourseLevel(Long instituteId, Long courseLevelId) {
		Optional<CourseLevelEntity> academicCourseData = courseLevelRepo.getCourseLevelById(instituteId, courseLevelId);
		if (academicCourseData.isPresent()) {
			academicCourseData.get().setIsActive(false);
			courseLevelRepo.save(academicCourseData.get());
			return new Response<>(HttpStatus.OK.value(), "Acdemic Course deleted successfully");
		} else {
			return new Response<>(HttpStatus.NOT_FOUND.value(), "Academic Course not found", null);
		}
	}

	public Response<?> deactivateProgarm(Long instituteId, Long programId) {
		Optional<ProgramEntity> programData = programRepo.getProgramById(instituteId, programId);
		if (programData.isPresent()) {
			programData.get().setIsActive(false);
			programRepo.save(programData.get());
			return new Response<>(HttpStatus.OK.value(), "Progarm deleted successfully");
		} else {
			return new Response<>(HttpStatus.NOT_FOUND.value(), "Progarm not found", null);
		}
	}

	public Response<?> deactivateDepartment(Long instituteId, Long departmentId) {
		Optional<DepartmentEntity> departmentData = departmentRepo.getDepartmentById(instituteId, departmentId);
		if (departmentData.isPresent()) {
			departmentData.get().setIsActive(false);
			departmentRepo.save(departmentData.get());
			return new Response<>(HttpStatus.OK.value(), "Department deleted successfully");
		} else {
			return new Response<>(HttpStatus.NOT_FOUND.value(), "Department not found", null);
		}
	}

	public Response<?> deactivateSection(Long instituteId, Long sectionId) {
		Optional<SectionEntity> sectionData = sectionRepo.getSectionById(instituteId, sectionId);
		if (sectionData.isPresent()) {
			sectionData.get().setIsActive(false);
			sectionRepo.save(sectionData.get());
			return new Response<>(HttpStatus.OK.value(), "Section deleted successfully");
		} else {
			return new Response<>(HttpStatus.NOT_FOUND.value(), "Section not found", null);
		}
	}

	public Response<?> deactivateSubjectCategory(Long instituteId, Long subjectcategoryId) {
		Optional<SubjectCategoryEntity> existingData = SubjectCategoryRepo.getSubjectCategoryById(instituteId,
				subjectcategoryId);

		if (existingData.isPresent()) {
			existingData.get().setIsActive(false);
			SubjectCategoryRepo.save(existingData.get());
			return new Response<>(HttpStatus.OK.value(), "SubjectCategory Deactivated successfully", null);
		} else {

			return new Response<>(HttpStatus.NOT_FOUND.value(), "SubjectCategory not found", null);
		}
	}

	public Response<?> addScheduleClass(List<ScheduleClassEntity> scheduleClassEntity) {
		try {
			List<ScheduleClassEntity> scheduleClassData = scheduleClassRepo.saveAll(scheduleClassEntity);
			return new Response<>(HttpStatus.CREATED.value(), "ScheduleClass Added Successfully!!", scheduleClassData);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Failed to add ScheduleClass: " + ex.getMessage(), null);
		}

	}

	public ScheduleDayEntity addScheduleDay(ScheduleDayEntity scheduleDayEntity) {
		ScheduleDayEntity scheduleDayData = scheduleDayRepo.save(scheduleDayEntity);
		return scheduleDayData;

	}

	public Optional<ScheduleDayEntity> getScheduleDayById(long instituteId, Long scheduleDayId) {
		return scheduleDayRepo.getScheduleDayById(instituteId, scheduleDayId);
	}

	public Page<ScheduleDayEntity> getAllScheduleDay(Long instituteId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return scheduleDayRepo.getAllActivelist(instituteId, pageable);
	}

	public Optional<ScheduleClassEntity> getScheduleClassById(long instituteId, Long scheduleClassId) {
		return scheduleClassRepo.getScheduleClassById(instituteId, scheduleClassId);
	}

	public Page<ScheduleClassEntity> getAllScheduleClass(Long instituteId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return scheduleClassRepo.getAllActivelist(instituteId, pageable);
	}

	public Page<ClassGroupEntity> getAllClassGroup(Long instituteId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return classGroupRepo.getAllActivelist(instituteId, pageable);
	}
	
	public Response<?> deactivateScheduleDay(Long instituteId,Long scheduleDayId) {
		Optional<ScheduleDayEntity> scheduleDayData = scheduleDayRepo.getScheduleDayById1(instituteId, scheduleDayId);
		if (scheduleDayData.isPresent()) {
			scheduleDayData.get().setIsActive(false);
			scheduleDayRepo.save(scheduleDayData.get());
			return new Response<>(HttpStatus.OK.value(), "Schedule Day status Deactivated successfully");
		} else {
			return new Response<>(HttpStatus.NOT_FOUND.value(), "Schedule Day not found", null);
		}

	}
	
	public Response<?> deactivateScheduleClass(Long instituteId,Long scheduleClassId) {
		Optional<ScheduleClassEntity> scheduleClassData = scheduleClassRepo.getScheduleClassById1(instituteId, scheduleClassId);
		if (scheduleClassData.isPresent()) {
			scheduleClassData.get().setIsActive(false);
			scheduleClassRepo.save(scheduleClassData.get());
			return new Response<>(HttpStatus.OK.value(), "Schedule Class status Deactivated successfully");
		} else {
			return new Response<>(HttpStatus.NOT_FOUND.value(), "Schedule Class not found", null);
		}

	}
	
	public List<HouseEntity> getAllHouse(Long instituteId) {
		return houseRepo.getAllActivelist(instituteId);
	}
	
	public SubjectDetailsEntity addSubjectDetails(SubjectDetailsEntity subjectDetailsEntity) {
		SubjectDetailsEntity subjectDetailsEntityData = subjectDetailsRepo.save(subjectDetailsEntity);
		return subjectDetailsEntityData;
	}
	public List<TopicEntity> getAllTopics(Long instituteId){
		return topicRepo.getAllActivelist(instituteId);
}
	public Optional<SubjectGroupEntity> getSubjectGroupById(Long instituteId, Long subGroupId) {
		return subjectGroupRepo.getSubjectGroupById(instituteId, subGroupId);
	}

}
