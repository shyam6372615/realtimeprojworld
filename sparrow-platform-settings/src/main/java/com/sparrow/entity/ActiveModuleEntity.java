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
@Table(name="spr_active_module")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveModuleEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="active_module_id")
	private Long activeModuleId;
	
	@Column(name="active_module_name")
	private String activeModuleName;
	
	@Column(name="is_enable")
	private Boolean isEnable=true;
	
	@Column(name="is_subscribe")
	private Boolean isSubscribe=true;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
	@OneToOne
	@JoinColumn(name="fk_mod_id")
	private SubscriptionModuleEntity fkModId;
	
	@OneToOne
	@JoinColumn(name="fk_package_id")
	private SubscriptionPackageEntity fkPackageId;
	
	
}
