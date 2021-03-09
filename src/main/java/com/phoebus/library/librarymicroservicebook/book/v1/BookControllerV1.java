package com.phoebus.library.librarymicroservicebook.book.v1;

import com.phoebus.library.librarymicroservicebook.book.BookDTO;
import com.phoebus.library.librarymicroservicebook.book.service.DeleteBookService;
import com.phoebus.library.librarymicroservicebook.book.service.EditBookService;
import com.phoebus.library.librarymicroservicebook.book.service.GetBookBySpecificIdService;
import com.phoebus.library.librarymicroservicebook.book.service.GetBookService;
import com.phoebus.library.librarymicroservicebook.book.service.ListAllBookByCategoryService;
import com.phoebus.library.librarymicroservicebook.book.service.ListAllBookService;
import com.phoebus.library.librarymicroservicebook.book.service.ListPageBookService;
import com.phoebus.library.librarymicroservicebook.book.service.SaveBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/book")
public class BookControllerV1 {
    private final DeleteBookService deleteBookService;
    private final EditBookService editBookService;
    private final GetBookService getBookService;
    private final ListAllBookService listBookService;
    private final SaveBookService saveBookService;
    private final ListPageBookService listPageBookService;
    private final ListAllBookByCategoryService listAllBooksByCategory;
    private final GetBookBySpecificIdService getBookBySpecificIdService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody @Valid BookDTO newBook) {
        saveBookService.saveBook(newBook);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable(value = "id") Long id) {
        deleteBookService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editBook(@PathVariable(value = "id")Long id, @RequestBody BookDTO bookDTO) {
        editBookService.editBook(id,bookDTO);
    }

    @GetMapping("/listbook/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> listAllByCategory(@PathVariable(value = "category") String category) {
        return listAllBooksByCategory.listByCategory(category);
    }

    @GetMapping(value = "/id/{specificID}") //list client by id
    public BookDTO findSpecificID(@PathVariable(value = "specificID") String specificID) {
        return BookDTO.from(getBookBySpecificIdService.findBySpecificID(specificID));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO bookById(@PathVariable(value = "id") Long id) {
        return getBookService.getBookById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> listOfBooks() {
        return listBookService.listAllBooks();
    }

    @GetMapping("/page")
    @ResponseStatus(HttpStatus.OK)
    public Page<BookDTO> findPage(Pageable pageable) {
        return listPageBookService.listPageBook(pageable);
    }
}
