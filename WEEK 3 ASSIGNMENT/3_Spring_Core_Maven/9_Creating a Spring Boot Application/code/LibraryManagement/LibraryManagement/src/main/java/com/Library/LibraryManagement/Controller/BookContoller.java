package com.Library.LibraryManagement.Controller;
import com.Library.LibraryManagement.entity.Book;
import com.Library.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")

public class BookContoller {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public String createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "Book Data entered successfully";
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            return bookRepository.save(book);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookId(@PathVariable Long id)
    {
        bookRepository.deleteById(id);
        return ResponseEntity.ok("book Deleted successfully");
    }

}

