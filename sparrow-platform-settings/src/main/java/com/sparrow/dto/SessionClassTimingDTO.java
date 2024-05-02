package com.sparrow.dto;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class SessionClassTimingDTO {

	
	private Long sessionId;
	
	@NotNull(message = "fkAcademicCourse cannot be null")
	@Min(value = 0, message = "fkAcademicCourse cannot be empty")
	private Long fkAcademicCourse;
	@NotNull(message = "fkClassGroups cannot be null")
	@Min(value = 0, message = "fkClassGroups cannot be empty")
	private Long fkClassGroups;
	
	@NotNull(message = "instituteId cannot be null")
	private Long instituteId;
	
	@NotNull(message = "isMon cannot be null")
	private Boolean isMon;
	
	@NotNull(message = "isTue cannot be null")
	private Boolean isTue;
	
	@NotNull(message = "isWed cannot be null")
	private Boolean isWed;
	
	@NotNull(message = "isthu cannot be null")
	private Boolean isthu;
	
	@NotNull(message = "isFri cannot be null")
	private Boolean isFri;
	
	@NotNull(message = "isSat cannot be null")
	private Boolean isSat;
	
	@NotNull(message = "isSun cannot be null")
	private Boolean isSun;
	
	@NotNull(message = "defaultDuration cannot be null")
	private String defaultDuration;
	
	@NotNull(message = "startTime cannot be null")
	private String startTime;
	
	@NotNull(message = "endTime cannot be null")
	private String endTime;
	private List<PeriodsDTO> periodsDto;
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public Long getFkClassGroups() {
		return fkClassGroups;
	}
	public void setFkClassGroups(Long fkClassGroups) {
		this.fkClassGroups = fkClassGroups;
	}
	public Long getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(Long instituteId) {
		this.instituteId = instituteId;
	}
	public Boolean getIsMon() {
		return isMon;
	}
	public void setIsMon(Boolean isMon) {
		this.isMon = isMon;
	}
	public Boolean getIsTue() {
		return isTue;
	}
	public void setIsTue(Boolean isTue) {
		this.isTue = isTue;
	}
	public Boolean getIsWed() {
		return isWed;
	}
	public void setIsWed(Boolean isWed) {
		this.isWed = isWed;
	}
	public Boolean getIsthu() {
		return isthu;
	}
	public void setIsthu(Boolean isthu) {
		this.isthu = isthu;
	}
	public Boolean getIsFri() {
		return isFri;
	}
	public void setIsFri(Boolean isFri) {
		this.isFri = isFri;
	}
	public Boolean getIsSat() {
		return isSat;
	}
	public void setIsSat(Boolean isSat) {
		this.isSat = isSat;
	}
	public Boolean getIsSun() {
		return isSun;
	}
	public void setIsSun(Boolean isSun) {
		this.isSun = isSun;
	}
	public String getDefaultDuration() {
		return defaultDuration;
	}
	public void setDefaultDuration(String defaultDuration) {
		this.defaultDuration = defaultDuration;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public List<PeriodsDTO> getPeriodsDto() {
		return periodsDto;
	}
	public void setPeriodsDto(List<PeriodsDTO> periodsDto) {
		this.periodsDto = periodsDto;
	}
}