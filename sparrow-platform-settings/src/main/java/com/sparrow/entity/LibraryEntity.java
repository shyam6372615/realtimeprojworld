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
@Table(name="spr_library")
public class LibraryEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="library_id")
	private Long libraryId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteEntity;
	
	@Column(name="library_name")
	private String libraryName;
	
	@Column(name="is_active")
	private boolean isActive=true;

}