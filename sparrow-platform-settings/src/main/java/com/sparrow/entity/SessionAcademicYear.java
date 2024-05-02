package com.sparrow.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Data
@Table(name="spr_session_academic_year")
@NoArgsConstructor
@AllArgsConstructor
public class SessionAcademicYear extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2927649391384837004L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="academic_setup_id")
	private Long academicSetupId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkinstituteId;
	
	@NotNull(message = "Provide the academic year id!!!")
	@OneToOne
	@JoinColumn(name="fk_academic_year_id")
	private AcademicYearEntity fkAcademicYear;
	
	@NotNull(message = "Provide the Batch Year id!!!")
	@OneToOne
	@JoinColumn(name="fk_batch_year_id")
	private AcademicBatchYearEntity fkBatchyear;
	
//	@PastOrPresent(message = "startDate cannot be in the future")
	@NotNull(message = "startDate cannot be null")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="start_date")
	private String startDate;
	
//	@FutureOrPresent(message = "endDate must be present or in the future")
	@NotNull(message = "startDate cannot be null")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="end_date")
	private String endDate;
	
	@Column(name = "is_active")
	private Boolean isActive=true;
	

}