package com.sparrow.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentHeadDTO {
	
	private Long deptHeadId;
//	private Long fkFInstituteId;
	
	private Long fkFEmployeeId;
	
	private Long fkDeptId;
   

}
