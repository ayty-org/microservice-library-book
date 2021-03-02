package com.phoebus.library.librarymicroservicebook.book.service;

import com.phoebus.library.librarymicroservicebook.book.Book;
import com.phoebus.library.librarymicroservicebook.book.BookDTO;
import com.phoebus.library.librarymicroservicebook.book.BookRepository;
import com.phoebus.library.librarymicroservicebook.exceptions.BookAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveBookServiceImpl implements SaveBookService{
    private final BookRepository repository;

    @Override
    public void saveBook(BookDTO bookDTO) {
        List<Book> listBook = repository.findAll();
        for (Book book: listBook) {
            if(book.getIsbn().equals(bookDTO.getIsbn())){
                throw new BookAlreadyExistsException();
            }
        }
        repository.save(Book.to(bookDTO));
    }
}
