package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.Book;
import com.phoebus.library.librarymicroservicebook.book.BookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetBookBySpecificIdServiceImpl implements GetBookBySpecificIdService{
    private final BookRepository repository;
    @Override
    public Book findBySpecificID(String specificID) {
        return repository.findBySpecificID(specificID).orElseThrow(BookNotFoundException::new);
    }
}
