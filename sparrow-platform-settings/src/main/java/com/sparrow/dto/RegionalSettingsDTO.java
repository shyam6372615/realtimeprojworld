package com.sparrow.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionalSettingsDTO {
	private Long instituteId;
	private Long regionalSettingId;
	private Long fkCountryId;
	private Long fkLanguageId;
	private Long fkTimezoneId;
	private Long fkTimeformatId;
	private Long fkDateformatId;
	
//	private List<ActiveModuleRegionalMappingDTO> fkActiveModuleId;
	private Boolean rtlMode;
	private Long fkColourCodeId;
	private Boolean isActive=true;


}
