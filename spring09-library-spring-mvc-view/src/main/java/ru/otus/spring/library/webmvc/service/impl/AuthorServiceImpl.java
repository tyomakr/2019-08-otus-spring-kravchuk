package ru.otus.spring.library.webmvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.library.webmvc.domain.Author;
import ru.otus.spring.library.webmvc.repository.AuthorRepository;
import ru.otus.spring.library.webmvc.service.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Optional<Author> findById(String authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }


    @Override
    public Author findOrCreateAuthor(String bookAuthor) {
        Optional<Author> authorOptional = authorRepository.findAuthorByAuthorName(bookAuthor);
        return authorRepository.save(authorOptional.orElseGet(() -> new Author(bookAuthor)));
    }
}


