package com.sparrow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="spr_academic_year")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYearEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acdemic_year_id")
	private Long acdemicYearId;
	
	@Column(name="academic_year_name")
	private String academicYearName;
	
	@Column(name="is_active")
	private Boolean isActive;
	
}
