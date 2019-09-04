package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class Book {
	
	private String isbn;
	private String title;
	private String publisher;
	private String [] authors;
	private String publishedDate;
	private List<String> roles;
	
	
	
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", publishedDate=" + publishedDate + "]";
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
