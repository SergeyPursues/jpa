//package com.sergeycompany.jpa.demo;
//
//import java.util.Date;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sergeycompany.demo.jpa.dao.BookDao;
//
//@Service
//public class RunStoredProcedure {
//	
//	@Autowired
//	private BookDao bookRepository;
//
//	
//	@PostConstruct
//	public void callStoredProcedure() {
//	int storedProcedureResult;
//		storedProcedureResult = bookRepository.addBook("Harry Potter", 
//														new Date(), 
//														"Joanne K.", 
//														"Rowling");
//		System.out.println("Stored procedure returned: " + storedProcedureResult);
//	}
//
//}
