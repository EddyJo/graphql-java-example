package kr.co.eddy.graphql.tutorial.book.repository;

import kr.co.eddy.graphql.tutorial.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
