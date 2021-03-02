package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;

@FunctionalInterface
public interface SaveCategoryOfBookService {
    void saveCategoryOfBook(CategoryOfBookDTO categoryOfBookDTO);
}
