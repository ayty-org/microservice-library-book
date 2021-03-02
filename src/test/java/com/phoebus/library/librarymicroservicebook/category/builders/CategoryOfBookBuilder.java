package com.phoebus.library.librarymicroservicebook.category.builders;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBook;

public class CategoryOfBookBuilder {
    public static CategoryOfBook.Builder createCategoryOfBook() {
        return CategoryOfBook.builder()
                .id(1L)
                .name("action");
    }
}
