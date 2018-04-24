package com.db.bexlibrary.BexLibrary.repositories;

import com.db.bexlibrary.BexLibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Long> {

        Book findBookById(Long id);
        List<Book> findBookByAuthor(String author);
        List<Book> findBookByTitle(String title);
        Book findBookById(int id);
        List<Book> findBooksByTitleLike(String title);
        List<Book> findBooksByAuthorLike(String author);
        List<Book> findBooksByTitleContaining(String title);
}
