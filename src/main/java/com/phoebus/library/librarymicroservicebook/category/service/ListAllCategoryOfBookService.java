package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;

import java.util.List;

@FunctionalInterface
public interface ListAllCategoryOfBookService {
    List<CategoryOfBookDTO> listAllCategoryOfBook();
}
