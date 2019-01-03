package com.sergeycompany.demo.jpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOOK")
@NamedStoredProcedureQuery(
		name = "addBook_sp", 
		procedureName = "addBook", 
			parameters = {
			@StoredProcedureParameter(name = "bookName", mode = ParameterMode.IN, type = String.class),
			@StoredProcedureParameter(name = "bookReleaseDate", mode = ParameterMode.IN, type = Date.class),
			@StoredProcedureParameter(name = "authorFirstname", mode = ParameterMode.IN, type = String.class),
			@StoredProcedureParameter(name = "authorLastname", mode = ParameterMode.IN, type = String.class), 
		})
public class Book {

//	private static final long serialVersionUID = -8105130932670794882L;
	
	public Book() {}
	
	public Book(Integer id, String bookTitle, Date releaseDate, Author author) {
		this.id = id;
		this.bookTitle = bookTitle;
		this.releaseDate = releaseDate;
		this.author = author;
	}

	@Id
	@SequenceGenerator(name = "idbook_seq", sequenceName = "idbook_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idbook_seq")
	@Column(name = "book_id")
	private Integer id;

	@Column(name = "book_title")
	private String bookTitle;

	@Column(name = "release_date")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;

//	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//			CascadeType.DETACH, CascadeType.REFRESH})
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private Author author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookTitle=" + bookTitle + ", releaseDate=" + releaseDate + ", author=" + author
				+ "]";
	}
	
}
