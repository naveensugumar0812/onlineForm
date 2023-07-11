package com.ec.of.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.ec.of.model.entity.FeedbackEntity;
import com.ec.of.model.request.FeedbackRequest;
import com.ec.of.repository.FeedbackRepository;
import com.ec.of.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	private final FeedbackRepository feedbackRepository;
	
	public FeedbackServiceImpl(
			FeedbackRepository feedbackRepository
			) {
		this.feedbackRepository = feedbackRepository;
	}
	
	@Override
	public void submitForm(FeedbackRequest request) {
		FeedbackEntity feedbackEntity = setfeedbackEntity(request);
		feedbackRepository.save(feedbackEntity);
	}
	
	@Override
	public List<FeedbackEntity> getListOfFeedback(
			String contactType,
			String dateSort
			){
		
		List<FeedbackEntity> feedbackList = null;
		if(StringUtils.isBlank(contactType)) {
			feedbackList = feedbackRepository.findAll();
		} else{
			feedbackList = feedbackRepository.findByContactType(contactType);
		}
		
		if(StringUtils.isNotBlank(dateSort)) {
			if("DESC".equalsIgnoreCase(dateSort)) {
				Collections.sort(feedbackList, (feedback1, feedback2) -> feedback2.getSubmissionDate().compareTo(feedback1.getSubmissionDate()));
			}else {
				Collections.sort(feedbackList, (feedback1, feedback2) -> feedback1.getSubmissionDate().compareTo(feedback2.getSubmissionDate()));
			}
		}
		
		return feedbackList;
	}
	
	private FeedbackEntity setfeedbackEntity(FeedbackRequest request) {
		FeedbackEntity entity = new FeedbackEntity();
		entity.setName(request.getName());
		entity.setEmailAddress(request.getEmailAddress());
		entity.setContactType(request.getContactType());
		entity.setMessage(request.getMessage());
		return entity;
	}

}
