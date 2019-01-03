package com.sergeycompany.demo.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
public class AuthorJoined {

	public AuthorJoined() {}
	
	public AuthorJoined(Integer idAuthor, String firstname, String lastname, Integer idBook, String bookTitle,
			Date releaseDate) {
		this.idAuthor = idAuthor;
		this.firstname = firstname;
		this.lastname = lastname;
		this.idBook = idBook;
		this.bookTitle = bookTitle;
		this.releaseDate = releaseDate;
	}

//	@Id
//	@Column(name = "AUTHOR_ID")
	private Integer idAuthor;

//	@Column
	private String firstname;

//	@Column
	private String lastname;

//	@Column(name = "book_id")
	private Integer idBook;
	
//	@Column(name = "book_title")
	private String bookTitle;

//	@Column(name = "release_date")
//	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	public Integer getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Integer idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getIdBook() {
		return idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
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

	@Override
	public String toString() {
		return "AuthorJoined [idAuthor=" + idAuthor + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", idBook=" + idBook + ", bookTitle=" + bookTitle + ", releaseDate=" + releaseDate + "]";
	}	
}
