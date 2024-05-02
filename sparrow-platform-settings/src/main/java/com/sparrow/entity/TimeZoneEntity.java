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
@Table(name="spr_timezone")
@AllArgsConstructor
@NoArgsConstructor
public class TimeZoneEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="timezone_id")
	private Long timeZoneId;
	
	@Column(name="timezone_name")
	private String timeZoneName;
	
	@Column(name="is_active")
	private Boolean isActive;
}
