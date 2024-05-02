package com.sparrow.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class InstituteDTO {
	
    private Long instituteId;
    @NotNull(message = "fkInstituteTypeId cannot be null")
    @Min(value = 0, message = "fkInstituteTypeId cannot be empty")
	private Long fkInstituteTypeId;
    @Size(max = 6, message = "instituteId length should not exceed 6 characters")
	private String instituteIdPrefix;
    @NotNull(message = "instituteName cannot be null")
	private String instituteName;
    @NotNull(message = "institute Address cannot be null")
	private String instAddrs;
	@Min(value = 1000000000L, message = "Phone number should be at least 10 digits")
	@Max(value=10000000000000L, message="Phone number should not exceed 14 digits")
	private String phNo;
	@Email(message="please provide valid email")
	private String email;
	private String instLogo;
	private String affiliateOrg1;
	private String affiliationNo1;
	@NotNull(message = "appuserId cannot be null")
	private Long appUserId;
	
	@PastOrPresent(message = "institute Affiliation date1 cannot be in the future")
	private LocalDateTime instAffilioationDt1;
	private String affiliateOrg2;
	private String affiliationNo2;
	@PastOrPresent(message = "institute Affiliation date1 cannot be in the future")
	private LocalDateTime instAffilioationDt2;
	private String affiliateOrg3;
	private String affiliationNo3;
	@PastOrPresent(message = "institute Affiliation date1 cannot be in the future")
	private LocalDateTime instAffilioationDt3;
	private String affiliateOrg4;
	private String affiliationNo4;
	@PastOrPresent(message = "institute Affiliation date1 cannot be in the future")
	private LocalDateTime instAffilioationDt4;
	private String affiliateOrg5;
	private String affiliationNo5;
	@PastOrPresent(message = "institute Affiliation date1 cannot be in the future")
	private LocalDateTime instAffilioationDt5;
	private Boolean isActive = true;


}
