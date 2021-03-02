package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;
import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListPageCategoryOfBookServiceImpl implements ListPageCategoryOfBookService{

    private final CategoryOfBookRepository repository;

    @Override
    public Page<CategoryOfBookDTO> listPageCategoryOfBook(Pageable pageable) {
        return CategoryOfBookDTO.from(repository.findAll(pageable));
    }
}
