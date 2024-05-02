package com.sparrow.entity;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="spr_employee")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_profile_id")
	private Long empProfileId;
	
	@Column(name="employment_date")
	private Date employmentDate;
	
	@Column(name="emp_id")
	private String employeeId;
	
	@Column(name="reporting_manager")
	private String reportingManager;
	
	@Column(name="emp_image_upload")
	private String empImageUpload;
	
	@Column(name="first_name" ,length = 30)
	private String firstName;
	
	@Column(name="last_name", length = 20)
	private String lastName;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@Column(name="gender", length = 50)
	private String gender;
	
	@Column(name="religion", length = 100)
	private  String religion;
	
	@Column(name="blood_group" ,length = 50)
	private String bloodGroup;
	
	@Column(name="mobile_number")
	private Long mobileNumber;
	
	@Column(name="email_id", length = 100)
	private String emailId;
	
	@Column(name="father_image_upload", columnDefinition = "TEXT")
	private String fatherImageUpload;
	
	@Column(name="father_name", length = 50)
	private String fatherName;
	
	@Column(name="fathers_occupation", length = 100)
	private String fathersOccupation;
	
	@Column(name="fathers_mobile_no")
	private Long fathersMobileNo;
	
	@Column(name="father_email_id", length = 100)
	private String fatherEmailId;
	
	@Column(name="is_married")
	private boolean isMarried;
	
	@Column(name="mother_image_upload", columnDefinition = "TEXT")
	private String motherImageUpload;
	
	@Column(name="mothers_name", length = 50)
	private String motherName;
	
	@Column(name="mothers_spouse_occupation", length = 100)
	private String mothersSpouseOccupation;
	
	@Column(name="mother_mobile_no")
	private Long motherMobileNo;
	
	@Column(name="mother_email_id", length = 100)
	private String motherEmailId;
	
	@Column(name="next_of_kins_name", length = 50)
	private String nextOfKinsName;
	
	@Column(name="relationship", length = 100)
	private String relationship;
	 
	@Column(name="next_of_kins_mobile_no")
	private Long nextOfKinsMobileNo;
	
	@Column(name="next_of_kins_email_id", length = 100)
	private String nextOfKinsEmailId;
	
	@Column(name="emergency_contact")
	private String emergencyContact;
	
	@Column(name="child_information", length = 100)
	private String childInformation;
	
	@Column(name="present_address", length = 300)
	private String presentAddress;
	
	@Column(name="permanent_address", length = 300)
	private String permanentAddress;
	
	@Column(name="same_as_present")
	private boolean sameAsPresent;
	
	@Column(name="guardian_address",length = 300)
	private String guadianAddress;
	
	@Column(name="bank_name", length = 200)
	private String bankName;
	
	@Column(name="account_no", length = 50)
	private Long accountNo;
	
	@Column(name="ifsc_code", length = 10)
	private String ifscCode;
	
	@Column(name="adharcard_no", length = 20)
	private Long aadharCardNo;
	
	@Column(name="pancard_no", length = 15)
	private String pancardNo;
	
	@Column(name="esi_no", length = 15)
	private String esiNo;
	
	@Column(name="pf_no", length = 15)
	private String pfNo;
	
	@Column(name="uan_no", length = 20)
	private String uanNo;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
	@OneToOne
	@JoinColumn(name="fk_employment_status_id")
	private EmployementStatusEntity fkEmployementStatusId;
	
	
	@OneToOne
	@JoinColumn(name="fk_department_id")
	private DepartmentEntity fkDepartmentId;
	
	@OneToOne
	@JoinColumn(name="fk_designation_id")
	private DesignationEntity fkDesignationId;
	
	@OneToOne
	@JoinColumn(name="fk_role")
	private Role fkRolesId;
	
	@OneToOne
	@JoinColumn(name="fk_salutation_id")
	private SalutationEntity fkSalutationId;
	
//	@OneToMany(mappedBy = "employeeEntity", cascade = CascadeType.ALL)
//	private List<EmployeeEducationEntity> employeeEducationEntityList;
//	
//	@OneToMany(mappedBy = "employeeEntity", cascade = CascadeType.ALL)
//	private List<EmployeeExperienceEntity> employeeExperienceEntityList;

	
	

}
