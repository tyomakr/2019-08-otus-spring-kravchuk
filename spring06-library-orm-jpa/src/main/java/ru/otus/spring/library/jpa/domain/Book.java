package ru.otus.spring.library.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="bookid", unique = true, nullable = false)
    private long bookId;

    @Column(name ="bookname")
    private String bookName;


    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "booksauthors", joinColumns = @JoinColumn(name = "bookid"), inverseJoinColumns = @JoinColumn(name = "authorid"))
    private List<Author> authorsList;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "booksgenres", joinColumns = @JoinColumn(name = "bookid"), inverseJoinColumns = @JoinColumn(name = "genreid"))
    private List<Genre> genresList;


    public Book(String bookName) {
        this.bookName = bookName;
        authorsList = new ArrayList<>();
        genresList = new ArrayList<>();
    }

    public Book(String bookName, Author author, Genre genre) {
        this.bookName = bookName;
        authorsList = new ArrayList<>(Collections.singletonList(author));
        genresList = new ArrayList<>(Collections.singletonList(genre));
    }
}
