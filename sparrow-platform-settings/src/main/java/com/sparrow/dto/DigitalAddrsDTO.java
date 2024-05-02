package com.sparrow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DigitalAddrsDTO {
	
    private Long digitalAddrsId;
	private Long fkFnstituteId;
	private Long fkDigitalDomainId;
	private String digitalPageLink;
	private Boolean isActive=true;

}
