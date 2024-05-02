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
@Table(name="spr_emp_document")
public class DocumentEntity extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="document_id")
	private Long documentId;
	
	@OneToOne
	@JoinColumn(name="fk_emp_profile_id")
	private EmployeeEntity employeeEntity;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteEntity;
	
	@OneToOne
	@JoinColumn(name="fk_document_type")
	private DocumentTypeEntity documentTypeEntity;
	
	@Column(name="document_name")
	private String documentName;
	
	@Column(name="upload_doc")
	private String uploadDoc;
	private Boolean isActive=true;
	

}
