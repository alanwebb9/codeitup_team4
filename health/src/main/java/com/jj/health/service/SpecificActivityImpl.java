package com.jj.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.health.model.Activity;
import com.jj.health.repository.SearchRepository;

@Service
public class SpecificActivityImpl implements SpecificActivity{
	
	@Autowired
	private SearchRepository searchRepository;

	
	public Activity specificActivity(int fid)
	{
		Activity activityObject=searchRepository.findActivityRecord(fid);
		return activityObject;
		
	}
	
}