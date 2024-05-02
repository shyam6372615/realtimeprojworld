package com.sparrow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalizeLabelDTO {
	private Long personalizeLabelId;
	private Long fkInstituteId;
	private String defaultLevelName;
	private String customLabelName;
	private Boolean isActive=true;


}
