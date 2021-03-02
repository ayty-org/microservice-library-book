package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;

import java.util.List;

@FunctionalInterface
public interface ListAllBookService {
    List<BookDTO> listAllBooks();
}
