package ru.otus.spring.library.springjdbc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import ru.otus.spring.library.springjdbc.dao.AuthorDao;
import ru.otus.spring.library.springjdbc.domain.Author;
import ru.otus.spring.library.springjdbc.service.AuthorService;
import ru.otus.spring.library.springjdbc.service.ConsoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;
    private final MessageSource ms;
    private final ConsoleService cs = new ConsoleService();

    public void getAllAuthors() {
        cs.printMsg(ms.getMessage("as.str.get.all", null, LocaleContextHolder.getLocale()));
        List<Author> authorList = authorDao.getAll();
        for (Author author : authorList) {
            cs.printMsg(author.getId() + ". " +author.getAuthorName());
        }
    }

    @Override
    public void addAuthor(String authorName) {
        Author author = new Author(authorName);
        if (!isAuthorExists(author)) {
            authorDao.insert(author);
            cs.printMsg(ms.getMessage("as.str.add", null, LocaleContextHolder.getLocale()));
        } else {
            cs.printMsg(ms.getMessage("as.err.exists", null, LocaleContextHolder.getLocale()));
        }
    }

    @Override
    public void updateAuthor(String oldAuthorName, String newAuthorName) {
        Author oldAuthor = new Author(oldAuthorName);
        if (isAuthorExists(oldAuthor)) {
            oldAuthor = authorDao.getByName(oldAuthorName);
            authorDao.update(oldAuthor, newAuthorName);
            cs.printMsg(ms.getMessage("as.str.upd", null, LocaleContextHolder.getLocale()));
        } else {
            cs.printMsg(ms.getMessage("as.err.not.found", null, LocaleContextHolder.getLocale()));
        }
    }

    @Override
    public boolean isAuthorExists(Author author) {
        List<Author> authorList = authorDao.getAll();
        for (Author value : authorList) {
            if (value.getAuthorName().equalsIgnoreCase(author.getAuthorName())) {
                return true;
            }
        }
        return false;
    }


}
