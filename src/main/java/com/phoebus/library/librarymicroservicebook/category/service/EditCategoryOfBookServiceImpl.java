package com.phoebus.library.librarymicroservicebook.category.service;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBook;
import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;
import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.CategoryOfBookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditCategoryOfBookServiceImpl implements EditCategoryOfBookService {
    private final CategoryOfBookRepository repository;

    @Override
    public void editCategoryOfBook(CategoryOfBookDTO categoryOfBookDTO, Long id) {
        CategoryOfBook attCategoryOfBook = repository.findById(id).orElseThrow(CategoryOfBookNotFoundException::new);

        attCategoryOfBook.setName(categoryOfBookDTO.getName());

        repository.save(attCategoryOfBook);
    }
}
