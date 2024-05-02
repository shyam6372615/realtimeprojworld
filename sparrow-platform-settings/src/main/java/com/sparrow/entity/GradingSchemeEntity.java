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
@Data
@Table(name="spr_grade_scheme_details")
@NoArgsConstructor
@AllArgsConstructor
public class GradingSchemeEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 641600484456967152L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="grade_scheme_details_id")
	private Long gradingSchemeId;
	@OneToOne
	@JoinColumn(name="fk_grading_tittle_id")
	private GradingTittleEntity fkGradingTittleId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkFnstituteId;
	@Column(name="letter_grade")
	private String letterGrade;
	@Column(name="score_strat_range")
	private Float scoreStartRange;
	@Column(name="score_end_range")
	private Float scoreEndrange;
	@Column(name="grade_point")
	private Integer gradePoint;
	@Column(name="classification")
	private String classification;
	@Column(name="is_fail")
	private Boolean isFail;
	@Column(name="is_active")
	private Boolean isActive=true;
	
	
	

}
