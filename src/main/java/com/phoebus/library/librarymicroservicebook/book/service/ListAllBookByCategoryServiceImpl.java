package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;
import com.phoebus.library.librarymicroservicebook.book.BookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAllBookByCategoryServiceImpl implements ListAllBookByCategoryService {

    private final BookRepository repository;

    @Override
    public List<BookDTO> listByCategory(String categoryName) {
        if(repository.findBookByCategoryName(categoryName).isEmpty()){
            throw new BookNotFoundException();
        }
        return BookDTO.from(repository.findBookByCategoryName(categoryName));
    }
}
