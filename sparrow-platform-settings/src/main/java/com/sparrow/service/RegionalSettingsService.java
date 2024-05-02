package com.sparrow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparrow.entity.ActiveModuleEntity;
import com.sparrow.entity.ActiveModuleRegionalMappingEntity;
import com.sparrow.entity.RegionalSettingsEntity;
import com.sparrow.repo.ActiveModuleRegionalMappingRepo;
import com.sparrow.repo.ActiveModuleRepo;
import com.sparrow.repo.RegionalSettingsRepo;

@Service
public class RegionalSettingsService {
	@Autowired
private RegionalSettingsRepo regionalSettingsRepo;
	@Autowired
	private ActiveModuleRepo activeModuleRepo;
	@Autowired
	private ActiveModuleRegionalMappingRepo activeModuleRegionalMappingRepo;

public RegionalSettingsEntity addRegionalSeetings(RegionalSettingsEntity regionalSettingsEntity) {
	RegionalSettingsEntity rgnstng =regionalSettingsRepo.save(regionalSettingsEntity);
    return rgnstng;
    
   
}
public ActiveModuleEntity getAllActiveModuleById(Long instituteId,Long packageId,Long modId){
	return activeModuleRepo.getAllActiveModuleById(instituteId,packageId,modId);
	
}
public List<ActiveModuleEntity> getAllActiveModule(Long instituteId){
	return activeModuleRepo.getAllActiveList(instituteId);
	
}
public List<ActiveModuleRegionalMappingEntity> addActiveModule(List<ActiveModuleRegionalMappingEntity> activeModuleRegionalMappingEntity) {
	List<ActiveModuleRegionalMappingEntity> actvrgnstng =activeModuleRegionalMappingRepo.saveAll(activeModuleRegionalMappingEntity);
    return actvrgnstng;
}
}
