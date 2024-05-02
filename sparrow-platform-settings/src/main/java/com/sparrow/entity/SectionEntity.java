

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
@Table(name = "spr_section")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SectionEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887785219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="section_id")
	private Long sectionId;
	
	@Column(name="section_name")
	private String sectionName;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteId;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
	@Column(name="seats")
    private Integer seats;
}
