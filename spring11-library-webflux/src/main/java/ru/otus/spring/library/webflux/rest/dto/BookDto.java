package ru.otus.spring.library.webflux.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.otus.spring.library.webflux.domain.Author;
import ru.otus.spring.library.webflux.domain.Book;
import ru.otus.spring.library.webflux.domain.Genre;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class BookDto {

    private String id;
    private String title;
    private String authors;
    private String genres;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getTitle(), authorsToString(book.getAuthors()), genresToString(book.getGenres()));
    }

    public static Book toDomain(BookDto bookDto) {

        return new Book(bookDto.getTitle(),
                Collections.singletonList(new Author(bookDto.getAuthors())),
                Collections.singletonList(new Genre(bookDto.getGenres())));
    }


    private static String authorsToString(List<Author> authors) {
        return authors.stream().map(Author::getAuthorName).collect(Collectors.joining(" / "));
    }

    private static String genresToString(List<Genre> genres) {
        return genres.stream().map(Genre::getGenreTitle).collect(Collectors.joining(" / "));
    }

}
