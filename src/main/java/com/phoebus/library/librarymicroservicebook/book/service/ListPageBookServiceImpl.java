package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;
import com.phoebus.library.librarymicroservicebook.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListPageBookServiceImpl implements ListPageBookService{
    private final BookRepository repository;
    @Override
    public Page<BookDTO> listPageBook(Pageable pageable) {
        return BookDTO.from(repository.findAll(pageable));
    }
}
