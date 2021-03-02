package com.phoebus.library.librarymicroservicebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(){
        super("Book Already Exists");
    }
}
