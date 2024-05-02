package com.sparrow.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionalSettingsSaveDTO {
private Long Id;
private RegionalSettingsDTO regionalSeetingsDTO;
private List<ActiveModuleRegionalMappingDTO> activeModuleRegionalMappingDTO;
private List<PersonalizeLabelDTO> personalizeLabelDTO;

}
