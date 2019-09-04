package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBookDataFetcher implements DataFetcher<List<Book>> {

	
	@Autowired
	BookData bookData;
	
	@Override
	public List<Book> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		return bookData.booksData();
	}

}
