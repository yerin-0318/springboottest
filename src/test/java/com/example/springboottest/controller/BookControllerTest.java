package com.example.springboottest.controller;
import com.example.springboottest.domain.Book;
import com.example.springboottest.service.BookService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private BookService bookService;

    @Test
    public void Book_MVC_Test() throws Exception{
        Book book = new Book();
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));

        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("book"))
                .andExpect(model().attributeExists("bookList"))
                .andExpect(model().attribute("bookList",contains(book)));
    }
}
