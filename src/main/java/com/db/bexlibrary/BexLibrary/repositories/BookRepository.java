package com.db.bexlibrary.BexLibrary.repositories;

import com.db.bexlibrary.BexLibrary.entities.Author;
import com.db.bexlibrary.BexLibrary.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(Long id);

    List<Book> findBookByAuthor(String author);


    List<Book> findBooksByTitleContaining(String title);

    @Query("update Book b set b.noAvailableCopies=b.noAvailableCopies-1 where b.id=?1")
    @Modifying
    void updateBook(Long id);

    List<Book> findBooksByAuthor(Author a);

}


