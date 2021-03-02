package com.phoebus.library.librarymicroservicebook.category.builders;

import com.phoebus.library.librarymicroservicebook.category.CategoryOfBookDTO;

public class CategoryOfBookBuilderDTO {
    public static CategoryOfBookDTO.Builder createCategoryOfBookDTO() {
        return CategoryOfBookDTO.builder()
                .id(1L)
                .name("action");

    }

}