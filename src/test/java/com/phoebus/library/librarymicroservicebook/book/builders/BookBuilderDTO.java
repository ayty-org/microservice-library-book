package com.phoebus.library.librarymicroservicebook.book.builders;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;
import com.phoebus.library.librarymicroservicebook.category.CategoryOfBook;

import java.util.HashSet;
import java.util.Set;

public class BookBuilderDTO {
    public static BookDTO.Builder createBookDTO() {
        CategoryOfBook category = new CategoryOfBook(1L,"action");
        Set<CategoryOfBook> categoryOfBookSet = new HashSet<>();
        categoryOfBookSet.add(category);

        return BookDTO.builder()
                .id(1L)
                .title("teste book")
                .synopsis("test")
                .isbn("0000")
                .author("teste")
                .price(150.2)
                .quantityAvailable(2)
                .category(categoryOfBookSet);
    }
}