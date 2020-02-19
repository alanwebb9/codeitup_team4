package com.jj.health.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.health.model.Activity;
import com.jj.health.repository.SearchRepository;
import com.jj.health.view.Search_Form_UI;
import com.jj.health.view.Search_Result;

@Service
public class Search_Service_Impl implements Search_Service{
	
	@Autowired
	private SearchRepository search_Repository;
	
	public List<Search_Result> Search_Result_Location(Search_Form_UI search_form_ui)
	{
		System.out.println("I am in Service");
		List<Search_Result> search_result= get_activities_with_distance(search_form_ui.getLatitude(),search_form_ui.getLongitude(),10);
		return search_result;
	}

	public List<Search_Result> get_activities_with_distance(float latitude,float longitude,int distance){
			double actual_distance;
			List<Search_Result> new_list=new ArrayList<Search_Result>();
			List<Activity> results=search_Repository.findAllRecord();
			Iterator<Activity> results_iterator=results.iterator();
			while(results_iterator.hasNext())
			{
				Search_Result searchResultObject=new Search_Result();
				Activity activity_object=results_iterator.next();
				System.out.println(activity_object);
				Activity activity=search_Repository.findActivityRecord(activity_object.getFid());
				actual_distance=get_the_distance(latitude,longitude,activity.getLat(),activity.getLon());
				if((int)actual_distance<=distance)
				{
					BeanUtils.copyProperties(activity_object,searchResultObject);
					new_list.add(searchResultObject);
					System.out.println(searchResultObject.getFid());
					//distance_map.put(restaurant_object.getRestaurant_id(),(float)distance);
				}
			}
			return new_list;
	}
	private static double get_the_distance(double lat1, double lon1, double lat2, double lon2) {
			if ((lat1 == lat2) && (lon1 == lon2)) {
				return 0;
			}
			else {
				double theta = lon1 - lon2;
				double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.1515;
				dist = dist * 1.609344;
				return dist;
			}
	}
}
