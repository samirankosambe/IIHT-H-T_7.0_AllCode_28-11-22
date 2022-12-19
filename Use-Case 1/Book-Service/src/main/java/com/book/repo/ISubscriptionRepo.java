package com.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Subscription;

public interface ISubscriptionRepo extends JpaRepository<Subscription, Long> {

}
