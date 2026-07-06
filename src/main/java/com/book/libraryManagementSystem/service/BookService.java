package com.book.libraryManagementSystem.service;

import com.book.libraryManagementSystem.entity.Book;
import com.book.libraryManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.libraryManagementSystem.entity.BookStatus;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {

        book.setStatus(BookStatus.AVAILABLE);

        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {

        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            return book.get();
        }

        return null;
    }

    public Book updateBook(Long id, Book updatedBook) {

        Optional<Book> existingBook = bookRepository.findById(id);

        if (existingBook.isPresent()) {

            Book book = existingBook.get();

            book.setTitle(updatedBook.getTitle());
            book.setIsbn(updatedBook.getIsbn());
            book.setPrice(updatedBook.getPrice());
            book.setQuantity(updatedBook.getQuantity());

            return bookRepository.save(book);
        }

        return null;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}