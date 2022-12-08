package com.resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.entity.Resource;
import com.resource.service.IResourceService;

@RestController
@RequestMapping("/resource")
public class ResourceController {
	
	@Autowired
	IResourceService resourceService;

	@GetMapping("/hr/{userID}")
	public List<Resource> getResources(@PathVariable Long userID){
		return resourceService.getResourceForUsers(userID);
	}
}
