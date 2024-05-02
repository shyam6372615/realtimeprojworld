package com.sparrow.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.AcademicCourseEntity;
import com.sparrow.entity.AcademicSubjectEntity;
import com.sparrow.entity.AdministratorEntity;
import com.sparrow.entity.DepartmentAdminStratorEntity;
import com.sparrow.entity.GradingTittleEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.SessionAcademicYear;
import com.sparrow.entity.SubjectCategoryEntity;
import com.sparrow.entity.SubjectGroupEntity;
import com.sparrow.entity.SubjectMasterEntity;
@Service
public class ValidationService {
public Response<?> validateForInstituteAdd(InstituteEntity instEntity){
		
		
	
		if(instEntity.getEmail()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the emailId!!",null);
		}
		else if(instEntity.getFkInstituteTypeId()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the InstituteType!!",null);
		}
		else if(instEntity.getInstAddrs()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Address!!",null);
		}
		else if(instEntity.getInstituteIdPrefix()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Id prefix !!",null);
		}
		else if(instEntity.getInstituteName()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Name!!",null);
		}
		else if(instEntity.getInstLogo()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Logo!!",null);
		}
		else if(instEntity.getPhNo()==null) {
			return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Contact no!!",null);
		}
		
		
		else {
			return new Response<>(HttpStatus.OK.value(),"ok",null);
		}
}
		
		public Response<?> validateForadministratorAdd(AdministratorEntity administratorEntity){
			Object AdministratorEntity;
			if(administratorEntity.getFkInstituteId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Id!!",null);
			} 
//			else if(administratorEntity.getInstAdmName()== null) {
//				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Admin Name!!",null);
//			}
//			else if(administratorEntity.getInstAdmPosition()== null) {
//				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Institute Admin Position!!",null);
//			}
			
			else {
				return new Response<>(HttpStatus.OK.value(),"ok",null);
			}

		}
		public Response<?> validateForDeptadministratorAdd(DepartmentAdminStratorEntity DeptAdministratorEntity){
			Object DepartmentAdminStratorEntity;
			if(DeptAdministratorEntity.getDeptAdminName()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Department AdminStrator Name!!",null);
			} 
			else if(DeptAdministratorEntity.getFkDepartmentId()== null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Department Name Name!!",null);
			}
			else if(DeptAdministratorEntity.getFkStreamId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Stream !!",null);
			}
			
			else {
				return new Response<>(HttpStatus.OK.value(),"ok",null);
			}
	
		}
		public Response<?> validateForSessionAcademicYearAdd(SessionAcademicYear sessionAcademicYear){
			Object DepartmentAdminStratorEntity;
			if(sessionAcademicYear.getEndDate()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide End Date!!",null);
			} 
			else if(sessionAcademicYear.getFkAcademicYear()== null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Academic Year!!",null);
			}
			else if(sessionAcademicYear.getFkBatchyear()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide AcademicBatchyear !!",null);
			}
			else if(sessionAcademicYear.getStartDate()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Start Date !!",null);
			}
			
			else {
				return new Response<>(HttpStatus.OK.value(),"ok",null);
			}
	
		}
		public Response<?> validateForAcademicCourseAdd(AcademicCourseEntity academicCourseEntity){
			if(academicCourseEntity.getCourseDuration()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Course Duration!!",null);
			} 
			else if(academicCourseEntity.getCourseSemester()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Course Semester!!",null);
			}
			else if(academicCourseEntity.getEvenSemesterStDt()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the Even Semester Start Date!!",null);
			}else if(academicCourseEntity.getFkCourseLevelId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Course Level!!",null);
			}else if(academicCourseEntity.getFkDeptId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Department!!",null);
			}
			else if(academicCourseEntity.getFkProgramId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select the Program!!",null);
			}else if(academicCourseEntity.getOddSemesterStDt()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide the Odd semester Start Date !!",null);
			}
			else {
				return new Response<>(HttpStatus.OK.value(),"ok",null);
			}
			}
		public Response<?> validateForAcademicSubjectAdd(AcademicSubjectEntity academicSubjectEntity){
			if(academicSubjectEntity.getAcdmSubCode()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Code!!",null);
			} 
			else if(academicSubjectEntity.getAcdmSubTitle()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Tittle!!",null);
			}
			else if(academicSubjectEntity.getFkSubTypeId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please select subject Type!!",null);
			}else {
				return new Response<>(HttpStatus.OK.value(),"ok",null);
			}
			}
		public Response<?> validateForSubjectGroupAdd(SubjectGroupEntity subjectGroupEntity){
			if(subjectGroupEntity.getFkAcademicCourseId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Course Tittle!!",null);
			} 
			else if(subjectGroupEntity.getGroupTitle()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Group Tittle!!",null);
			}
			else {
				return new Response<>(HttpStatus.OK.value(),"ok",null);
			}
			}
		public Response<?> validateForSubjectCategoryAdd(SubjectCategoryEntity subjectCategoryEntity){
			if(subjectCategoryEntity.getSubCategoryName()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Category Name!!",null);
			} 
			else if(subjectCategoryEntity.getSubType()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Type!!",null);
			}else {
				return new Response<>(HttpStatus.OK.value(),"ok",null);
			}
	}
		public Response<?> validateForSubjectMasterAdd(SubjectMasterEntity subjectMasterEntity){
			if(subjectMasterEntity.getFkAcademicSubId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject  Name!!",null);
			} 
			else if(subjectMasterEntity.getFkSubCategoryId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject category!!",null);
			}
			else if(subjectMasterEntity.getFkSubjectGroupId()==null) {
				return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Subject Group!!",null);
			}else {
				return new Response<>(HttpStatus.OK.value(),"ok",null);
			}
		}
			public Response<?> validateForGradingtittleAdd(GradingTittleEntity gradingTittleEntity){
				if(gradingTittleEntity.getGradingTitleName()==null) {
					return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide Grading Tittle  Name!!",null);
				} 
				else if(gradingTittleEntity.getStatus()==null) {
					return new Response<>(HttpStatus.BAD_REQUEST.value(),"Please provide ststus category!!",null);
				}else {
					return new Response<>(HttpStatus.OK.value(),"ok",null);
				}
	}
		
		

}
