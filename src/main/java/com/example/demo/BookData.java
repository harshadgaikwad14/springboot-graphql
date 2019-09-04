package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookData {

	public static final List<Book> books = new ArrayList<>();

	static {

		Book b1 = new Book();
		b1.setIsbn("1");
		b1.setPublisher("Publisher1");
		b1.setTitle("Title1");
		b1.setAuthors(new String [] {"Author1", "Author12" });
		b1.setPublishedDate("01-01-2019");
		b1.setRoles(Arrays.asList("Role1","Role2"));

		Book b2 = new Book();
		b2.setIsbn("2");
		b2.setPublisher("Publisher2");
		b2.setTitle("Title2");
		b2.setAuthors(new String [] {"Author1", "Author12" });
		b2.setPublishedDate("01-02-2019");
		b2.setRoles(Arrays.asList("Role1","Role2"));

		books.add(b1);
		books.add(b2);

	}

	public List<Book> booksData() {
		return books;

	}

	public Book book(final String id) {
		return books.stream().filter(b -> b.getIsbn().equalsIgnoreCase(id)).findAny().get();

	}

}
