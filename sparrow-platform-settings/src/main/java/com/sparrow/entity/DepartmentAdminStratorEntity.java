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
@Table(name = "spr_dept_adminstrator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentAdminStratorEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dept_adm_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	@NotNull(message = "fkInstituteId cannot be null")
	private InstituteEntity fkInstituteId;
	
	@Column(name="dept_adm_name")
	@NotNull(message = "deptAdminName cannot be null")
	private String deptAdminName;
	
	@OneToOne
	@JoinColumn(name="fk_stream_id")
	@NotNull(message = "fkStreamId cannot be null")
	private StreamEntity fkStreamId;
	
	@OneToOne
	@JoinColumn(name="fk_dept_type_id")
	@NotNull(message = "fkDepartmentId cannot be null")
	private DepartmentEntity fkDepartmentId;
	
	@Column(name="is_active")
	private Boolean isActive=true;

}