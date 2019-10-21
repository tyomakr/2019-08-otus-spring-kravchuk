package ru.otus.spring.data.jpa.repository;


import ru.otus.spring.data.jpa.domain.Book;
import ru.otus.spring.data.jpa.domain.Comment;

import java.util.List;

public interface CommentsRepository {

    List<Comment> findCommentsFromBook(Book book);

    Comment findCommentById(Long id);

    void saveComment(Comment c);

    void deleteComment(Comment c);
}
