package com.sparrow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "spr_sessions_class_timing")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionClassTimingEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="session_id")
	private Long sessionId;
	@OneToOne
	@JoinColumn(name="fk_class_groups_id")
	private ClassGroupEntity fkClassGroups;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteId;
	@Column(name="is_monday")
	private Boolean isMon;
	@Column(name="is_tuesday")
	private Boolean isTue;
	@Column(name="is_wednessday")
	private Boolean isWed;
	@Column(name="is_thursday")
	private Boolean isthu;
	@Column(name="is_friday")
	private Boolean isFri;
	@Column(name="is_saturday")
	private Boolean isSat;
	@Column(name="is_sunday")
	private Boolean isSun;
	@Column(name="default_duration")
	private String defaultDuration;
	@Column(name="start_time")
	private String startTime;
	@Column(name="end_time")
	private String endTime="hh";
	@Column(name="is_active")
	private Boolean isActive=true;
	

}
