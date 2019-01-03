package com.sergeycompany.jpa.demo;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.sergeycompany.demo.jpa.dao.AuthorDao;
import com.sergeycompany.demo.jpa.dao.BookDao;
import com.sergeycompany.demo.jpa.model.Author;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.sergeycompany.demo.jpa.model"})
@ComponentScan(basePackages = {
        "com.sergeycompany.demo.jpa.demo",
        "com.sergeycompany.demo.jpa.dao"
    })
@EnableJpaRepositories(basePackages = {
        "com.sergeycompany.demo.jpa.demo",
        "com.sergeycompany.demo.jpa.dao"
	})
public class JpaDemoApplication implements CommandLineRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger("JpaDemoApplication");
	
	@Autowired
	private BookDao bookRepository;
	
	@Autowired
	private AuthorDao authorRepository;
	
//	@PersistenceContext
//    private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... strings) {
		
//		String bookName = "Design Patterns: Elements of Reusable Object-Oriented Software";
//		String authorFirstname = "Gang";
//		String authorLastname = "of four";
//		 
//		// Getting the named stored procedure from the persistence unit and settting the parameters values.
//		StoredProcedureQuery addBookNamedStoredProcedure = entityManager.createNamedStoredProcedureQuery("addBook_sp");
//		addBookNamedStoredProcedure.setParameter("bookName", bookName);
//		addBookNamedStoredProcedure.setParameter("bookReleaseDate", new Date(), TemporalType.DATE);
//		addBookNamedStoredProcedure.setParameter("authorFirstname", authorFirstname);
//		addBookNamedStoredProcedure.setParameter("authorLastname", authorLastname);
//		 
//		// Stored procedure call
//		Integer createdBookId = (Integer) addBookNamedStoredProcedure.getSingleResult();
//		LOG.info("Result: " + createdBookId);

		int storedProcedureResult = bookRepository.addBook("Harry Potter", 
														new Date(), 
														"Joanne K.", 
														"Mapp");
		LOG.info("Result: inserted the book @" + storedProcedureResult);
		
//		authorRepository.deleteById(1);
//		LOG.info("Result: deleted the book @ 1");
		
		List<Author> author = authorRepository.findByLastname("Mapp");
		
		long resultBackwardDelete = bookRepository.deleteByAuthor(author.get(0));
		LOG.info("Deleted book with author_id = 7");
		
//		List<Author> list = authorRepository.findByLastname("Mapp");
//		for(Author a:list) {
//			LOG.info("Authors with last name Mapp:" + a);
//	    }
//		List<AuthorJoined> listJoined = authorRepository.findJoinedByLastname("Mapp");
//		
//		for(AuthorJoined a:listJoined) {
//			LOG.info("Authors + books with last name Mapp:" + a);
//		}	
	}	
	
	
}

