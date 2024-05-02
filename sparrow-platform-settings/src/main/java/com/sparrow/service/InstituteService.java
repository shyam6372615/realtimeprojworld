package com.sparrow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.DigitalAddrsEntity;
import com.sparrow.entity.DigitalDomainEntity;
import com.sparrow.entity.InstituteEntity;
import com.sparrow.entity.InstituteTypeEntity;
import com.sparrow.exception.NotFoundException;
import com.sparrow.exception.UpdateFailedException;
import com.sparrow.repo.CommonsRepo;
import com.sparrow.repo.DigitalAddrsRepo;
import com.sparrow.repo.DigitalDomainRepo;
import com.sparrow.repo.InstituteRepo;
import com.sparrow.repo.InstituteTypeRepo;
@Service
public class InstituteService {
	@Autowired
	private InstituteRepo instituteRepo;
	@Autowired
	private DigitalAddrsRepo digitalAddrsRepo;
	@Autowired
	private DigitalDomainRepo digitalDomainRepo;
	@Autowired
	private InstituteTypeRepo instituteTypeRepo;
	@Autowired
	private CommonsRepo commonsRepo;
	
	public InstituteEntity addInstitute(InstituteEntity instEntity) {
		InstituteEntity inst =instituteRepo.save(instEntity);
	    return inst;
	    
	}
	
	public Response<?> addDigitalAddrs(List<DigitalAddrsEntity> digitalAddrsEntity){
		try {
			List<DigitalAddrsEntity> digitalAddrsEntityData= digitalAddrsRepo.saveAll(digitalAddrsEntity);
			 return new Response<>(HttpStatus.CREATED.value(), "digital address Added Successfully!!", digitalAddrsEntityData);
			
		}catch (Exception ex) {
		    ex.printStackTrace(); 
		    return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to add digital Address: " + ex.getMessage(), null);
		}
		
	}

	public DigitalAddrsEntity updateDigitalAddrs(DigitalAddrsEntity digitalAddrsEntity){
		try {
		Optional<DigitalAddrsEntity> optional=digitalAddrsRepo.findById(digitalAddrsEntity.getDigitalAddrsId());
		if (optional.isPresent()) {
			DigitalAddrsEntity existingData=optional.get();
			existingData.setDigitalPageLink(digitalAddrsEntity.getDigitalPageLink());
			existingData.setFkDigitalDomainId(digitalAddrsEntity.getFkDigitalDomainId());
			existingData.setFkFnstituteId(digitalAddrsEntity.getFkFnstituteId());
			DigitalAddrsEntity digitalAddrsEntityData=digitalAddrsRepo.save(existingData);
			return digitalAddrsEntityData;
		} else {
		    throw new NotFoundException("DigitalAddrs with ID " +digitalAddrsEntity.getDigitalAddrsId()+ " not found");
		}
		} catch (Exception ex) {

		
		throw new UpdateFailedException("Failed to update digital addrs: " + ex.getMessage());
		}
		}
	
	public InstituteEntity updateInstitute(InstituteEntity instituteEntity){
		try {
		Optional<InstituteEntity> optional=instituteRepo.findById(instituteEntity.getInstituteId());
		if (optional.isPresent()) {
			InstituteEntity existinginstituteEntity=optional.get();
			existinginstituteEntity.setAffiliateOrg1(instituteEntity.getAffiliateOrg1());
			existinginstituteEntity.setAffiliateOrg2(instituteEntity.getAffiliateOrg2());
			existinginstituteEntity.setAffiliateOrg3(instituteEntity.getAffiliateOrg3());
			existinginstituteEntity.setAffiliateOrg4(instituteEntity.getAffiliateOrg4());
			existinginstituteEntity.setAffiliateOrg5(instituteEntity.getAffiliateOrg5());
			existinginstituteEntity.setAffiliationNo1(instituteEntity.getAffiliationNo1());
			
			existinginstituteEntity.setAffiliationNo2(instituteEntity.getAffiliationNo2());
			existinginstituteEntity.setAffiliationNo3(instituteEntity.getAffiliationNo3());
			existinginstituteEntity.setAffiliationNo4(instituteEntity.getAffiliationNo4());
			existinginstituteEntity.setAffiliationNo5(instituteEntity.getAffiliationNo5());
			existinginstituteEntity.setEmail(instituteEntity.getEmail());
			existinginstituteEntity.setFkAppUser(instituteEntity.getFkAppUser());
			existinginstituteEntity.setFkInstituteTypeId(instituteEntity.getFkInstituteTypeId());
			existinginstituteEntity.setInstAddrs(instituteEntity.getInstAddrs());
			existinginstituteEntity.setInstAffilioationDt1(instituteEntity.getInstAffilioationDt1());
			existinginstituteEntity.setInstAffilioationDt2(instituteEntity.getInstAffilioationDt2());
			existinginstituteEntity.setInstAffilioationDt3(instituteEntity.getInstAffilioationDt3());
			existinginstituteEntity.setInstAffilioationDt4(instituteEntity.getInstAffilioationDt4());
			existinginstituteEntity.setInstAffilioationDt5(instituteEntity.getInstAffilioationDt5());
			existinginstituteEntity.setInstituteIdPrefix(instituteEntity.getInstituteIdPrefix());
			existinginstituteEntity.setInstituteName(instituteEntity.getInstituteName());
			existinginstituteEntity.setInstLogo(instituteEntity.getInstLogo());
			existinginstituteEntity.setPhNo(instituteEntity.getPhNo());
			InstituteEntity instituteEntityData=instituteRepo.save(existinginstituteEntity);
			return instituteEntityData;
			
		
		} else {
		    throw new NotFoundException("Institute with ID " +instituteEntity.getInstituteId()+ " not found");
		}
		} catch (Exception ex) {

		
		throw new UpdateFailedException("Failed to update Institute: " + ex.getMessage());
		}
		}
	
	
	
	
	public List<InstituteEntity> getAllInstitute(Long UserId){
		return instituteRepo.getAllActivelist(UserId);
		
	}
	public Optional<?> getInstituteById(long id) {
		return instituteRepo.findById(id);
	}
	public List<InstituteTypeEntity> getAllInstituteType(){
		return instituteTypeRepo.getAllActivelist();
		
	}
	
	
	public Response<?> deactivateInstitute(Long id) {
	    Optional<InstituteEntity> existingInstData = instituteRepo.findById(id);

	    if (existingInstData.isPresent()) {
	    	existingInstData.get().setIsActive(false);
	    	instituteRepo.save(existingInstData.get());
	        return new Response<>(HttpStatus.OK.value(), "Institute Deactivated successfully", null);
	    } else {
	        
	        return new Response<>(HttpStatus.NOT_FOUND.value(), "Institute not found", null);
	    }
	}
	
	public List<DigitalDomainEntity> getAllDigitalDomain(){
		return digitalDomainRepo.findAll();
	}
	
	
	
}
