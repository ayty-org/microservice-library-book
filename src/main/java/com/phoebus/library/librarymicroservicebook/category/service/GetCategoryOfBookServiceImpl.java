package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;
import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.CategoryOfBookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCategoryOfBookServiceImpl implements GetCategoryOfBookService {

    private final CategoryOfBookRepository repository;

    @Override
    public CategoryOfBookDTO getCategoryOfBook(Long id) {
        return CategoryOfBookDTO.from(repository.findById(id).orElseThrow(CategoryOfBookNotFoundException::new));
    }
}
