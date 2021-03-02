package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@FunctionalInterface
public interface ListPageCategoryOfBookService {
    Page<CategoryOfBookDTO> listPageCategoryOfBook(Pageable pageable);
}
