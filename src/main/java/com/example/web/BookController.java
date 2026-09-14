package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.domain.BookRepository;


@Controller
public class BookController {
    private final BookRepository repository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
}

