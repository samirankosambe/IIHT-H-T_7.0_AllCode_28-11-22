package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.repo.IBookRepo;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookRepo bookRepo;
}
