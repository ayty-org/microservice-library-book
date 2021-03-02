package com.phoebus.library.librarymicroservicebook.book.service;


import com.phoebus.library.librarymicroservicebook.book.BookDTO;

@FunctionalInterface
public interface EditBookService {
    void editBook(Long id, BookDTO bookDTO);
}
