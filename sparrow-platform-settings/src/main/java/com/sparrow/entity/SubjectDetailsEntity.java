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
@Table(name="spr_subject_details")
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDetailsEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subject_grp_dtls_id")
	private Long subjectGrpDtlsId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
	@OneToOne
	@JoinColumn(name="fk_subject_grp_id")
	private SubjectGroupEntity fkSubjectGrpId;
	
	@OneToOne
	@JoinColumn(name="fk_subject_cat_id")
	private SubjectCategoryEntity fkSubjectCatId;
	
	@OneToOne
	@JoinColumn(name="fk_topic_id")
	private TopicEntity fkTopicId;
	
	@Column(name="is_active")
	private Boolean isActive=true;
}
