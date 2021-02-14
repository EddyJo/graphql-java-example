package kr.co.eddy.graphql.tutorial.book.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import kr.co.eddy.graphql.tutorial.book.model.Author;
import kr.co.eddy.graphql.tutorial.book.model.Book;
import kr.co.eddy.graphql.tutorial.book.repository.AuthorRepository;
import kr.co.eddy.graphql.tutorial.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

}
