package com.sparrow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleClassDTO {
	
	private Long scheduleClassId;
	//private Long fkScheduleDay;
	private Long fkInstituteId;
	private String startDate;
	private String endDate;
	private Long fkPeriodsId;
	private Long fkSubjectId;
	private Long fkEmployeeId;
	private String videoCall;
	private String roomNumber;
	private Boolean isActive=true;
}
