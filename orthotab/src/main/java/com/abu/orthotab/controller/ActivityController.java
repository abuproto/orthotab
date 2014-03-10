package com.abu.orthotab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abu.orthotab.domain.Activity;
import com.abu.orthotab.service.ActivityService;

@Controller
public class ActivityController {

	ActivityService activityService;
    
    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }
	
	@RequestMapping(value = "activity", method = RequestMethod.POST)
    @ResponseBody
	public Long createActivity(@RequestBody Activity activity){
		return activityService.createActivity(activity);
	}
}
