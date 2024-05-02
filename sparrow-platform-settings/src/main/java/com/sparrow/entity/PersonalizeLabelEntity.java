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
@Table(name="spr_perso_labels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalizeLabelEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="personalize_label_id")
	private Long personalizeLabelId;
	
	@JoinColumn(name="fk_institute_id")
	@OneToOne
	private InstituteEntity fkInstituteId;
	
	@Column(name="default_level_name")
	private String defaultLevelName;
	
	@Column(name="custom_label_name")
	private String customLabelName;
	
	
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
}
