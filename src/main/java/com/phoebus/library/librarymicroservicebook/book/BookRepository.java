package com.phoebus.library.librarymicroservicebook.book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findBookByCategoryName(String categoryName);
    Optional<Book> findBySpecificID(String specificID);
}
