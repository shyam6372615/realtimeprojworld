package com.sparrow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sparrow.dto.Response;
import com.sparrow.entity.PersonalizeLabelEntity;
import com.sparrow.repo.PersonalizeLabelRepo;

@Service
public class PersonalizeLabelService {
	@Autowired
	private PersonalizeLabelRepo personalizeLabelRepo;

	public List<PersonalizeLabelEntity> addPersonalizeLabel(List<PersonalizeLabelEntity> personalizeLabelEntity){
		
			List<PersonalizeLabelEntity> personalizeLabelEntityData= personalizeLabelRepo.saveAll(personalizeLabelEntity);
			 return personalizeLabelEntityData;
			
		}
		
	 public Response<?> deactivatePesonalizeLabel(Long id) {
		    Optional<PersonalizeLabelEntity> existingPersonalizeLabelData = personalizeLabelRepo.findById(id);

		    if (existingPersonalizeLabelData.isPresent()) {
		    	existingPersonalizeLabelData.get().setIsActive(false);
		    	personalizeLabelRepo.save(existingPersonalizeLabelData.get());
		        return new Response<>(HttpStatus.OK.value(), "Personalize Label Deactivated successfully", null);
		    } else {
		        
		        return new Response<>(HttpStatus.NOT_FOUND.value(), " Personalize Label   not found", null);
		    }
		}
	
}
