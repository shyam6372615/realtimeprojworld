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
@Table(name = "spr_schedule_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleClassEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="schedule_cls_id")
	private Long scheduleClassId;
	@OneToOne
	@JoinColumn(name="fk_schedule_day_id")
	private ScheduleDayEntity fkScheduleDay;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	@Column(name="start_date")
	private String startDate;
	@Column(name="end_date")
	private String endDate;
	@OneToOne
	@JoinColumn(name="period")
	private  PeriodsEntity fkPeriodsId;
	@OneToOne
	@JoinColumn(name="fk_subject_id")
	private SubjectEntity fkSubjectId;
	@OneToOne
	@JoinColumn(name="fk_teacher_id")
	private EmployeeEntity fkEmployeeId;
	@Column(name="video_call")
	private String videoCall;
	@Column(name="room_number")
	private String roomNumber;
	@Column(name="is_active")
	private Boolean isActive=true;

}
