package com.sparrow.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.dto.AdministratorSaveDTO;
import com.sparrow.dto.ResponseData;
import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.DepartmentHeadEntity;
import com.sparrow.entity.HeadInstituteEntity;
import com.sparrow.service.AdminStratorService;

import jakarta.validation.Valid;

@RequestMapping("/sparrow/api/v1/platformsettings")
@RestController
@CrossOrigin
public class AdminStratorController {
	
	@Autowired
	private AdminStratorService adminStratorService;
	
//	@Autowired
//	private ValidationService validationService;
//	@PostMapping("/addAdministrator")
////	  public ResponseEntity<ResponseData<AdministratorEntity>> addAdministrator(@Valid @RequestBody AdministratorEntity administratorEntity){
////			
////			try {
////	 			AdministratorEntity response = adminStratorService.addAdministrator(administratorEntity);
////				return ResponseEntity.ok(new ResponseData<>(0, "Administrator added successfully", response));
////			}catch(Exception e){
////				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////		                .body(new ResponseData<>(-1, "Failed to add Administrator",null));
////				
////			}
////	}
//	
////
//	    @GetMapping("/getAllEmployee/{instituteId}")
//		public ResponseEntity<?> getAllEmployee(@PathVariable("instituteId") Long instituteId){
//			List<AdministratorEntity> list= adminStratorService.getAllEmployee(instituteId);
//			return new ResponseEntity<>(list,HttpStatus.OK);
//	}
//	    @GetMapping("/deactivate/aminstrator/{id}")
//		public ResponseEntity<?> deactivateAdminStrator(@PathVariable Long id){
//			Response<?> response=adminStratorService.deactivateAdministrator(id);
//			return new ResponseEntity<>(response,HttpStatus.OK);
//		}
////	    @GetMapping("/getAllDepartment/{instituteId}")
////		public ResponseEntity<?> getAllDepartment(@PathVariable("instituteId") long instituteId){
////			List<DepartmentEntity> list= adminStratorService.getAllDepartment(instituteId);
////			return new ResponseEntity<>(list, HttpStatus.OK);
////		}
////	    @PostMapping("/addDepartmentAdministrator")
//// public ResponseEntity<ResponseData<DepartmentAdminStratorEntity>> addDeptAdministrator(@Valid @RequestBody DepartmentAdminStratorEntity departmentAdminStratorEntity){
////			
////			try {
////				DepartmentAdminStratorEntity response = adminStratorService.addDepartmentAdministrator(departmentAdminStratorEntity);
////				return ResponseEntity.ok(new ResponseData<>(0, "DepartmentAdminStrator added successfully", response));
////			}catch(Exception e){
////				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////		                .body(new ResponseData<>(-1, "Failed to add DepartmentAdminStrator",null));
////				
////			}
////	    }
//	
//	    @GetMapping("/getAllDeptAdministrator/{instituteId}")
//		public ResponseEntity<?> getAllDeptAdministrator(@PathVariable("instituteId") Long instituteId){
//			List<DepartmentAdminStratorEntity> list= adminStratorService.getAllDepartmentAdministrator(instituteId);
//			return new ResponseEntity<>(list,HttpStatus.OK);
//	}
//	    @PutMapping("/updateDeptAdministrator")
//	    public ResponseEntity<?> updateAcademicYear(@RequestBody DepartmentAdminStratorEntity departmentAdminStratorEntity) {
//	    	DepartmentAdminStratorEntity departmentAdminStratorData = adminStratorService.updateDepartmentAdminStrator(departmentAdminStratorEntity);
//	    	if (departmentAdminStratorData != null) {
//	    		return new ResponseEntity<>(departmentAdminStratorData, HttpStatus.OK);
//	    	} else {
//	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    	}
//	    }
//
	@GetMapping("/getAllHeadOfInstitute/{instituteId}")
	public ResponseEntity<?> getAllHeadOfInstitute(@PathVariable("instituteId") Long instituteId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Page<HeadInstituteEntity> list = adminStratorService.getAllHeadOfInstitute(instituteId, page, size);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Head Of Institute not found with provioded Id", null));
		}
	}
	@GetMapping("/getAllHeadOfDepartment/{instituteId}")
	public ResponseEntity<?> getAllHeadOfDepartment(@PathVariable("instituteId") Long instituteId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Page<DepartmentHeadEntity> list = adminStratorService.getAllHeadOfDepartment(instituteId, page, size);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, "Head Of Department not found with provioded Id", null));
		}
	}
	@GetMapping("/getAllDepartment/{instituteId}")
	public ResponseEntity<?> getAllDepartment(@PathVariable("instituteId") Long instituteId) {
		List<DepartmentEntity> list = adminStratorService.getAllDepartment(instituteId);
		if (!list.isEmpty()) {
			return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseData<>(1, " Department not found with provioded Id", null));
		}
	}
	
	 @PostMapping("/addHeadOfInstAndDept")
	 public ResponseEntity<?> addHeadOfInstAndDept(@RequestBody AdministratorSaveDTO administratorSaveDTO){
		 
		 
	// try {
		  adminStratorService.addHeadOfInstAndDept(administratorSaveDTO);
		  return ResponseEntity.ok(new ResponseData<>(200, "DepartmentAdminStrator added successfully", administratorSaveDTO));
	// }
	// catch(Exception e){
	//	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
     //          .body(new ResponseData<>(500, "Failed to add DepartmentAdminStrator",null));
	//	 }
	    }
}

