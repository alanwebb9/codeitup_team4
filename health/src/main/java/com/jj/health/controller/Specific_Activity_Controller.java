/*package com.jj.health.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jj.health.service.Specific_Activity;
import com.jj.health.view.Search_Form_UI;
import com.jj.health.view.Search_Result;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/details")
public class Specific_Activity_Controller {
	
	@Autowired
	private Specific_Activity specificActivity;
	
	@PostMapping("/area_search")
	public ResponseEntity<?> food_search(@RequestBody Search_Form_UI search_form_ui)
	{
		try
		{
			int data=10;
			Activity activity_model=specificActivity.specific_Activity(data);
			
			return ResponseEntity.status(200).body(activity_model);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}
*/
