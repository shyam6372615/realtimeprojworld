package com.sparrow.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.AdministratorSaveDTO;
import com.sparrow.dto.DepartmentHeadDTO;
import com.sparrow.dto.HeadInstituteDTO;
import com.sparrow.dto.Response;
import com.sparrow.entity.DepartmentEntity;
import com.sparrow.entity.DepartmentHeadEntity;
import com.sparrow.entity.EmployeeEntity;
import com.sparrow.entity.HeadInstituteEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.repo.DepartmentHeadRepo;
import com.sparrow.repo.DepartmentRepo;
import com.sparrow.repo.EmployeeRepo;
import com.sparrow.repo.HeadInstituteRepo;
@Service
public class AdminStratorService {
	@Autowired
	private HeadInstituteRepo headInstituteRepo;
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private DepartmentHeadRepo departmentHeadRepo;
	

	
//public AdministratorEntity addAdministrator(AdministratorEntity administratorEntity) {
//		
//		AdministratorEntity administratorData =administratorRepo.save(administratorEntity);
//		return administratorData;
	//}
	 public List<EmployeeEntity> getAllEmployee(Long instituteId){
			return employeeRepo.getAllActivelist(instituteId);
			}
	 
//	 public Response<?> deactivateAdministrator(Long id) {
//		    Optional<AdministratorEntity> existingInstData = administratorRepo.findById(id);
//
//		    if (existingInstData.isPresent()) {
//		    	existingInstData.get().setIsActive(false);
//		    	administratorRepo.save(existingInstData.get());
//		        return new Response<>(HttpStatus.OK.value(), "AdminStarator Deactivated successfully", null);
//		    } else {
//		        
//		        return new Response<>(HttpStatus.NOT_FOUND.value(), "AdminStarator not found", null);
//		    }
//		}
////	 public List<DepartmentEntity> getAllDepartment( long InstituteId){
////			return departmentRepo.getAllActivelist(InstituteId);
////			
////		}
////	 public DepartmentAdminStratorEntity addDepartmentAdministrator(DepartmentAdminStratorEntity departmentAdminStratorEntity) {
////			
////			DepartmentAdminStratorEntity departmentAdministratorEntityData =departmentAdminStratorRepo.save(departmentAdminStratorEntity);
////			return departmentAdministratorEntityData;
////		}
//	 public List<DepartmentAdminStratorEntity> getAllDepartmentAdministrator( long InstituteId){
//			return departmentAdminStratorRepo.getAllActivelist(InstituteId);
//}
//	 
//	 public DepartmentAdminStratorEntity updateDepartmentAdminStrator(DepartmentAdminStratorEntity departmentAdministratorEntity) {
//		 Optional<DepartmentAdminStratorEntity> optional=departmentAdminStratorRepo.findById(departmentAdministratorEntity.getId());
//		 try {
//				if(optional.isPresent()) {
//					DepartmentAdminStratorEntity existingDeptAdmEntityData=optional.get();
//					
//					existingDeptAdmEntityData.setDeptAdminName(departmentAdministratorEntity.getDeptAdminName());
//					existingDeptAdmEntityData.setFkStreamId(departmentAdministratorEntity.getFkStreamId());
//					existingDeptAdmEntityData.setFkDepartmentId(departmentAdministratorEntity.getFkDepartmentId());
//					DepartmentAdminStratorEntity updatedData=departmentAdminStratorRepo.save(existingDeptAdmEntityData);
//					
//					return updatedData;
//					}
//				
//	   else {
//         // Handle the case where the institute with the given ID is not found
//         throw new NotFoundException("Adminstrator with ID " + departmentAdministratorEntity.getId() + " not found");
//      }
//      } catch (Exception ex) {
//     // Handle any other exceptions
//     // You can log the exception for debugging or use custom exception handling logic
//     ex.printStackTrace();
//     throw new UpdateFailedException("Failed to update DewpartmentAdminstrator: " + ex.getMessage());
// }
//		 
//		 }
	 public Page<HeadInstituteEntity> getAllHeadOfInstitute(Long instituteId, int page, int size) {
			Pageable pageable = PageRequest.of(page, size);
			return headInstituteRepo.getAllActivelist(instituteId, pageable);
		}
	 public Page<DepartmentHeadEntity> getAllHeadOfDepartment(Long instituteId, int page, int size) {
			Pageable pageable = PageRequest.of(page, size);
			return departmentHeadRepo.getAllActivelist(instituteId, pageable);
		}
	 public List<DepartmentEntity> getAllDepartment(Long instituteId) {
			return departmentRepo.getAllActivelist(instituteId);
	 }

//	 public List<DepartmentEntity> getAllHeadOfDepartment1(Long instituteId) {
//			return departmentRepo.getAllActivelist2();
/*//		}
	 public void addHeadOfInstAndDept(HeadInstituteDTO headInstituteDTO,DepartmentHeadDTO departmentHeadDTO) {
		 HeadInstituteEntity headInstituteEntity = new HeadInstituteEntity();
		 InstituteEntity instituteEntity = new InstituteEntity();
		 instituteEntity.setInstituteId(headInstituteDTO.getFkInstituteId());
		 EmployeeEntity employeeEntity = new EmployeeEntity();
		 //employeeEntity.setEmpProfileId(headInstituteDTO.getFkEmployeeId());
		 //List<Long> fkFEmployeeId = headInstituteDTO.getFkEmployeeId();
		 
		 
		 
		 headInstituteEntity.setFkInstituteId(instituteEntity);
		 headInstituteEntity.setFkEmployeeId(employeeEntity);
		
		// HeadInstituteEntity headInstituteEntityData = headInstituteRepo.save(headInstituteEntity);
		 headInstituteRepo.save(headInstituteEntity);
		 
		 
		 DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity();
		 DepartmentEntity departmentEntity = new DepartmentEntity();
		 departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
		 
		 departmentHeadEntity.setFkFInstituteId(instituteEntity);
		 departmentHeadEntity.setFkDeptId(departmentEntity);
		 //departmentHeadEntity.setFkFEmployeeId(employeeEntity);
		 
		 
		 departmentHeadRepo.save(departmentHeadEntity);
		 */
//	 public void addHeadOfInstAndDept(HeadInstituteDTO headInstituteDTO, DepartmentHeadDTO departmentHeadDTO, MappDTO mappDTO) {
//		    HeadInstituteEntity headInstituteEntity = new HeadInstituteEntity();
//		    InstituteEntity instituteEntity = new InstituteEntity();
//		    instituteEntity.setInstituteId(headInstituteDTO.getFkInstituteId());
//
//		    // Save HeadInstituteEntity
//		    headInstituteEntity.setFkInstituteId(instituteEntity);
//		    headInstituteRepo.save(headInstituteEntity);
//
//		    // Process FkEmployeeIds
//		    for (Long fkEmployeeId : mappDTO.getFkEmployeeId()) {
//		        EmployeeEntity employeeEntity = new EmployeeEntity();
//		        employeeEntity.setEmpProfileId(fkEmployeeId);
//
//		        // Save DepartmentHeadEntity for each FkEmployeeId
//		        DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity();
//		        DepartmentEntity departmentEntity = new DepartmentEntity();
//		        departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
//		        
//		        // Set relationships
//		        departmentHeadEntity.setFkFInstituteId(instituteEntity);
//		        departmentHeadEntity.setFkDeptId(departmentEntity);
//		        departmentHeadEntity.setFkFEmployeeId(employeeEntity);
//		        
//		        departmentHeadRepo.save(departmentHeadEntity);
//		    }
//
//		    // Process FkFEmployeeIds
//		    for (Long fkFEmployeeId : mappDTO.getFkFEmployeeId()) {
//		        EmployeeEntity employeeEntity = new EmployeeEntity();
//		        employeeEntity.setEmpProfileId(fkFEmployeeId);
//
//		        // Save DepartmentHeadEntity for each FkFEmployeeId
//		        DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity();
//		        DepartmentEntity departmentEntity = new DepartmentEntity();
//		        departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
//		        
//		        // Set relationships
//		        departmentHeadEntity.setFkFInstituteId(instituteEntity);
//		        departmentHeadEntity.setFkDeptId(departmentEntity);
//		        departmentHeadEntity.setFkFEmployeeId(employeeEntity);
//		        
//		        departmentHeadRepo.save(departmentHeadEntity);
//		    }
//		}
//	 public Response<?> addHeadOfInstAndDept(AdministratorSaveDTO administratorSaveDTO) {
//		try {
//		
//		 ArrayList<HeadInstituteEntity> headInstituteEntitylist = new ArrayList<HeadInstituteEntity>();
//		 ArrayList<DepartmentHeadEntity> departmentHeadEntitylist = new ArrayList<DepartmentHeadEntity>();
//		 InstituteEntity instituteEntity = new InstituteEntity();
//		 instituteEntity.setInstituteId(administratorSaveDTO.getFkInstituteId());
//		 
//		 for(Long deleteHeadOfInstituteId:administratorSaveDTO.getDeleteHeadOfInstitute()) {
//			 Optional<HeadInstituteEntity> instituteHeadData = headInstituteRepo.getInstituteHeadById(instituteEntity.getInstituteId(),deleteHeadOfInstituteId);
//			 if(instituteHeadData.isPresent()) {
//				 HeadInstituteEntity headInstituteEntity = instituteHeadData.get();
//				 headInstituteEntity.setIsActive(false);
//				 headInstituteRepo.save(headInstituteEntity);
//			 }
//		 }
//		 
//		 for(Long deleteHeadOfDepartmentId:administratorSaveDTO.getDeleteHeadOfDepartment()) {
//			 Optional<DepartmentHeadEntity> departmentHeadData=departmentHeadRepo.getdeptHeadById(instituteEntity.getInstituteId(), deleteHeadOfDepartmentId);
//				if(departmentHeadData.isPresent()) {
//					DepartmentHeadEntity departmentHeadEntity = departmentHeadData.get();
//			        departmentHeadEntity.setIsActive(false);
//			        departmentHeadRepo.save(departmentHeadEntity);
//				}
//				
//		 }
//		 
//		 for(HeadInstituteDTO headInstituteDTO:administratorSaveDTO.getHeadInstituteDTO()) {
//		 Optional<HeadInstituteEntity> instituteHeadData = headInstituteRepo.getheadinstById(instituteEntity.getInstituteId(),headInstituteDTO.getFkEmployeeId());
//		 if(instituteHeadData.isEmpty()) {
//			 
//		 
//		 
//			 
//		 	 
//		 HeadInstituteEntity headInstituteEntity = new HeadInstituteEntity(); 
//		
//		 EmployeeEntity  employeeEntity = new EmployeeEntity();
//		 employeeEntity.setEmpProfileId(headInstituteDTO.getFkEmployeeId());
////		 instituteEntity.setInstituteId(headInstituteDTO.getFkInstituteId());
//		 headInstituteEntity.setFkEmployeeId(employeeEntity);
//		 headInstituteEntity.setFkInstituteId(instituteEntity);
//		 headInstituteEntitylist.add(headInstituteEntity);
//		return new Response<>(HttpStatus.OK.value(), "Institute Head Added Sucessfully");
//	 }
//	  else{
//		  return new Response<>(HttpStatus.NOT_FOUND.value(), "Employee Id Already Exsist", null);
//	 }
//
//		 for(DepartmentHeadDTO departmentHeadDTO:administratorSaveDTO.getDepartmentHeadDTO()) {
//			 Optional<DepartmentHeadEntity> departmentHeadData=departmentHeadRepo.getheadempById(instituteEntity.getInstituteId(),departmentHeadDTO.getFkFEmployeeId());
//    		 if(departmentHeadData.isEmpty()) {
//			
//				 
//				 
//			 
//		 DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity(); 
//		 
//		 EmployeeEntity  employeeEntity = new EmployeeEntity();
//		 DepartmentEntity departmentEntity = new DepartmentEntity();
//		
//		 employeeEntity.setEmpProfileId(departmentHeadDTO.getFkFEmployeeId());
//		 departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
//		 departmentHeadEntity.setFkFEmployeeId(employeeEntity);
//		 departmentHeadEntity.setFkFInstituteId(instituteEntity);
//		 departmentHeadEntity.setFkDeptId(departmentEntity);
//		 departmentHeadEntitylist.add(departmentHeadEntity);
//		 return new Response<>(HttpStatus.OK.value(), "Department Head Added Sucessfully");
//	 }
//			 else{
//				 return new Response<>(HttpStatus.NOT_FOUND.value(), "Employee Id Already Exsist", null);
//
//		 }
//		
//		  
//		 
//		 headInstituteRepo.saveAll(headInstituteEntitylist);
//		 departmentHeadRepo.saveAll(departmentHeadEntitylist);
//		 return new Response<>(HttpStatus.CREATED.value(), "Head Of Institute And Department Added Successfully!!", administratorSaveDTO);
//		 }catch (Exception ex) {
//				ex.printStackTrace();
//				return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
//						"Failed to add ScheduleClass: " + ex.getMessage(), null);
//			
//		 } 
//		
		 
		
		
		 
		
		
		 
		 
		 

//	 
//	 
//}
//}
//	 public String addHeadOfInstAndDept(AdministratorSaveDTO administratorSaveDTO) {
//
//		    // Initialization of lists and entities
//		    ArrayList<HeadInstituteEntity> headInstituteEntitylist = new ArrayList<>();
//		    ArrayList<DepartmentHeadEntity> departmentHeadEntitylist = new ArrayList<>();
//		    InstituteEntity instituteEntity = new InstituteEntity();
//		    instituteEntity.setInstituteId(administratorSaveDTO.getFkInstituteId());
//
//		    // Loop to handle deletion of Head of Institute
//		    for (Long deleteHeadOfInstituteId : administratorSaveDTO.getDeleteHeadOfInstitute()) {
//		        Optional<HeadInstituteEntity> instituteHeadData = headInstituteRepo.getInstituteHeadById(instituteEntity.getInstituteId(), deleteHeadOfInstituteId);
//		        if (instituteHeadData.isPresent()) {
//		            HeadInstituteEntity headInstituteEntity = instituteHeadData.get();
//		            headInstituteEntity.setIsActive(false);
//		            headInstituteRepo.save(headInstituteEntity);
//		        }
//		    }
//
//		    // Loop to handle deletion of Head of Department
//		    for (Long deleteHeadOfDepartmentId : administratorSaveDTO.getDeleteHeadOfDepartment()) {
//		        Optional<DepartmentHeadEntity> departmentHeadData = departmentHeadRepo.getdeptHeadById(instituteEntity.getInstituteId(), deleteHeadOfDepartmentId);
//		        if (departmentHeadData.isPresent()) {
//		            DepartmentHeadEntity departmentHeadEntity = departmentHeadData.get();
//		            departmentHeadEntity.setIsActive(false);
//		            departmentHeadRepo.save(departmentHeadEntity);
//		        }
//		    }
//
//		    // Start of HeadInstituteDTO block
//		    for (HeadInstituteDTO headInstituteDTO : administratorSaveDTO.getHeadInstituteDTO()) {
//		        Optional<HeadInstituteEntity> instituteHeadData = headInstituteRepo.getheadinstById(headInstituteDTO.getFkEmployeeId());
//		        if (instituteHeadData.isEmpty()) {
//		            // Your logic for handling the case when instituteHeadData is empty
//
//		        } else {
//		            return "provide Dept"; // This is where the HeadInstituteDTO's if block ends
//		        }
//
//		        // Creating new HeadInstituteEntity and related entities
//		        HeadInstituteEntity headInstituteEntity = new HeadInstituteEntity();
//		        EmployeeEntity employeeEntity = new EmployeeEntity();
//		        employeeEntity.setEmpProfileId(headInstituteDTO.getFkEmployeeId());
//		        headInstituteEntity.setFkEmployeeId(employeeEntity);
//		        headInstituteEntity.setFkInstituteId(instituteEntity);
//		        headInstituteEntitylist.add(headInstituteEntity);
//		    }
//
//		    // Loop to handle DepartmentHeadDTO
//		    for (DepartmentHeadDTO departmentHeadDTO : administratorSaveDTO.getDepartmentHeadDTO()) {
//		        Optional<DepartmentHeadEntity> departmentHeadData = departmentHeadRepo.getheadempById(departmentHeadDTO.getFkFEmployeeId());
//		        if (departmentHeadData.isEmpty()) {
//		            // Your logic for handling the case when departmentHeadData is empty
//
//		        } else {
//		            return "provide Dept";
//		        }
//
//		        // Creating new DepartmentHeadEntity and related entities
//		        DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity();
//		        EmployeeEntity employeeEntity = new EmployeeEntity();
//		        DepartmentEntity departmentEntity = new DepartmentEntity();
//		        employeeEntity.setEmpProfileId(departmentHeadDTO.getFkFEmployeeId());
//		        departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
//		        departmentHeadEntity.setFkFEmployeeId(employeeEntity);
//		        departmentHeadEntity.setFkFInstituteId(instituteEntity);
//		        departmentHeadEntity.setFkDeptId(departmentEntity);
//		        departmentHeadEntitylist.add(departmentHeadEntity);
//		    }
//
//		    // Saving entities to the repository
//		    headInstituteRepo.saveAll(headInstituteEntitylist);
//		    departmentHeadRepo.saveAll(departmentHeadEntitylist);
//
//		    return "done"; // End of the method
//		}
// one more scenario
//	 public String addHeadOfInstAndDept(AdministratorSaveDTO administratorSaveDTO) {
//
//		   
//		    ArrayList<HeadInstituteEntity> headInstituteEntitylist = new ArrayList<>();
//		    ArrayList<DepartmentHeadEntity> departmentHeadEntitylist = new ArrayList<>();
//		    InstituteEntity instituteEntity = new InstituteEntity();
//		    instituteEntity.setInstituteId(administratorSaveDTO.getFkInstituteId());
//
//		    
//		    for (Long deleteHeadOfInstituteId : administratorSaveDTO.getDeleteHeadOfInstitute()) {
//		        Optional<HeadInstituteEntity> instituteHeadData = headInstituteRepo.getInstituteHeadById(instituteEntity.getInstituteId(), deleteHeadOfInstituteId);
//		        instituteHeadData.ifPresent(headInstituteEntity -> {
//		            headInstituteEntity.setIsActive(false);
//		            headInstituteRepo.save(headInstituteEntity);
//		        });
//		    }
//
//		   
//		    for (Long deleteHeadOfDepartmentId : administratorSaveDTO.getDeleteHeadOfDepartment()) {
//		        Optional<DepartmentHeadEntity> departmentHeadData = departmentHeadRepo.getdeptHeadById(instituteEntity.getInstituteId(), deleteHeadOfDepartmentId);
//		        departmentHeadData.ifPresent(departmentHeadEntity -> {
//		            departmentHeadEntity.setIsActive(false);
//		            departmentHeadRepo.save(departmentHeadEntity);
//		        });
//		    }
//
//		
//		    for (HeadInstituteDTO headInstituteDTO : administratorSaveDTO.getHeadInstituteDTO()) {
//		        HeadInstituteEntity headInstituteEntity = new HeadInstituteEntity();
//		        EmployeeEntity employeeEntity = new EmployeeEntity();
//		        employeeEntity.setEmpProfileId(headInstituteDTO.getFkEmployeeId());
//		        headInstituteEntity.setFkEmployeeId(employeeEntity);
//		        headInstituteEntity.setFkInstituteId(instituteEntity);
//		        headInstituteEntitylist.add(headInstituteEntity);
//		    }
//
//		   
//		    for (DepartmentHeadDTO departmentHeadDTO : administratorSaveDTO.getDepartmentHeadDTO()) {
//		        DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity();
//		        EmployeeEntity employeeEntity = new EmployeeEntity();
//		        DepartmentEntity departmentEntity = new DepartmentEntity();
//		        employeeEntity.setEmpProfileId(departmentHeadDTO.getFkFEmployeeId());
//		        departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
//		        departmentHeadEntity.setFkFEmployeeId(employeeEntity);
//		        departmentHeadEntity.setFkFInstituteId(instituteEntity);
//		        departmentHeadEntity.setFkDeptId(departmentEntity);
//		        departmentHeadEntitylist.add(departmentHeadEntity);
//		    }
//
//		    
//		    headInstituteRepo.saveAll(headInstituteEntitylist);
//		    departmentHeadRepo.saveAll(departmentHeadEntitylist);
//
//		    return "done"; // End of the method
//		}
//	 
//	 public Response<?> addHeadOfInstAndDept(AdministratorSaveDTO administratorSaveDTO) {
////		    try {
//		        ArrayList<HeadInstituteEntity> headInstituteEntitylist = new ArrayList<>();
//		        ArrayList<DepartmentHeadEntity> departmentHeadEntitylist = new ArrayList<>();
//		        InstituteEntity instituteEntity = new InstituteEntity();
//		        instituteEntity.setInstituteId(administratorSaveDTO.getFkInstituteId());
//
//		        for (Long deleteHeadOfInstituteId : administratorSaveDTO.getDeleteHeadOfInstitute()) {
//		            Optional<HeadInstituteEntity> instituteHeadData = headInstituteRepo.getInstituteHeadById(instituteEntity.getInstituteId(), deleteHeadOfInstituteId);
//		            if (instituteHeadData.isPresent()) {
//		                HeadInstituteEntity headInstituteEntity = instituteHeadData.get();
//		                headInstituteEntity.setIsActive(false);
//		                headInstituteRepo.save(headInstituteEntity);
//		            }
//		        }
//
//		        for (Long deleteHeadOfDepartmentId : administratorSaveDTO.getDeleteHeadOfDepartment()) {
//		            Optional<DepartmentHeadEntity> departmentHeadData = departmentHeadRepo.getdeptHeadById(instituteEntity.getInstituteId(), deleteHeadOfDepartmentId);
//		            if (departmentHeadData.isPresent()) {
//		                DepartmentHeadEntity departmentHeadEntity = departmentHeadData.get();
//		                departmentHeadEntity.setIsActive(false);
//		                departmentHeadRepo.save(departmentHeadEntity);
//		            }
//		        }
//
//		        for (HeadInstituteDTO headInstituteDTO : administratorSaveDTO.getHeadInstituteDTO()) {
//		            Optional<HeadInstituteEntity> instituteHeadData = headInstituteRepo.getheadinstById(instituteEntity.getInstituteId(), headInstituteDTO.getFkEmployeeId());
//		            if (instituteHeadData.isEmpty()) {
//		                HeadInstituteEntity headInstituteEntity = new HeadInstituteEntity();
//		                EmployeeEntity employeeEntity = new EmployeeEntity();
//		                employeeEntity.setEmpProfileId(headInstituteDTO.getFkEmployeeId());
//		                headInstituteEntity.setFkEmployeeId(employeeEntity);
//		                headInstituteEntity.setFkInstituteId(instituteEntity);
//		                headInstituteEntitylist.add(headInstituteEntity);
//		                return new Response<>(HttpStatus.OK.value(), "Institute Head Added Successfully");
//		            } else {
//		                return new Response<>(HttpStatus.NOT_FOUND.value(), "Employee ID Already Exists", null);
//		            }
//		        }
//
//		        for (DepartmentHeadDTO departmentHeadDTO : administratorSaveDTO.getDepartmentHeadDTO()) {
//		            Optional<DepartmentHeadEntity> departmentHeadData = departmentHeadRepo.getheadempById(instituteEntity.getInstituteId(), departmentHeadDTO.getFkFEmployeeId());
//		            if (departmentHeadData.isEmpty()) {
//		                DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity();
//		                EmployeeEntity employeeEntity = new EmployeeEntity();
//		                DepartmentEntity departmentEntity = new DepartmentEntity();
//		                employeeEntity.setEmpProfileId(departmentHeadDTO.getFkFEmployeeId());
//		                departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
//		                departmentHeadEntity.setFkFEmployeeId(employeeEntity);
//		                departmentHeadEntity.setFkFInstituteId(instituteEntity);
//		                departmentHeadEntity.setFkDeptId(departmentEntity);
//		                departmentHeadEntitylist.add(departmentHeadEntity);
//		                return new Response<>(HttpStatus.OK.value(), "Department Head Added Successfully");
//		            } else {
//		                return new Response<>(HttpStatus.NOT_FOUND.value(), "Employee ID Already Exists", null);
//		            }
//		        }
//
//		        headInstituteRepo.saveAll(headInstituteEntitylist);
//		        departmentHeadRepo.saveAll(departmentHeadEntitylist);
////		        return new Response<>(HttpStatus.CREATED.value(), "Head Of Institute And Department Added Successfully!!", administratorSaveDTO);
//				return null;
//	 
////		    } catch (Exception ex) {
////		        ex.printStackTrace();
////		        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to add ScheduleClass: " + ex.getMessage(), null);
////		    }
//		}
/*
 * public String addHeadOfInstAndDept(AdministratorSaveDTO administratorSaveDTO)
 * {
 * 
 * 
 * ArrayList<HeadInstituteEntity> headInstituteEntitylist = new
 * ArrayList<HeadInstituteEntity>(); ArrayList<DepartmentHeadEntity>
 * departmentHeadEntitylist = new ArrayList<DepartmentHeadEntity>();
 * InstituteEntity instituteEntity = new InstituteEntity();
 * instituteEntity.setInstituteId(administratorSaveDTO.getFkInstituteId());
 * 
 * for(Long
 * deleteHeadOfInstituteId:administratorSaveDTO.getDeleteHeadOfInstitute()) {
 * Optional<HeadInstituteEntity> instituteHeadData =
 * headInstituteRepo.getInstituteHeadById(instituteEntity.getInstituteId(),
 * deleteHeadOfInstituteId); if(instituteHeadData.isPresent()) {
 * HeadInstituteEntity headInstituteEntity = instituteHeadData.get();
 * headInstituteEntity.setIsActive(false);
 * headInstituteRepo.save(headInstituteEntity); } }
 * 
 * for(Long
 * deleteHeadOfDepartmentId:administratorSaveDTO.getDeleteHeadOfDepartment()) {
 * Optional<DepartmentHeadEntity>
 * departmentHeadData=departmentHeadRepo.getdeptHeadById(instituteEntity.
 * getInstituteId(), deleteHeadOfDepartmentId);
 * if(departmentHeadData.isPresent()) { DepartmentHeadEntity
 * departmentHeadEntity = departmentHeadData.get();
 * departmentHeadEntity.setIsActive(false);
 * departmentHeadRepo.save(departmentHeadEntity); }
 * 
 * }
 * 
 * for(HeadInstituteDTO
 * headInstituteDTO:administratorSaveDTO.getHeadInstituteDTO()) {
 * Optional<HeadInstituteEntity> instituteHeadData =
 * headInstituteRepo.getheadinstById(instituteEntity.getInstituteId(),
 * headInstituteDTO.getFkEmployeeId()); if(instituteHeadData.isEmpty()) {
 * 
 * 
 * 
 * 
 * 
 * HeadInstituteEntity headInstituteEntity = new HeadInstituteEntity();
 * 
 * EmployeeEntity employeeEntity = new EmployeeEntity();
 * employeeEntity.setEmpProfileId(headInstituteDTO.getFkEmployeeId()); //
 * instituteEntity.setInstituteId(headInstituteDTO.getFkInstituteId());
 * headInstituteEntity.setFkEmployeeId(employeeEntity);
 * headInstituteEntity.setFkInstituteId(instituteEntity);
 * headInstituteEntitylist.add(headInstituteEntity); } else{ return
 * "Employee Id already Exsist"; }
 * 
 * for(DepartmentHeadDTO
 * departmentHeadDTO:administratorSaveDTO.getDepartmentHeadDTO()) {
 * Optional<DepartmentHeadEntity>
 * departmentHeadData=departmentHeadRepo.getheadempById(instituteEntity.
 * getInstituteId(),departmentHeadDTO.getFkFEmployeeId());
 * if(departmentHeadData.isEmpty()) {
 * 
 * 
 * 
 * 
 * DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity();
 * 
 * EmployeeEntity employeeEntity = new EmployeeEntity(); DepartmentEntity
 * departmentEntity = new DepartmentEntity();
 * 
 * employeeEntity.setEmpProfileId(departmentHeadDTO.getFkFEmployeeId());
 * departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
 * departmentHeadEntity.setFkFEmployeeId(employeeEntity);
 * departmentHeadEntity.setFkFInstituteId(instituteEntity);
 * departmentHeadEntity.setFkDeptId(departmentEntity);
 * departmentHeadEntitylist.add(departmentHeadEntity); } else{ return
 * "Employee Id already Exsist";
 * 
 * }
 * 
 * 
 * 
 * headInstituteRepo.saveAll(headInstituteEntitylist);
 * departmentHeadRepo.saveAll(departmentHeadEntitylist); }
 * 
 * } return "done"; }
 */
	 
	 public String addHeadOfInstAndDept(AdministratorSaveDTO administratorSaveDTO) {
		    ArrayList     <HeadInstituteEntity> headInstituteEntitylist = new ArrayList<>();
		    ArrayList      <DepartmentHeadEntity> departmentHeadEntitylist = new ArrayList<>();
		    InstituteEntity instituteEntity = new InstituteEntity();
		    instituteEntity.setInstituteId(administratorSaveDTO.getFkInstituteId());
		    
		    // Check if any of the provided deleteHeadOfInstituteId is already present in the database with isActive as 0
		    for (Long deleteHeadOfInstituteId : administratorSaveDTO.getDeleteHeadOfInstitute()) {
		        Optional         <HeadInstituteEntity> instituteHeadData = headInstituteRepo.getInstituteHeadById(instituteEntity.getInstituteId(), deleteHeadOfInstituteId);
		        if (instituteHeadData.isPresent() ) {
		            return "One of the provided deleteHeadOfInstituteId is already present in the database with isActive as 0. No changes made.";
		        }
		    }

		    // Check if any of the provided deleteHeadOfDepartmentId is already present in the database with isActive as 0
		    for (Long deleteHeadOfDepartmentId : administratorSaveDTO.getDeleteHeadOfDepartment()) {
		        Optional         <DepartmentHeadEntity> departmentHeadData = departmentHeadRepo.getdeptHeadById(instituteEntity.getInstituteId(), deleteHeadOfDepartmentId);
		        if (departmentHeadData.isPresent() ) {
		            return "One of the provided deleteHeadOfDepartmentId is already present in the database with isActive as 0. No changes made.";
		        }
		    }

		    // Check if any of the provided head institute or department employee IDs are already present in the database with isActive as 0
		    for (HeadInstituteDTO headInstituteDTO : administratorSaveDTO.getHeadInstituteDTO()) {
		        Optional         <HeadInstituteEntity> instituteHeadData = headInstituteRepo.getheadinstById(instituteEntity.getInstituteId(), headInstituteDTO.getFkEmployeeId());
		        if (instituteHeadData.isPresent() ) {
		            return "One of the provided head institute employee IDs is already present in the database with isActive as 0. No changes made.";
		        }
		    }

		    for (DepartmentHeadDTO departmentHeadDTO : administratorSaveDTO.getDepartmentHeadDTO()) {
		        Optional         <DepartmentHeadEntity> departmentHeadData = departmentHeadRepo.getheadempById(instituteEntity.getInstituteId(), departmentHeadDTO.getFkFEmployeeId());
		        if (departmentHeadData.isPresent() ) {
		            return "One of the provided department head employee IDs is already present in the database with isActive as 0. No changes made.";
		        }
		    }

		    // If no inactive employee IDs found, proceed with saving

		    // Continue the existing logic of adding new head institute and department heads

		    for (HeadInstituteDTO headInstituteDTO : administratorSaveDTO.getHeadInstituteDTO()) {
		        Optional         <HeadInstituteEntity> instituteHeadData = headInstituteRepo.getheadinstById(instituteEntity.getInstituteId(), headInstituteDTO.getFkEmployeeId());
		        if (instituteHeadData.isEmpty()) {
		            HeadInstituteEntity headInstituteEntity = new HeadInstituteEntity();
		            EmployeeEntity  employeeEntity = new EmployeeEntity();
		            employeeEntity.setEmpProfileId(headInstituteDTO.getFkEmployeeId());
		            headInstituteEntity.setFkEmployeeId(employeeEntity);
		            headInstituteEntity.setFkInstituteId(instituteEntity);
		            headInstituteEntitylist.add(headInstituteEntity);
		        } else {
		            return "Employee ID already exists";
		        }
		    }

		    for (DepartmentHeadDTO departmentHeadDTO : administratorSaveDTO.getDepartmentHeadDTO()) {
		        Optional         <DepartmentHeadEntity> departmentHeadData = departmentHeadRepo.getheadempById(instituteEntity.getInstituteId(), departmentHeadDTO.getFkFEmployeeId());
		        if (departmentHeadData.isEmpty()) {
		            DepartmentHeadEntity departmentHeadEntity = new DepartmentHeadEntity();
		            EmployeeEntity  employeeEntity = new EmployeeEntity();
		            DepartmentEntity departmentEntity = new DepartmentEntity();
		            employeeEntity.setEmpProfileId(departmentHeadDTO.getFkFEmployeeId());
		            departmentEntity.setDepartmentId(departmentHeadDTO.getFkDeptId());
		            departmentHeadEntity.setFkFEmployeeId(employeeEntity);
		            departmentHeadEntity.setFkFInstituteId(instituteEntity);
		            departmentHeadEntity.setFkDeptId(departmentEntity);
		            departmentHeadEntitylist.add(departmentHeadEntity);
		        } else {
		            return "Employee ID already exists";
		        }
		    }

		    headInstituteRepo.saveAll(headInstituteEntitylist);
		    departmentHeadRepo.saveAll(departmentHeadEntitylist);
		    return "done";
		}



}	




