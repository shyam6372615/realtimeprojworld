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
@Table(name = "spr_subject_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCategoryEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887785219009L;
	
    	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="subject_category_id")
		private Long subCategoryId;
    	
    	@OneToOne
		@JoinColumn(name="fk_subject_type_id")
    	@NotNull(message = "subType cannot be null")
    	private CommonsDataEntity subType;
    	
	    @Column(name="subject_category_name")
	    @NotNull(message = "defaultDuration cannot be null")
		private String subCategoryName; 
	    
		@OneToOne
		@JoinColumn(name="fk_institute_id")
		@NotNull(message = "defaultDuration cannot be null")
		private InstituteEntity fkInstituteId;
		
		@Column(name="is_active")
		private Boolean isActive=true;

}