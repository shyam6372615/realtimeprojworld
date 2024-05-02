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
@Table(name = "spr_subject_master")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectMasterEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4303387691630411562L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	@OneToOne
	@JoinColumn(name="fk_subject_grp_id")
	private SubjectGroupEntity fkSubjectGroupId;
	@OneToOne
	@JoinColumn(name="fk_sub_category_id")
	private SubjectCategoryEntity fkSubCategoryId;
	@OneToOne
	@JoinColumn(name="fk_academic_sub_id")
	private AcademicSubjectEntity fkAcademicSubId;
	@Column(name="is_active")
	private Boolean isActive=true;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkinstituteId;
	

}
