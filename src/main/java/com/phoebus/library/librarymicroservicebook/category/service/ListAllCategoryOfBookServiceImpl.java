package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;
import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.CategoryOfBookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAllCategoryOfBookServiceImpl implements ListAllCategoryOfBookService{

    private final CategoryOfBookRepository repository;

    @Override
    public List<CategoryOfBookDTO> listAllCategoryOfBook() {
        if(repository.findAll().isEmpty()) {
            throw new CategoryOfBookNotFoundException();
        }
        return CategoryOfBookDTO.from(repository.findAll());
    }
}
