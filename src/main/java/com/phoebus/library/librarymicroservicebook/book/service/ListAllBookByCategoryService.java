package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;

import java.util.List;

@FunctionalInterface
public interface ListAllBookByCategoryService {
    List<BookDTO> listByCategory(String categoryName);
}
