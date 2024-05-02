package com.sparrow.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "spr_academic_subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AcademicSubjectEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5657455422979875546L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="academic_subject_id")
	private Long acdmSubId;
	
	@NotNull(message = "fkInstituteTypeId cannot be null")
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
	@NotNull(message = "Academic Subject Title cannot be null")
	@Column(name="academic_sub_title")
	private String acdmSubTitle;
	
	@NotNull(message = " Academic Subject Code cannot be null")
	@Column(name="academic_sub_code")
	private String acdmSubCode;
	
	@NotNull(message = "fkSubTypeId cannot be null")
    
	@OneToOne
	@JoinColumn(name="fk_subject_type_id")
	private CommonsDataEntity fkSubTypeId;
	@Column(name="is_active")
	private Boolean isActive=true;
	

}