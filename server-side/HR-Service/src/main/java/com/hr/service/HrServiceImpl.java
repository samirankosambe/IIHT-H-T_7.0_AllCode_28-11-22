package com.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.entity.HR;

@Service
public class HrServiceImpl implements IHrService {

	List<HR> hrList = List.of(
			new HR(1001l, "Vivek", "8149593575"), 
			new HR(1002l, "Abhi", "8855050428"),
			new HR(1003l, "Shiva", "8421595915"), 
			new HR(1004l, "Jay", "9309511114"),
			new HR(1005l, "Priya", "9657424098"), 
			new HR(1006l, "Varsha", "9512223522"));

	@Override
	public HR getHr(Long id) {

		return hrList.stream().filter(hr -> hr.getUserID().equals(id)).findAny().orElse(null);
	}

}
