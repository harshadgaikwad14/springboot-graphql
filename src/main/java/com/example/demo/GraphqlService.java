package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphqlService {

	@Value("classpath:books.graphql")
	Resource resource;

	private GraphQL graphQL;

	@Autowired
	AllBookDataFetcher allBookDataFetcher;
	@Autowired
	BookDataFetcher bookDataFetcher;

	@Autowired
	BookData bookData;

	@PostConstruct
	private void loadSchema() throws IOException {

		File fileSchema = resource.getFile();

		TypeDefinitionRegistry tdr = new SchemaParser().parse(fileSchema);
		RuntimeWiring rw = buildRuntimeWiring();
		GraphQLSchema gs = new SchemaGenerator().makeExecutableSchema(tdr, rw);
		graphQL = GraphQL.newGraphQL(gs).build();
	}

	/*
	 * private RuntimeWiring buildRuntimeWiring() {
	 * 
	 * return RuntimeWiring.newRuntimeWiring()
	 * 
	 * .type("Query", typeWiring -> typeWiring.dataFetcher("allBooks",
	 * allBookDataFetcher).dataFetcher("book", bookDataFetcher)) .build();
	 * 
	 * }
	 */

	// Alternative Way
	private RuntimeWiring buildRuntimeWiring() {

		DataFetcher<List<Book>> getBooks = data -> {

			return bookData.booksData();

		};

		DataFetcher<Book> findById = data -> {

			return bookData.book(data.getArgument("id"));

		};
		return RuntimeWiring.newRuntimeWiring()

				.type("Query", typeWiring -> typeWiring.dataFetcher("allBooks", getBooks).dataFetcher("book", findById))
				.build();

	}

	public GraphQL getGraphQL() {
		return graphQL;
	}

}
