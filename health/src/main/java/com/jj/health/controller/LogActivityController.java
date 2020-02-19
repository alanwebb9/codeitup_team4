package com.jj.health.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jj.health.service.LogActivity;
import com.jj.health.view.ActivityForm;
@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api")
public class LogActivityController{
	
	@Autowired
	private LogActivity logActivity;
	
	@PostMapping("/LogActivity")
	public ResponseEntity<?> food_search(@RequestBody ActivityForm activityForm)
	{
		try
		{
			String result=logActivity.storeActivity(activityForm);
			return ResponseEntity.status(200).body(result);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
}