package com.ec.of.model.response;

import java.sql.Date;

import lombok.Data;

@Data
public class FeedbackResponse {

	private Long feedbackId;
	private String name;
	private String emailAddress;
	private Date submissionDate;
	private String contactType;
	private String message;
}
