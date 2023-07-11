package com.ec.of.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class FeedbackRequest {
	
	@Size(max = 100, message = "Name should be within 100 characters.")
	private String name;
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	@Size(max = 100, message = "Email should be within 100 characters.")
	private String emailAddress;
	@NotEmpty(message = "Contact type is required.")
	private String contactType;
	@NotEmpty(message = "Message is required.")
	@Size(min = 1, max = 1000, message = "Message should be within 1000 characters.")
	private String message;

}
