package com.phoebus.library.librarymicroservicebook.category;
import com.phoebus.library.librarymicroservicebook.category.service.ListAllCategoryOfBookService;
import com.phoebus.library.librarymicroservicebook.category.service.ListAllCategoryOfBookServiceImpl;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.phoebus.library.librarymicroservicebook.category.builders.CategoryOfBookBuilder.createCategoryOfBook;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test to verify List Category Of Book Service")
public class ListAllCategoryOfBookServiceTest {
    @Mock
    private CategoryOfBookRepository repository;

    private ListAllCategoryOfBookServiceImpl listCategoryOfBookServiceImpl;

    @BeforeEach
    void setUp() {
        this.listCategoryOfBookServiceImpl = new ListAllCategoryOfBookServiceImpl(repository);
    }

    @Test
    @DisplayName("Test to verify if could list all category of book when successful")
    void shouldGetListCategoryOfBook() {
        CategoryOfBook categoryOfBook = createCategoryOfBook().build();
        List<CategoryOfBook> categoryOfBookList = new ArrayList<>();
        categoryOfBookList.add(categoryOfBook);

        when(repository.findAll()).thenReturn(categoryOfBookList);

        List<CategoryOfBookDTO> result = listCategoryOfBookServiceImpl.listAllCategoryOfBook();

        assertAll("Category of Book",
                () -> assertThat(result.get(0).getName(), is("action")));


    }
}