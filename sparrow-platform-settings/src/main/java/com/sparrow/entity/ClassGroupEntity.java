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
@Table(name = "spr_class_groups")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClassGroupEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887785219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="class_id")
	private Long classId;
	@Column(name="class_group_name")
	private String classGroupName;
	@Column(name="is_active")
	private Boolean isActive=true;
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteId;
	
	

}
