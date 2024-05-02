package com.sparrow.entity;

import com.sparrow.entity.ScheduleDayEntity.ScheduleDayEntityBuilder;

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
@Table(name = "spr_periods")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PeriodsEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="period_id")
	private Long periodId;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	@OneToOne
	@JoinColumn(name="fk_schedule_day")
	private ScheduleDayEntity fkScheduleDay;
//	@OneToOne
//	@JoinColumn(name="fk_session_cls_timing_id")
//	private SessionClassTimingEntity fkSessionClassId;
	@Column(name="slot_name")
	private String slotName;
	@Column(name="start_time")
	private String StartTime;
	@Column(name="end_time")
	private String EndTime;
	@Column(name="is_active")
	private Boolean isActive=true;
	


}
