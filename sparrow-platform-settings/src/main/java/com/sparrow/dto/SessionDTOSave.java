package com.sparrow.dto;

import java.util.List;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTOSave {
	private Long id;
	@Valid
	private ScheduleDayDTO scheduleDayDTO;
	private List<PeriodsDTO> periodsDTO;

}
