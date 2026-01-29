package com.example.sharebookbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "books")
@Getter @Setter @NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "author", nullable = false, length = 255)
    private String author;

    @Column(name = "image", length = 500)
    private String image;


    public Book(String name, String address, String author, String image) {
        this.name = name;
        this.address = address;
        this.author = author;
        this.image = image;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", address='" + address + '\'' +  // добавили
                '}';
    }
}
