package com.jj.health.service;

import java.util.List;

import com.jj.health.view.Search_Form_UI;
import com.jj.health.view.Search_Result;

public interface Search_Service {
	
	public List<Search_Result> Search_Result_Location(Search_Form_UI search_form_ui);
}
