package com.sparrow.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="spr_academic_assessment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicAssessmentEntity extends BaseEntity{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="assessment_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	@NotNull(message = "assessmentTitle cannot be null")
	@Column(name="assessment_title")
	private String assessmentTitle;
	@NotNull(message = "shortCode cannot be null")
	@Column(name="short_code")
	private String shortCode;
	@NotNull(message = "AssessmentTypeId cannot be null")
	@OneToOne
	@JoinColumn(name="fk_assessment_type_id")
	private CommonsDataEntity fkAssessmentTypeId;
	
	@NotNull(message = "GradeSchemeId cannot be null")
	@OneToOne
	@JoinColumn(name="fk_grade_scheme_id")
	private GradingTittleEntity fkGradeSchemeId;
	@NotNull(message = "ClassOffId cannot be null")
	@OneToOne
	@JoinColumn(name="fk_class_off_id")
	private CommonsDataEntity fkClassOffId;
	@NotNull(message = "startDate cannot be null")
	@Column(name="start_date")
	private String startDate;
	@NotNull(message = "endDate cannot be null")
	@Column(name="end_date")
	private String endDate;
	@NotNull(message = "resultPublishdate cannot be null")
	@Column(name="result_publishdate")
	private String resultPublishdate;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
}