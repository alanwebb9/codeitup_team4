package com.jj.health.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jj.health.service.Search_Service;
import com.jj.health.view.Search_Form_UI;
import com.jj.health.view.Search_Result;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/search")
public class Search_Controller {
	
	@Autowired
	private Search_Service searchService;
	
	@PostMapping("/area_search")
	public ResponseEntity<?> food_search(@RequestBody Search_Form_UI search_form_ui)
	{
		try
		{
			List<Search_Result> food_form=searchService.Search_Result_Location(search_form_ui);
			
			return ResponseEntity.status(200).body(food_form);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}

