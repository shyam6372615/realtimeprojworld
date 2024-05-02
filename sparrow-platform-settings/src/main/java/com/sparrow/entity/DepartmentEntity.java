
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
@Table(name = "spr_department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887785219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private Long departmentId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="dept_short_form")
	private String deptShortForm;
	
	@Column(name="is_active")
	private Boolean isActive = true;

	

}
