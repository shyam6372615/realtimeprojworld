
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
@Data
@Table(name="spr_digital_domain")
@AllArgsConstructor
@NoArgsConstructor
public class DigitalDomainEntity extends BaseEntity{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="domain_id")
	private Long domain_id;
	
	@Column(name="domain_name")
	private String domainName;
	
	@Column(name="is_active")
	private Boolean isActive;
	
}
