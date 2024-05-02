
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
@Table(name = "spr_program")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887785219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="program_id")
	private Long programId;
	
	@Column(name="programe_name")
	private String programName;
	
	@Column(name="program_short_form")
	private String programShortForm;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteId;
	

}
