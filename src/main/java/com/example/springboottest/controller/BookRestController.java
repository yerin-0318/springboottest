package com.example.springboottest.controller;

import com.example.springboottest.domain.Book;
import com.example.springboottest.service.BookRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookRestController {
    private final BookRestService bookRestService;

    @GetMapping(path = "/rest/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getRestBooks(){
        return bookRestService.getRestBook();
    }
}
