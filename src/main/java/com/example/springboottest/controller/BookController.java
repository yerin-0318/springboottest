package com.example.springboottest.controller;

import com.example.springboottest.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public String getBookList(Model model){
        model.addAttribute("bookList",bookService.getBookList());
        return "book";
    }
}
