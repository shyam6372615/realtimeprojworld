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
@Table(name = "spr_activemodule_regional_mappings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveModuleRegionalMappingEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
	@OneToOne
	@JoinColumn(name="fk_active_module_id")
	private ActiveModuleEntity fkActiveModuleId;
	

	@OneToOne
	@JoinColumn(name="fk_regional_settings_id")
	private RegionalSettingsEntity fkRegionalSettingsId;
	
	@Column(name="is_active")
	private Boolean isActive=true;
}
