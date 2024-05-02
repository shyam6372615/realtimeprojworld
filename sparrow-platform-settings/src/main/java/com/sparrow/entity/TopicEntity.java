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
@Table(name="spr_topic")
@AllArgsConstructor
@NoArgsConstructor
public class TopicEntity extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="topic_id")
	private Long topicId;
	
	@OneToOne
	@JoinColumn(name="fk_institute_id")
	private InstituteEntity fkInstituteId;
	
	@Column(name="topic_name")
	private String topicName;
	
	@Column(name="is_active")
	private Boolean isActive=true;
}
