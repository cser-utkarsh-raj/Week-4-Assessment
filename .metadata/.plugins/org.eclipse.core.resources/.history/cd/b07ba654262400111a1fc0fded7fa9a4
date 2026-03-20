package com.capgemini.model.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Book;
import com.capgemini.model.repository.BookRepository;
import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Map<String, String> addBook(Book book) {

        if (book.getAvailableCopies() < 0) {
            return Map.of("message", "availableCopies cannot be negative");
        }

        book.setBorrowedCopies(0);

        bookRepository.save(book);

        return Map.of("message", "Book added successfully");
    }


    public Object getBookById(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Book not found");
        }

        return optional.get();
    }

    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Map<String, String> updateBook(Integer id, Book updatedBook) {

        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Book not found");
        }

        if (updatedBook.getAvailableCopies() < 0) {
            return Map.of("message", "availableCopies cannot be negative");
        }

        Book existing = optional.get();

        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor());
        existing.setAvailableCopies(updatedBook.getAvailableCopies());

        bookRepository.save(existing);

        return Map.of("message", "Book updated successfully");
    }


    public Map<String, String> deleteBook(Integer id) {

        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Book not found");
        }

        bookRepository.deleteById(id);

        return Map.of("message", "Book deleted successfully");
    }

    
    public Map<String, String> borrowBook(Integer id) {

        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Book not found");
        }

        Book book = optional.get();

        if (book.getAvailableCopies() == 0) {
            return Map.of("message", "No copies available");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        book.setBorrowedCopies(book.getBorrowedCopies() + 1);

        bookRepository.save(book);

        return Map.of("message", "Book borrowed successfully");
    }

    
    public Map<String, String> returnBook(Integer id) {

        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Book not found");
        }

        Book book = optional.get();

        if (book.getBorrowedCopies() == 0) {
            return Map.of("message", "No borrowed books to return");
        }

        book.setBorrowedCopies(book.getBorrowedCopies() - 1);
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        bookRepository.save(book);

        return Map.of("message", "Book returned successfully");
    }
}