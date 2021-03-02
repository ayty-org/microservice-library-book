package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBook;
import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;
import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCategoryOfBookServiceImpl implements SaveCategoryOfBookService{

    private final CategoryOfBookRepository repository;

    @Override
    public void saveCategoryOfBook(CategoryOfBookDTO categoryOfBookDTO) {
        repository.save(CategoryOfBook.to(categoryOfBookDTO));
    }
}
