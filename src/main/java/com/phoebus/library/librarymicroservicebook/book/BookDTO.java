package com.phoebus.library.librarymicroservicebook.book;


import com.phoebus.library.librarymicroservicebook.category.CategoryOfBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class BookDTO {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    @Size(min = 2)
    private String title;
    @NotNull
    @Size(min = 3)
    private String synopsis;
    @NotNull
    @Size(min = 3)
    private String isbn;
    @NotNull
    @Size(min = 3)
    private String author;
    @NotNull
    @Min(0)
    private double price;
    @NotNull
    @Min(0)
    private int quantityAvailable;
    @NotNull
    private Set<CategoryOfBook> category;
    @NotNull
    private String specificID = UUID.randomUUID().toString();



    public static BookDTO from(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .synopsis(book.getSynopsis())
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .price(book.getPrice())
                .quantityAvailable(book.getQuantityAvailable())
                .category(book.getCategory())
                .specificID(book.getSpecificID())
                .build();
    }

    public static List<BookDTO> from(List<Book> bookList) {
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (Book book: bookList) {
            bookDTOList.add(BookDTO.from(book));
        }
        return bookDTOList;
    }

    public static Page<BookDTO> from(Page<Book> pages) {
        return pages.map(BookDTO::from);
    }
}
