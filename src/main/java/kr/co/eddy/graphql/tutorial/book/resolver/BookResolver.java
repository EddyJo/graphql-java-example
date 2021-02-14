package kr.co.eddy.graphql.tutorial.book.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import kr.co.eddy.graphql.tutorial.book.model.Author;
import kr.co.eddy.graphql.tutorial.book.model.Book;
import kr.co.eddy.graphql.tutorial.book.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorRepository authorRepository;

    @Autowired
    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElseThrow(null);
    }

}
