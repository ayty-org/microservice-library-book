package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;

@FunctionalInterface
public interface EditCategoryOfBookService {
    void editCategoryOfBook(CategoryOfBookDTO categoryOfBookDTO, Long id);
}
