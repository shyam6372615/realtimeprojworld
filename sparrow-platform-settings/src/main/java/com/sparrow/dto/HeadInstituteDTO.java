package com.sparrow.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeadInstituteDTO {
	private Long instituteHeadId;
//	private Long fkInstituteId;
	
	private Long fkEmployeeId;
	
}
