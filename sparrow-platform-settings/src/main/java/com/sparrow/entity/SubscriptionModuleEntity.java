package com.sparrow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="spr_subscription_modules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionModuleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="module")
	private String module;
	
	@Column(name="module_dependency")
	private Long moduleDependency;
	
	@Column(name="status")
	private String staTus;
	
	@Column(name="sub_module")
	private String subModule;
	
	@Column(name="description")
	private String descriPtion;
}
