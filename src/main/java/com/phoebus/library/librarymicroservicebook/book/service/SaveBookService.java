package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;

@FunctionalInterface
public interface SaveBookService {
    void saveBook(BookDTO bookDTO);
}
