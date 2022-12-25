package com.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	
	@Query("select u.role from User u where u.userID =:userId")
	String getRoleByUserId(@Param("userId") Long userId);
	
}
