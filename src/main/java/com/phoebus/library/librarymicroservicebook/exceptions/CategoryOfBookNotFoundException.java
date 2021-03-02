package com.phoebus.library.librarymicroservicebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryOfBookNotFoundException extends RuntimeException{
    public CategoryOfBookNotFoundException() {
        super("Category of Book Not Found");
    }
}
