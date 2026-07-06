package com.book.libraryManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    private Double price;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private BookStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Book(){

    }

    public Book(Long id, String title, String isbn, Double price,
                Integer quantity, BookStatus status) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }
}