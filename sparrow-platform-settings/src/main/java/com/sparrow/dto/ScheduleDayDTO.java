package com.sparrow.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDayDTO {
	
	private Long scheduleDayId;
	private Long fkInstituteId;
	private String scheduleDayName;
	private Long fkAcademicCourse;
	private Boolean isActive=true;
	//private List<ScheduleClassDTO> scheduleClassDTO;
//	private List<PeriodsDTO> periodsDTO;

	
}
