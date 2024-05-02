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
@Data
@Table(name="spr_stream")
@AllArgsConstructor
@NoArgsConstructor
public class StreamEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stream_id")
	private Long streamId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
		
	@Column(name="stream_name")
	private String streamName;
	
	@OneToOne
	@JoinColumn(name="fk_dept_type_id")
	private DepartmentEntity fkDeptTypeId;

	
	@Column(name="is_active")
	private Boolean isActive;
}
