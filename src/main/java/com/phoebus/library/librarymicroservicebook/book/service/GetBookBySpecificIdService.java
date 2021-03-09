package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.Book;
@FunctionalInterface
public interface GetBookBySpecificIdService {
    Book findBySpecificID(String specificID);
}
