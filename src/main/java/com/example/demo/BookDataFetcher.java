package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

	@Autowired
	BookData bookData;

	@Override
	public Book get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub

		String id = environment.getArgument("id");
		return bookData.book(id);
	}

}
