package com.sparrow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "spr_academic_courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AcademicCourseEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381265887785219009L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="academic_course_id")
	private Long academicCourseId;

	@OneToOne
	@JoinColumn(name="fk_institute_id")
	@NotNull(message = "fkInstituteId cannot be null")
	private InstituteEntity fkInstituteId;
	
	@OneToOne
	@JoinColumn(name="fk_course_level_id")
	@NotNull(message = "fkCourseLevelId cannot be null")
	private CourseLevelEntity fkCourseLevelId;
	
	@OneToOne
	@JoinColumn(name="fk_course_program_id")
	@NotNull(message = "fkProgramId cannot be null")
	private ProgramEntity fkProgramId;
	
	@OneToOne
	@JoinColumn(name="fk_course_dept_id")
	@NotNull(message = "fkDeptId cannot be null")
	private DepartmentEntity fkDeptId;
	
	@OneToOne
	@JoinColumn(name="fk_course_sec_id")
	@NotNull(message = "fkSectionId cannot be null")
	private SectionEntity fkSectionId;
	
	@OneToOne
	@JoinColumn(name="course_duration")
	@NotNull(message = "courseDuration cannot be null")
	private CommonsDataEntity courseDuration;
	
	@Column(name="section_students")
	@NotNull(message = "sectionStudents cannot be null")
	private Integer sectionStudents;
	
	@Column(name="course_title")
	private String courseTitle;
	
	@OneToOne
	@JoinColumn(name="course_semester")
	@NotNull(message = "courseSemester cannot be null")
	private CommonsDataEntity courseSemester;
	
	@Column(name="odd_sem_st_dt")
	@NotNull(message = "oddSemesterStDt cannot be null")
	private String oddSemesterStDt;
	
	@Column(name="even_sem_st_dt")
	@NotNull(message = "evenSemesterStDt cannot be null")
	private String evenSemesterStDt;
	
	@Column(name="is_active")
	private Boolean isActive=true;
	

}