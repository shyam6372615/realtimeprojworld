package com.sparrow.Controller;

import java.util.ArrayList;
import java.util.List;

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

import com.sparrow.dto.ActiveModuleRegionalMappingDTO;
import com.sparrow.dto.PersonalizeLabelDTO;
import com.sparrow.dto.RegionalSettingsDTO;
import com.sparrow.dto.RegionalSettingsSaveDTO;
import com.sparrow.dto.Response;
import com.sparrow.dto.ResponseData;
import com.sparrow.entity.ActiveModuleEntity;
import com.sparrow.entity.ActiveModuleRegionalMappingEntity;
import com.sparrow.entity.CommonsDataEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.PersonalizeLabelEntity;
import com.sparrow.entity.RegionalSettingsEntity;
import com.sparrow.service.PersonalizeLabelService;
import com.sparrow.service.RegionalSettingsService;

@RequestMapping("/sparrow")
@RestController
@CrossOrigin(origins ="*")
public class RegionalController {
    @Autowired
	private RegionalSettingsService regionalSettingService;
    
    @Autowired
    private PersonalizeLabelService personalizeLabelService;
    
   

	
    
    @PostMapping("/addRegionalSettings")
//	public ResponseEntity<ResponseData<RegionalSettingsEntity>> addRegionalSettings( @RequestBody RegionalSettingsSaveDTO  regionalSettingsSaveDTO){
//  //   try {
//		ArrayList<PersonalizeLabelEntity> personalizeLabelEntityList=new ArrayList<PersonalizeLabelEntity>();
//		RegionalSettingsEntity regionalSettingsEntity=new RegionalSettingsEntity() ;
//		RegionalSettingsDTO regionalSettingsDTO=regionalSettingsSaveDTO.getRegionalSeetingsDTO();
//		CommonsDataEntity commonsDataEntity=new CommonsDataEntity();
//		commonsDataEntity.setId(regionalSettingsDTO.getFkCountryId());
//		CommonsDataEntity commonsDataEntity1=new CommonsDataEntity();
//		commonsDataEntity1.setId(regionalSettingsDTO.getFkDateformatId());
//		CommonsDataEntity commonsDataEntity2=new CommonsDataEntity();
//		commonsDataEntity2.setId(regionalSettingsDTO.getFkColourCodeId());
//		CommonsDataEntity commonsDataEntity3=new CommonsDataEntity();
//		commonsDataEntity3.setId(regionalSettingsDTO.getFkLanguageId());
//		CommonsDataEntity commonsDataEntity4=new CommonsDataEntity();
//		commonsDataEntity4.setId(regionalSettingsDTO.getFkTimeformatId());
//		CommonsDataEntity commonsDataEntity5=new CommonsDataEntity();
//		commonsDataEntity5.setId(regionalSettingsDTO.getFkTimezoneId());
//		
//		//ActiveModuleEntity activeModuleEntity=new ActiveModuleEntity();
//		//activeModuleEntity.setActiveModuleId(regionalSettingsDTO.getActivemoduleid());
//		//activeModuleEntity.setActiveModuleId(regionalSettingsDTO.getFkActiveModuleId());
//		InstituteEntity instituteEntity=new InstituteEntity();
//		instituteEntity.setInstituteId(regionalSettingsDTO.getInstituteId());
//		regionalSettingsEntity.setInstituteId(instituteEntity);
//		
//	    regionalSettingsEntity.setFkColourCodeId(commonsDataEntity2);
//	    regionalSettingsEntity.setFkCountryId(commonsDataEntity);
//	    regionalSettingsEntity.setFkDateformatId(commonsDataEntity1);
//	    regionalSettingsEntity.setFkLanguageId(commonsDataEntity3);
//	    regionalSettingsEntity.setFkTimeformatId(commonsDataEntity4);
//	    regionalSettingsEntity.setFkTimezoneId(commonsDataEntity5);
//	   // regionalSettingsEntity.setFkActiveModuleId(activeModuleEntity);
//	    regionalSettingsEntity.setRtlMode(regionalSettingsDTO.getRtlMode());
//	    RegionalSettingsEntity regionalSettingsEntityData=regionalSettingService.addRegionalSeetings(regionalSettingsEntity);
//	    
//	    
//	    
//	    ActiveModuleRegionalMappingEntity activeModuleRegionalMappingEntity=new ActiveModuleRegionalMappingEntity();
//	    activeModuleRegionalMappingEntity.setFkInstituteId(instituteEntity);
//	    activeModuleRegionalMappingEntity.setFkRegionalSettingsId(regionalSettingsEntityData);
//	    ArrayList<ActiveModuleRegionalMappingEntity> activeModuleRegionalMappingEntityList=new ArrayList<ActiveModuleRegionalMappingEntity>();
//	    
////	    for(ActiveModuleRegionalMappingDTO activeModuleRegionalMappingDTO:regionalSettingsDTO.getFkActiveModuleId()) {
//	    	ActiveModuleEntity activeModuleEntity=new ActiveModuleEntity();
//	    	activeModuleEntity.setActiveModuleId(activeModuleRegionalMappingDTO.getFKActiveModuleId());
//	    	activeModuleRegionalMappingEntity.setFkActiveModuleId(activeModuleEntity);
//	    	activeModuleRegionalMappingEntityList.add(activeModuleRegionalMappingEntity);
//	    	
//	    }
//	    
//		for(PersonalizeLabelDTO personalizeLabelDTO:regionalSettingsSaveDTO.getPersonalizeLabelDTO()) {
//			
//			
//			
//			PersonalizeLabelEntity personalizeLabelEntity=new PersonalizeLabelEntity();
//			personalizeLabelEntity.setFkInstituteId(instituteEntity);
//			personalizeLabelEntity.setDefaultLevelName(personalizeLabelDTO.getDefaultLevelName());
//			personalizeLabelEntity.setCustomLabelName(personalizeLabelDTO.getCustomLabelName());
//			personalizeLabelEntityList.add(personalizeLabelEntity);
//		}
//		
//		personalizeLabelService.addPersonalizeLabel(personalizeLabelEntityList);
//		regionalSettingService.addActiveModule(activeModuleRegionalMappingEntityList);
//		return ResponseEntity.ok(new ResponseData<>(0, "Regional Setting added successfully", regionalSettingsEntityData));
//   //  }catch(Exception e){
//			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//           //        .body(new ResponseData<>(-1, "Failed to add Regional Setting", null));
//			
//	    
////}   
//}
    
    @GetMapping("/deactivate/PersonalizeLabel/{id}")
    public ResponseEntity<?> deactivatePesonalizeLabel(@PathVariable Long id){
    	Response<?> response=personalizeLabelService.deactivatePesonalizeLabel(id);
    	return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/getAllActiveModuleById/{instituteId}/{packageId}/{modId}")
    public ResponseEntity<?> getAllActiveModuleById(@PathVariable("instituteId") Long instituteId,@PathVariable("packageId") Long packageId,@PathVariable("modId") Long modId){
    ActiveModuleEntity activeModuleData= regionalSettingService.getAllActiveModuleById(instituteId,packageId,modId);
    	if(activeModuleData!=null) {
            return ResponseEntity.ok(new ResponseData<>(0, "Success", activeModuleData));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseData<>(1, "ActiveModule not found with provioded Id", null));
        }
    }
    @GetMapping("getAllActiveModule/{instituteId}")
    public ResponseEntity<?> getAllActiveModule(@PathVariable("instituteId") Long instituteId) {
    	List<ActiveModuleEntity> response = regionalSettingService.getAllActiveModule(instituteId);
    	if(!response.isEmpty()) {
            return ResponseEntity.ok(new ResponseData<>(0, "Success", response));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseData<>(1, "Module not found with provioded Id", null));
        }
    }
}

