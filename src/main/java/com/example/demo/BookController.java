package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/rest/books")
public class BookController {

	@Autowired
	GraphqlService graphqlService;

	@PostMapping
	public ResponseEntity<Object> getBooks(@RequestBody String query) {
		ExecutionResult executionResult = graphqlService.getGraphQL().execute(query);

		return new ResponseEntity<Object>(executionResult, HttpStatus.OK);
	}

}
