package com.sparrow.entity;

import java.util.List;

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
@Table(name = "spr_schedule_day")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDayEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="schedule_day_id")
	private Long scheduleDayId;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	@Column(name="schedule_day_name")
	private String scheduleDayName;
	@Column(name="is_active")
	private Boolean isActive=true;
	@OneToOne
	@JoinColumn(name="fk_academic_course_id")
	private AcademicCourseEntity fkAcademicCourse;
	
}
