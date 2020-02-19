package com.jj.health.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jj.health.model.LogTable;
import com.jj.health.repository.LogRepository;
import com.jj.health.view.ActivityForm;

@Service
public class LogActivityImpl implements LogActivity {
	
	@Value("${spring.user.success}")
	String success;
	@Autowired
	private LogRepository logRepository;
	
	public String storeActivity(ActivityForm activityForm)
	{
		
		LogTable logTable=new LogTable();
		BeanUtils.copyProperties(activityForm, logTable);
		logRepository.save(logTable);
		
		return success;
	}
	
}
