package com.library.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;

@Repository
public interface ILibraryRepo extends JpaRepository<Book, Long> {
	Optional<Book> findByName(String name);
}
