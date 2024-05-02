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
@Table(name="spr_house")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="house_id")
	private Long houseId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
	@Column(name="house_name")
	private String houseName;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
	

}
