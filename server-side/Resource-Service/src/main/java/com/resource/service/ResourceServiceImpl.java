package com.resource.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.resource.entity.Resource;

@Service
public class ResourceServiceImpl implements IResourceService {

	List<Resource> resources = List.of(
			new Resource(1l, "peter@gmail.com", "Peter", "React Dev", 1001l),
			new Resource(2l, "sam@gmail.com", "Sam", "Java Dev", 1002l),
			new Resource(3l, "Sudhanshu@gmail.com", "Sudhanshu", "JS Dev", 1002l),
			new Resource(4l, "abhi@gmail.com", "Abhi", "Python Dev", 1003l),
			new Resource(5l, "shiva@gmail.com", "Shiva", "C Dev", 1004l),
			new Resource(6l, "nikita@gmail.com", "Nikita", "Cpp Dev", 1004l),
			new Resource(7l, "varsha@gmail.com", "Varsha", "Angular Dev", 1005l),
			new Resource(8l, "jay@gmail.com", "Jay", "C# Dev", 1005l),
			new Resource(9l, "ram@gmail.com", "Ram", "HTML Dev", 1006l),
			new Resource(10l, "raj@gmail.com", "Raj", "SAP Dev", 1001l));

	@Override
	public List<Resource> getResourceForUsers(Long userID) {
		return resources.stream().filter(resource -> resource.getUserID().equals(userID)).collect(Collectors.toList());
	}

}
