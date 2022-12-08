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
	private IHrService hrService;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userID}")
	public HR getHr(@PathVariable Long userID) {
		HR hr = hrService.getHr(userID);
		List resources = this.restTemplate.getForObject("http://resource-service/resource/hr/"+userID, List.class);
		hr.setResourses(resources);
		return hr;
	}
}
