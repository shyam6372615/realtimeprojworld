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

@Data
@Table(name="spr_emp_facilities")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FacilitiesEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="facilities_id")
	private Long facilitiesId;
	
	@Column(name="has_TRANSPORT")
	private Boolean TRANSPORT;
	
	@Column(name="pick_up_point")
	private String pickupPoint;
	
	@Column(name="pick_up_latitude")
	private String pickupPointLatitude;
	
	@Column(name="pick_up_longitude")
	private String pickupPointLongitude;
	
	@Column(name="drop_off_point")
	private String dropOffPoint;
	
	@Column(name="drop_off_latitude")
	private String dropOffLatitude;
	
	@Column(name="drop_off_longitude")
	private String dropOffLongitude;
	
	@Column(name="has_LIBRARY")
	private Boolean LIBRARY;
	
	@OneToOne
	@JoinColumn(name="fk_library_id")
	private LibraryEntity libraryEntity;
	
	@Column(name="library_name")
	private Long libraryName;
	
	@Column(name="has_HOSTEL")
	private Boolean HOSTEL;
	
	@OneToOne
	@JoinColumn(name="fk_hostel_id")
	private HostelEntity hostelEntity;
	
	@Column(name="hostel_name", length = 100)
	private String hostelName;
	
	@Column(name="hostel_room_no", length = 30)
	private String hostelRoomNo;
	
	@Column(name="has_CANTEEN")
	private Boolean CANTEEN;
	
	@OneToOne
	@JoinColumn(name="fk_canteen_id")
	private CanteenEntity canteenEntity;
	
	@Column(name="canteen_name")
	private Long canteenName;
	
	@Column(name="select_meal")
	private String selectMeal;
	
	@OneToOne
	@JoinColumn(name="fk_billing_type")
	private CommonsDataEntity commonDataEntity;
	
	@OneToOne
	@JoinColumn(name="fk_emp_profile_id")
	private EmployeeEntity employeeEntity;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteEntity;
	
	

}
