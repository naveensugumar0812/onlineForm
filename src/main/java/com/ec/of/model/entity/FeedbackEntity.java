package com.ec.of.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "FEEDBACK")
public class FeedbackEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long feedbackId;
	private String name;
	private String emailAddress;
	@CreationTimestamp
	private LocalDateTime submissionDate;
	private String contactType;
	private String message;
	

}
