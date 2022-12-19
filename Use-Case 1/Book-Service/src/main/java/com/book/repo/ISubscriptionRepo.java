package com.book.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Subscription;

public interface ISubscriptionRepo extends JpaRepository<Subscription, Long> {
	List<Subscription> findByUserID(Long userID);
	
}
