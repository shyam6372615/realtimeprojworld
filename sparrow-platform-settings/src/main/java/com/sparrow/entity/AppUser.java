package com.sparrow.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * The persistent class for the APP_USERS database table.
 * 
 */
@Entity
@Table(name="APP_USERS")
@NamedQuery(name="AppUser.findAll", query="SELECT a FROM AppUser a")
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(value= {"salt"})
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	
	private String channel;

	private Long instituteId;
	
	private String comments;

	@Column(name="CONTACT_NO")
	private String contactNo;

	private String createdby;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;

	private String email;

	private String firstname;

	@Column(name="IS_ACC_DEFAULT_PSWD")
	private Boolean isAccDefaultPswd;

	@Column(name="IS_ACC_LOCKED")
	private Boolean isAccLocked;

	@Column(name="IS_ENABLED")
	private Boolean isEnabled;

	@Column(name="IS_SERVICE_USER")
	private Boolean isServiceUser;

	private String lastname;

	private Boolean ldapauthentication;

	private String modifiedby;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifieddate;

	private String salt;
	
	@Column(name="U_NAME") 
	private String usName;
	

	@Column(name="U_PWD")
	private String uPwd;
	
	

	
}

