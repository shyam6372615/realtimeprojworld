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
@Table(name="spr_hostel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostelEntity extends BaseEntity {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="hostel_id")
private Long hostelId;


@JoinColumn(name="fk_institute_id")
@OneToOne
private InstituteEntity fkInstituteId;

@Column(name="hostel_name")
private String hostelName;

@Column(name="catagory")
private String cataGory;

@Column(name="status")
private Boolean staTus;

@Column(name="description")
private String descriPtion;

@Column(name="is_active")
private Boolean isActive;

//@JsonBackReference
//@OneToOne(mappedBy = "hostel")
//private StudentEntity studentEntity;
}
