package com.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.HR;
import com.hr.service.IHrService;

@RestController
@RequestMapping("/hr")
public class HRController {

	@Autowired
	IHrService hrService;

	@GetMapping("/{userID}")
	public HR getHr(@PathVariable Long userID) {
		return hrService.getHr(userID);
	}
}
