package kr.co.eddy.graphql.tutorial.book.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import kr.co.eddy.graphql.tutorial.book.model.Author;
import kr.co.eddy.graphql.tutorial.book.model.Book;
import kr.co.eddy.graphql.tutorial.book.repository.AuthorRepository;
import kr.co.eddy.graphql.tutorial.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(String firstName, String lastName) {
        Author author = Author.builder().firstName(firstName)
                                        .lastName(lastName)
                                        .build();

        authorRepository.save(author);

        return author;
    }

    public Book createBook(String name, int pageCounnt, Long author) {
        Book book = Book.builder().name(name)
                                  .pageCount(pageCounnt)
                                  .author(Author.builder().id(author).build())
                                  .build();

        bookRepository.save(book);

        return book;
    }
}
