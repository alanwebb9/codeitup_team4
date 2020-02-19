package com.jj.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jj.health.model.Activity;
import com.jj.health.service.*;
@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api")
public class SpecificActivityController {
	
	@Autowired
	private SpecificActivity specificActivity;
	
	@PostMapping("/AreaSearch/{fid}")
	public ResponseEntity<?> activitySearch(@PathVariable int fid)
	{
		try
		{
			Activity activity_model=specificActivity.specificActivity(fid);
			
			return ResponseEntity.status(200).body(activity_model);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}

