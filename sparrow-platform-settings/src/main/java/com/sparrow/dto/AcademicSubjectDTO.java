package com.sparrow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AcademicSubjectDTO {
	
	private Long acdmSubId;
    private String acdmSubTitle;
    private String acdmSubCode;

}
