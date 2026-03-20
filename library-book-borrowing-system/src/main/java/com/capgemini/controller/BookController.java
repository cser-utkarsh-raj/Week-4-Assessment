package com.capgemini.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.entity.Book;
import com.capgemini.model.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;


    @PostMapping
    public Map<String, String> addBook(@RequestBody Book book) {
        return service.addBook(book);
    }


    @GetMapping("/{id}")
    public Object getBook(@PathVariable Integer id) {
        return service.getBookById(id);
    }


    @GetMapping
    public List<Book> getAll() {
        return service.getAllBooks();
    }


    @PutMapping("/{id}")
    public Map<String, String> update(@PathVariable Integer id,
                                      @RequestBody Book book) {
        return service.updateBook(id, book);
    }


    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Integer id) {
        return service.deleteBook(id);
    }


    @PostMapping("/borrow/{id}")
    public Map<String, String> borrow(@PathVariable Integer id) {
        return service.borrowBook(id);
    }


    @PostMapping("/return/{id}")
    public Map<String, String> returnBook(@PathVariable Integer id) {
        return service.returnBook(id);
    }
}