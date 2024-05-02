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
@Table(name="spr_regional_settings")
@AllArgsConstructor
@NoArgsConstructor
public class RegionalSettingsEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="regional-setting_id")
	private Long regionalSettingId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteId;
	
	@OneToOne
	@JoinColumn(name="fk_country_id")
	private CommonsDataEntity fkCountryId;
	
	@OneToOne
	@JoinColumn(name="fk_language_id")
	private CommonsDataEntity fkLanguageId;
	
	@OneToOne
	@JoinColumn(name="fk_timezone_id")
	private CommonsDataEntity fkTimezoneId;
	
	@OneToOne
	@JoinColumn(name="fk_timeformat_id")
	private CommonsDataEntity fkTimeformatId;
	
	@OneToOne
	@JoinColumn(name="fk_dateformat_id")
	private CommonsDataEntity fkDateformatId;
	
	
	
	@Column(name="rtl_mode")
	private Boolean rtlMode;
	
	@OneToOne
	@JoinColumn(name="fk_colour_code_id")
	private CommonsDataEntity fkColourCodeId;
	
	@Column(name="is_active")
	private Boolean isActive=true;
}
