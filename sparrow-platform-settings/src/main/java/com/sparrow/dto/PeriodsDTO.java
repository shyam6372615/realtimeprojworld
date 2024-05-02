package com.sparrow.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodsDTO {
	
	private Long periodId;
	@NotNull(message = "instituteId cannot be null")
	private Long fkInstituteId;
//	@NotNull(message = "scheduleClassId cannot be null")
//	private Long fkScheduleDay;
	@NotNull(message = "slotName cannot be null")
	private String slotName;
	@NotNull(message = "startTime cannot be null")
	private String startTime;
	@NotNull(message = "endTime cannot be null")
	private String endTime;
	
}