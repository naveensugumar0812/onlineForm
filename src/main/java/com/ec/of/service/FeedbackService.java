package com.ec.of.service;

import java.util.List;

import com.ec.of.model.entity.FeedbackEntity;
import com.ec.of.model.request.FeedbackRequest;

public interface FeedbackService {
	void submitForm(FeedbackRequest request);
	List<FeedbackEntity> getListOfFeedback(String contactType,String dateSort);

}
