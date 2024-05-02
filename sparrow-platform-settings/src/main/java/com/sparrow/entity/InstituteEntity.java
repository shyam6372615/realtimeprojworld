package com.sparrow.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "spr_institute_basic", uniqueConstraints = @UniqueConstraint(columnNames = {"inst_name"}))
@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder
public class InstituteEntity extends BaseEntity{

	
private static final long serialVersionUID = 4381265887735219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="institute_id")
	private Long instituteId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_type_id")
	private InstituteTypeEntity fkInstituteTypeId;
	@OneToOne
	@JoinColumn(name="fk_app_user")
	private AppUser fkAppUser;
	@Column(name="inst_id_prefix")
	private String instituteIdPrefix;
	@Column(name="inst_name")
	private String instituteName;
	@Column(name="inst_addrs")
	private String instAddrs;
	@Column(name="inst_ph_no")
	private String phNo;
	@Column(name="inst_email")
	private String email;
	@Column(name="inst_logo")
	private String instLogo;
	@Column(name="inst_Affilate_org_1")
	private String affiliateOrg1;
	@Column(name="inst_Affilition_no_1")
	private String affiliationNo1;
	@Column(name="inst_Affilition_dt_1")
	private LocalDateTime instAffilioationDt1;
	@Column(name="inst_Affilate_org_2")
	private String affiliateOrg2;
	@Column(name="inst_Affilition_no_2")
	private String affiliationNo2;
	@Column(name="inst_Affilition_dt_2")
	private LocalDateTime instAffilioationDt2;
	@Column(name="inst_Affilate_org_3")
	private String affiliateOrg3;
	@Column(name="inst_Affilition_no_3")
	private String affiliationNo3;
	@Column(name="inst_Affilition_dt_3")
	private LocalDateTime instAffilioationDt3;
	@Column(name="inst_Affilate_org_4")
	private String affiliateOrg4;
	@Column(name="inst_Affilition_no_4")
	private String affiliationNo4;
	@Column(name="inst_Affilition_dt_4")
	private LocalDateTime instAffilioationDt4;
	@Column(name="inst_Affilate_org_5")
	private String affiliateOrg5;
	@Column(name="inst_Affilition_no_5")
	private String affiliationNo5;
	@Column(name="inst_Affilition_dt_5")
	private LocalDateTime instAffilioationDt5;
	@Column(name = "is_active")
	private Boolean isActive = true;

}
