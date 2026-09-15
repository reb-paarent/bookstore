package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.BookRepository;
import com.example.domain.Book;


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

    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	repository.deleteById(id);
        return "redirect:/booklist";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String showModStu(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", repository.findById(id));
        return "editbook";
    }
}

