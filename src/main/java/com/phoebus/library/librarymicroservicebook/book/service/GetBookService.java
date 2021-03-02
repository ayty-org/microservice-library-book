package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;

@FunctionalInterface
public interface GetBookService {
    BookDTO getBookById(Long id);
}
