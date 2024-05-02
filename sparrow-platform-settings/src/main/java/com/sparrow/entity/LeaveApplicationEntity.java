package com.sparrow.entity;

import java.util.Date;

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
@Entity
@Table(name="spr_leave_application")
@NoArgsConstructor
@AllArgsConstructor
public class LeaveApplicationEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="leave_application_id")
	private Long leaveApplicationId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity instituteEntity;
	
	@Column(name="application_date")
	private Date applicationDate;
	
	@Column(name="leave_type")
	private String leaveType;
	
	@Column(name="day_type")
	private String dayType;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="attachment")
	private String attachment;
	
	@Column(name="action")
	private String action;
	 
	@Column(name="status")
	private String status;
	
	@Column(name="is_active")
	private boolean isActive=true;
	
	

}
