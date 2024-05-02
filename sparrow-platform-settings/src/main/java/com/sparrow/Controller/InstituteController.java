package com.sparrow.Controller;

 import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sparrow.dto.DigitalAddrsDTO;
import com.sparrow.dto.InstituteDTO;
import com.sparrow.dto.InstituteSaveDTO;
import com.sparrow.dto.Response;
import com.sparrow.dto.ResponseData;
import com.sparrow.entity.AppUser;
import com.sparrow.entity.DigitalAddrsEntity;
import com.sparrow.entity.DigitalDomainEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.InstituteTypeEntity;
import com.sparrow.service.InstituteService;

import jakarta.validation.Valid;
@RequestMapping("/sparrow/api/v1/platformsettings")
@RestController
@CrossOrigin(origins ="*")
public class InstituteController {
	@Autowired
	private InstituteService instituteService;
	
	@PostMapping("/addInstitute")
	public ResponseEntity<ResponseData<InstituteEntity>> addInstitute(@Valid @RequestBody InstituteSaveDTO  instituteSaveDTO){
		try {
		ArrayList<DigitalAddrsEntity> digitalAddrsEntityList=new ArrayList<DigitalAddrsEntity>();
		InstituteEntity instituteEntity = new InstituteEntity();
		InstituteDTO instituteDTO=instituteSaveDTO.getInstituteDTO();
		InstituteTypeEntity instituteTypeEntity = new InstituteTypeEntity();
		instituteTypeEntity.setInstituteTypeId(instituteDTO.getFkInstituteTypeId());
		
		instituteEntity.setAffiliateOrg1(instituteDTO.getAffiliateOrg1());
		instituteEntity.setAffiliateOrg2(instituteDTO.getAffiliateOrg2());
		instituteEntity.setAffiliateOrg3(instituteDTO.getAffiliateOrg3());
		instituteEntity.setAffiliateOrg4(instituteDTO.getAffiliateOrg4());
		instituteEntity.setAffiliateOrg5(instituteDTO.getAffiliateOrg5());
		instituteEntity.setAffiliationNo1(instituteDTO.getAffiliationNo1());
		instituteEntity.setAffiliationNo2(instituteDTO.getAffiliationNo2());
		instituteEntity.setAffiliationNo3(instituteDTO.getAffiliationNo3());
		instituteEntity.setAffiliationNo4(instituteDTO.getAffiliationNo4());
		instituteEntity.setAffiliationNo5(instituteDTO.getAffiliationNo5());
		instituteEntity.setEmail(instituteDTO.getEmail());
		
		instituteEntity.setFkInstituteTypeId(instituteTypeEntity);
		instituteEntity.setInstAddrs(instituteDTO.getInstAddrs());
		instituteEntity.setInstAffilioationDt1(instituteDTO.getInstAffilioationDt1());
		instituteEntity.setInstAffilioationDt2(instituteDTO.getInstAffilioationDt2());
		instituteEntity.setInstAffilioationDt3(instituteDTO.getInstAffilioationDt3());
		instituteEntity.setInstAffilioationDt5(instituteDTO.getInstAffilioationDt5());
		instituteEntity.setInstituteIdPrefix(instituteDTO.getInstituteIdPrefix());
		instituteEntity.setInstituteName(instituteDTO.getInstituteName());
		instituteEntity.setInstLogo(instituteDTO.getInstLogo());
		instituteEntity.setPhNo(instituteDTO.getPhNo());
		AppUser appuser=new AppUser();
		appuser.setId(instituteDTO.getAppUserId());
		instituteEntity.setFkAppUser(appuser);
		InstituteEntity instituteEntityData=instituteService.addInstitute(instituteEntity);
		
		
		
		for(DigitalAddrsDTO digitalAddrsDTO:instituteSaveDTO.getDigitalAddrsDTO()) {
			DigitalDomainEntity digitalDomainEntity=new DigitalDomainEntity();
			digitalDomainEntity.setDomain_id(digitalAddrsDTO.getFkDigitalDomainId());
			
			DigitalAddrsEntity  digitalAddrsEntity=new DigitalAddrsEntity();
			digitalAddrsEntity.setDigitalPageLink(digitalAddrsDTO.getDigitalPageLink());
			digitalAddrsEntity.setFkDigitalDomainId(digitalDomainEntity);
			digitalAddrsEntity.setFkFnstituteId(instituteEntityData);
			digitalAddrsEntityList.add(digitalAddrsEntity);
			
		}
		instituteService.addDigitalAddrs(digitalAddrsEntityList);
		 return ResponseEntity.ok(new ResponseData<>(0, "Institute added successfully", instituteEntityData));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseData<>(-1, "Failed to add Institute", null));
			
		}
		
		
		
	}
	
/*	 @PostMapping
	    public ResponseEntity<ResponseData<User>> addUser(@RequestBody User user) {
	        try {
	            User savedUser = userService.addUser(user);
	            return ResponseEntity.ok(new ResponseData<>(1, "User added successfully", savedUser));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(new ResponseData<>(-1, e.getMessage(), null));
	        }
	    }*/
	
	@GetMapping("/getAllInstitute/{userId}")// to do it will retrieve all data through user admin basis
	public ResponseEntity<ResponseData<List<InstituteEntity>>> getAllInstitute(@PathVariable("userId") long userId){
		try {
		List<InstituteEntity> list= instituteService.getAllInstitute(userId);
	
            return ResponseEntity.ok(new ResponseData<>(0, "Success", list));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseData<>(1, "institute not found with provioded userId", null));
        }
		
	}
	@GetMapping("/getInstituteById/{id}")
	public ResponseEntity<ResponseData<InstituteEntity>> getInstituteById(@PathVariable("id") long instituteId) {
		Optional<?> instituteData = instituteService.getInstituteById(instituteId);
		InstituteEntity institute=(InstituteEntity) instituteData.get();
		 if (institute != null) {
	            return ResponseEntity.ok(new ResponseData<>(0, "Success", institute));
	        } else {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
	        }
	}
	@GetMapping("/deactivate/institute/{id}")
	public ResponseEntity<?> deactivateInstitute(@PathVariable Long id){
		Response<?> response=instituteService.deactivateInstitute(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/getAllDigitalDomain")
	public ResponseEntity<?> getAllDigitalDomain(){
		List<DigitalDomainEntity> list= instituteService.getAllDigitalDomain();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getAllInstituteType")
	public ResponseEntity<?> getAllInstituteType(){
		List<InstituteTypeEntity> list= instituteService.getAllInstituteType();
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	

}
