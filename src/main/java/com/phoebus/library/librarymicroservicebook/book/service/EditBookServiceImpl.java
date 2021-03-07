package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.Book;
import com.phoebus.library.librarymicroservicebook.book.BookDTO;
import com.phoebus.library.librarymicroservicebook.book.BookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditBookServiceImpl implements EditBookService {
    private final BookRepository repository;

    @Override
    public void editBook(Long id, BookDTO bookDTO) {
        Book book = repository.findById(id).orElseThrow(BookNotFoundException::new);

        book.setId(bookDTO.getId());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setSynopsis(bookDTO.getSynopsis());
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setQuantityAvailable(bookDTO.getQuantityAvailable());
        book.setCategory(bookDTO.getCategory());
        book.setSpecificID(bookDTO.getSpecificID());

        repository.save(book);


    }
}
