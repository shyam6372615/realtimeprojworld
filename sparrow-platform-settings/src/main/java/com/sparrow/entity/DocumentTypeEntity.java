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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="spr_document_type")
public class DocumentTypeEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="document_id")
	private Long documentTypeId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteEntity;
	
	@Column(name="document_name")
	private String documentTypeName;
	
	@Column(name="is_active")
	private boolean isActive=true;

}
