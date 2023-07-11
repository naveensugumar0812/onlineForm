package com.ec.of.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ec.of.model.entity.FeedbackEntity;
import com.ec.of.model.request.FeedbackRequest;
import com.ec.of.service.FeedbackService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/onlineform/v1")
public class FeedbackController {
	
	private static final String SUCCESS = "Success";
	
	private final FeedbackService feedbackservice;
	
	@Autowired
	public FeedbackController(
			FeedbackService feedbackservice
			) {
		this.feedbackservice = feedbackservice;
	}
	
	@PostMapping("/submitFeedback")
	public ResponseEntity<String> submitFeedback(
			@Valid @RequestBody FeedbackRequest request
			){
		feedbackservice.submitForm(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(SUCCESS);
	}
	
	@GetMapping("/getFeedbackList")
	public ResponseEntity<List<FeedbackEntity>> getFeedbackList(
			@RequestParam(name = "contactType",required = false) String contactType,
			@RequestParam(name = "dateSort",required = false) String dateSort
			){
		List<FeedbackEntity> feedbackList = feedbackservice.getListOfFeedback(contactType,dateSort);
		return ResponseEntity.ok(feedbackList);
	}

}
