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
@Table(name="spr_dept_head")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentHeadEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dept_head_id")
	private Long deptHeadId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkFInstituteId;
	
	@OneToOne
	@JoinColumn(name="fk_employee_id")
	private EmployeeEntity fkFEmployeeId;
	
	@OneToOne
	@JoinColumn(name="fk_dept_id")
	private DepartmentEntity fkDeptId;
	
	@Column(name="is_active")
	private Boolean isActive=true;
}
