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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="spr_grading_tittle")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GradingTittleEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="grading_tittle_id")
	private Long gradingTittleId;
	
	@JoinColumn(name="fk_institute_id")
	@OneToOne
	private InstituteEntity fkInstituteId;
	
	@Column(name="grading_title_name")
	private String gradingTitleName;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="is_active")
	private Boolean isActive=true;

	
}
