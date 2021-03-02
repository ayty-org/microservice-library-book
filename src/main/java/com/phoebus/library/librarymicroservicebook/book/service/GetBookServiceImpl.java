package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;
import com.phoebus.library.librarymicroservicebook.book.BookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBookServiceImpl implements GetBookService {
    private final BookRepository repository;

    @Override
    public BookDTO getBookById(Long id) {
        return (BookDTO.from(repository.findById(id).orElseThrow(BookNotFoundException::new)));
    }
}
