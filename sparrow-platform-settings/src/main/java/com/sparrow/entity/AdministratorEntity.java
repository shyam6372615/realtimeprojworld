package com.sparrow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="spr_institute_adminstrator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dept_adm_id")
	private Long deptAdmId;
	
	@JoinColumn(name="fk_institute_id")
	@OneToOne
	@NotNull(message = "fkInstituteId cannot be null")
	private InstituteEntity fkInstituteId;
	
	@JoinColumn(name="fk_employee_id")
	@OneToOne
	@NotNull(message = "fkEmployeeId cannot be null")
	private EmployeeEntity fkEmployeeId;
	
	@Column(name="is_active")
	private Boolean isActive=true;
}