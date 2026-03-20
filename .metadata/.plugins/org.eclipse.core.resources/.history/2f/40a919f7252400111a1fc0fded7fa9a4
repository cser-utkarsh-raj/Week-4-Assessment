package com.capgemini.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")  
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;
    private Integer availableCopies;
    private Integer borrowedCopies;

    public Book() {}

	public Book(Integer id, String title, String author, Integer availableCopies, Integer borrowedCopies) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.availableCopies = availableCopies;
		this.borrowedCopies = borrowedCopies;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	public Integer getBorrowedCopies() {
		return borrowedCopies;
	}

	public void setBorrowedCopies(Integer borrowedCopies) {
		this.borrowedCopies = borrowedCopies;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", availableCopies=" + availableCopies
				+ ", borrowedCopies=" + borrowedCopies + "]";
	}

    
}
