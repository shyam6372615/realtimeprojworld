package com.sparrow.dto;

import java.util.List;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class InstituteSaveDTO {
	
	private Long Id;
	@Valid
	private InstituteDTO instituteDTO;
	private List<DigitalAddrsDTO> digitalAddrsDTO;

}
