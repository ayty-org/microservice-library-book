package com.phoebus.library.librarymicroservicebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryOfBookAlreadyExistsException extends RuntimeException{
    public CategoryOfBookAlreadyExistsException() {
        super("Category of Book alredy exists");
    }
}
