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
@Table(name="spr_timeformat")
@AllArgsConstructor
@NoArgsConstructor
public class TimeFormatEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="timeformat_id")
	private Long timeFormatId;
	
	@Column(name="timeformat_name")
	private String timeFormatName;
	
	@Column(name="is_active")
	private Boolean isActive;
}
