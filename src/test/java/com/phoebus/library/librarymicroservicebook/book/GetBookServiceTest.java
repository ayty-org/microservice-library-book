package com.phoebus.library.librarymicroservicebook.book;

import com.phoebus.library.librarymicroservicebook.book.service.GetBookServiceImpl;
import com.phoebus.library.librarymicroservicebook.exceptions.BookNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.phoebus.library.librarymicroservicebook.book.builders.BookBuilder.createBook;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("Service")
@DisplayName("Test to verify if could get a book")
public class GetBookServiceTest {

    @Mock
    private BookRepository repository;

    private GetBookServiceImpl getBookServiceImpl;

    @BeforeEach
    void setUp() {
        this.getBookServiceImpl = new GetBookServiceImpl(repository);
    }

    @Test
    @DisplayName("Should get a book by id")
    void shouldGetBook() {
        Optional<Book> bookOptional = Optional.of(createBook().build());

        when(repository.findById(anyLong())).thenReturn(bookOptional);

        BookDTO result = this.getBookServiceImpl.getBookById(1L);


        assertAll("Book",
                () -> assertThat(result.getTitle(), is("teste book")),
                () -> assertThat(result.getAuthor(), is("teste")),
                () -> assertThat(result.getIsbn(),is("0000")),
                () -> assertThat(result.getAuthor(), is("teste")),
                () -> assertThat(result.getPrice(), is(150.2)),
                () -> assertThat(result.getQuantityAvailable(), is(2)),
                () -> assertThat(result.getSynopsis(), is("test")),
                () -> assertThat(result.getCategory(), is((bookOptional.get().getCategory())))
        );
    }

    @Test
    @DisplayName("Should not returns a book")
    void shouldNotGetBook() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(BookNotFoundException.class, () -> getBookServiceImpl.getBookById(1L));

        verify(repository).findById(anyLong());
    }

}