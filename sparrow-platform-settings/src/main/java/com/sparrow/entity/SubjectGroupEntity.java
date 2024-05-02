package com.sparrow.entity;

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
@Table(name="spr_subject_group")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectGroupEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sub_group_id")
	private Long subGroupId;
    
    @NotNull(message = "fkInstituteTypeId cannot be null")
    @OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
    
    @NotNull(message = "Academic CoutseId cannot be null")
    @OneToOne
	@JoinColumn(name="fk_acdm_course_id")
	private AcademicCourseEntity fkAcademicCourseId;
    
    @NotNull(message = "Group Title cannot be null")
    @Column(name="group_title")
	private String groupTitle;
    
    
	@Column(name="is_active")
	private Boolean isActive=true;
	
	

}