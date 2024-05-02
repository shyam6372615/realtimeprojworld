
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
@Table(name="spr_digital_addrs")
@NoArgsConstructor
@AllArgsConstructor
public class DigitalAddrsEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="digital_addrs_id")
	private Long digitalAddrsId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkFnstituteId;
	
	@OneToOne
	@JoinColumn(name="fk_digital_domain_id")
	private DigitalDomainEntity fkDigitalDomainId;
	
	@Column(name="digital_page_link")
	private String digitalPageLink;
	
	@Column(name="is_active")
	private Boolean isActive=true;
}
