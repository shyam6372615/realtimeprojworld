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
@Table(name="spr_canteen")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CanteenEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="canteen_id")
	private Long canteenId;
	
	
	@JoinColumn(name="fk_institute_id")
	@OneToOne
	private InstituteEntity fkInstituteId;
	
	@Column(name="canteen_name")
	private String canteenName;
	
	@Column(name="is_active")
	private Boolean isActive;
	
//	@JsonBackReference
//	@OneToOne(mappedBy = "canteen")
//	private StudentEntity studentEntity;
	
	

}
