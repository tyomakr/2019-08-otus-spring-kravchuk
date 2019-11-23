package ru.otus.spring.library.webmvc.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.library.webmvc.domain.Book;
import ru.otus.spring.library.webmvc.mapper.BookMapper;
import ru.otus.spring.library.webmvc.rest.dto.BookDto;
import ru.otus.spring.library.webmvc.service.AuthorService;
import ru.otus.spring.library.webmvc.service.BookService;
import ru.otus.spring.library.webmvc.service.GenreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookMapper bookMapper;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookMapper.domainToDto(bookService.findAll()));
    }


    @PostMapping(value = "/books/create")
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.insertBook(bookDto.getTitle(), bookDto.getAuthors(), bookDto.getGenres());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
        Optional<Book> optionalBook = bookService.findById(id);
        return optionalBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/books/update/{id}")
    public void updateBook(@PathVariable("id") String id, @RequestBody Book book) {
        bookService.updateBookTitle(book);
    }

//    @GetMapping("/books/edit")
//    public void editBook(@RequestParam("id") String bookId, Model model) {
//        Optional<Book> optionalBook = bookService.findById(bookId);
//        optionalBook.ifPresent(book -> {
//
//            model.addAttribute("availableAuthorsList", authorService.findAll().stream().filter(author -> !book.getAuthors().contains(author)).collect(Collectors.toList()));
//            model.addAttribute("availableGenresList", genreService.findAll().stream().filter(genre -> !book.getGenres().contains(genre)).collect(Collectors.toList()));
////            model.addAttribute("bookCommentsList", cs.findAllCommentsByBookId(bookId));
//            model.addAttribute(book);
//        });
//    }

}
