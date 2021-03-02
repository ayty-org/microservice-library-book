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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String synopsis;

    @Column(unique = true)
    private String isbn;

    private String author;
    private double price;
    private int quantityAvailable;

    @ManyToMany(cascade = CascadeType.DETACH)
    @PrimaryKeyJoinColumn
    private Set<CategoryOfBook> category;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID specificID = UUID.randomUUID();


    public static Book to(BookDTO bookDTO) {
        return Book.builder()
                .id(bookDTO.getId())
                .title(bookDTO.getTitle())
                .synopsis(bookDTO.getSynopsis())
                .isbn(bookDTO.getIsbn())
                .author(bookDTO.getAuthor())
                .price(bookDTO.getPrice())
                .quantityAvailable(bookDTO.getQuantityAvailable())
                .category(bookDTO.getCategory())
                .specificID(bookDTO.getSpecificID())
                .build();
    }

    public static List<Book> to(List<BookDTO> books) {
        List<Book> bookList = new ArrayList<>();
        for (BookDTO bookDTO: books) {
            bookList.add(Book.to(bookDTO));
        }
        return bookList;
    }

    public static Page<Book> to(Page<BookDTO> pages) {
        return pages.map(Book::to);
    }


}
