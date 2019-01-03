package com.sergeycompany.demo.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sergeycompany.demo.jpa.model.Author;
import com.sergeycompany.demo.jpa.model.AuthorJoined;


public interface AuthorDao extends CrudRepository<Author, Integer> {
//	List<Author> bla(String lastname) - No property bla found for type Author!
	List<Author> findByLastname(String lastname);
	
	long deleteByLastname(String lastname);
	
//	@Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//	  User findByEmailAddress(String emailAddress);
	
	@Query(value = "select author.author_id, author.firstname, author.lastname, book.book_id, book.book_title, book.release_date\r\n" + 
			"from author\r\n" + 
			"inner join book on author.author_id = book.author_id", nativeQuery = true)
	List<AuthorJoined> findJoinedByLastname(String lastname);
}
