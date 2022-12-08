package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hr.entity.HR;
import com.hr.entity.Resource;
import com.hr.service.IHrService;

@RestController
@RequestMapping("/hr")
public class HRController {

	@Autowired
	IHrService hrService;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{userID}")
	public HR getHr(@PathVariable Long userID) {
		HR hr = hrService.getHr(userID);
		List<Resource> resources = this.restTemplate.getForObject("http://localhost:5002/resource/hr/"+userID, List.class);
		hr.setResourses(resources);
		return hr;
	}
}
