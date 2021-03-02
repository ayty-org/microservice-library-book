package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.CategoryOfBookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCategoryOfBookServiceImpl implements DeleteCategoryOfBookService{

    private final CategoryOfBookRepository repository;

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new CategoryOfBookNotFoundException();
        }
        repository.deleteById(id);
    }
}
