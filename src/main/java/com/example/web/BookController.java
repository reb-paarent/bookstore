package com.example.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.BookRepository;
import com.example.domain.Book;
import com.example.domain.CategoryRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
public class BookController {
    @Autowired
	private BookRepository repository; 

	@Autowired
	private CategoryRepository crepository; 

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    //Show all books
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    //Add new book
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }     
    
    //Save book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }    

    //Delete book
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	repository.deleteById(id);
        return "redirect:/booklist";
    }
    
    //Edit book
    @RequestMapping(value = "/edit/{id}")
    public String showModStu(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", repository.findById(id));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }

    //Return all books REST
    @RequestMapping(value="/books", method=RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    } 
     
    //Return book by id REST 
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long BookId) {	
    	return repository.findById(BookId);
    } 
}

