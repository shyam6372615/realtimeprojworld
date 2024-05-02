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
@Table(name = "spr_commons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonsDataEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String keyword;
	private String key;
	private String value;
	@Column(name="is_active")
	private Boolean isActive;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteId;
	
	@Column(name="alias_name")
	private String aliasName;
	
	

}
