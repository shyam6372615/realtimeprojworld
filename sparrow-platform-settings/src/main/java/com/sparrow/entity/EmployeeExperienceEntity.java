package com.sparrow.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="spr_emp_experience")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeExperienceEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_experience_id")
	private Long experienceId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_profile_id")
	private EmployeeEntity employeeEntity;
	
	@Column(name="exp_organization_name")
	private String orgnanisationName;
	
	@Column(name="designation")
	private String Designation;
	
	@JsonFormat(pattern = "MM-YYYY")
	@Column(name="start_duration")
	private String startDuration;
	
	@JsonFormat(pattern = "MM-YYYY")
	@Column(name="end_duration")
	private String endDuration;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private List<EmployeeExperienceEntity> employeeExperienceEntityList;
	
	
	

}
