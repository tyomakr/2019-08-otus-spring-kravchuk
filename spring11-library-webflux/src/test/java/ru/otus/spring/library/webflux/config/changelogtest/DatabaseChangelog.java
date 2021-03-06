package ru.otus.spring.library.webflux.config.changelogtest;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.spring.library.webflux.domain.Author;
import ru.otus.spring.library.webflux.domain.Book;
import ru.otus.spring.library.webflux.domain.Comment;
import ru.otus.spring.library.webflux.domain.Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

@ChangeLog
public class DatabaseChangelog {

    private final List<Author> authorList = new ArrayList<>();
    private final List<Genre> genreList = new ArrayList<>();
    private final List<Book> bookList = new ArrayList<>();

    @ChangeSet(order = "001", id = "dropDb", author = "tyomakr", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertAuthors", author = "tyomakr", runAlways = true)
    public void insertAuthors(MongoTemplate mt) {
        authorList.add(mt.save(new Author("Джон Рональд Руэл Толкин")));
        authorList.add(mt.save(new Author("Роджер Желязны")));
        authorList.add(mt.save(new Author("Теодор Драйзер")));
        authorList.add(mt.save(new Author("Дэн Симмонс")));
        authorList.add(mt.save(new Author("Джеральд Даррелл")));
        authorList.add(mt.save(new Author("Федор Достоевский")));
        authorList.add(mt.save(new Author("Агата Кристи")));
        authorList.add(mt.save(new Author("Артур Конан Дойл")));
        authorList.add(mt.save(new Author("Александр Дюма")));
        authorList.add(mt.save(new Author("Анджей Сапковский")));
        authorList.add(mt.save(new Author("Данте Алигьери")));
        authorList.add(mt.save(new Author("Кэти Сьерра")));
        authorList.add(mt.save(new Author("Берт Бейтс")));
    }

    @ChangeSet(order = "003", id = "insertGenres", author = "tyomakr", runAlways = true)
    public void fillGenreList(MongoTemplate mt) {
        genreList.add(mt.save(new Genre("Фэнтези")));
        genreList.add(mt.save(new Genre("Фантастика")));
        genreList.add(mt.save(new Genre("Детектив")));
        genreList.add(mt.save(new Genre("Мемуары")));
        genreList.add(mt.save(new Genre("Роман")));
        genreList.add(mt.save(new Genre("Поэма")));
        genreList.add(mt.save(new Genre("Техническая литература")));
        genreList.add(mt.save(new Genre("Программирование")));
        genreList.add(mt.save(new Genre("Автобиография")));
        genreList.add(mt.save(new Genre("Исторический роман")));
    }

    @ChangeSet(order = "003", id = "insertBooks", author = "tyomakr", runAlways = true)
    public void insertBooks(MongoTemplate mt) {
        Book b1 = new Book("Властелин колец", authorList.get(0), genreList.get(0));
        bookList.add(mt.save(b1));

        Book b2 = new Book("Сильмариллион", authorList.get(0), genreList.get(0));
        bookList.add(mt.save(b2));

        Book b3 = new Book("Этюд в багровых тонах", authorList.get(7), genreList.get(2));
        bookList.add(mt.save(b3));

        Book b4 = new Book("Знак четырех", authorList.get(7), genreList.get(2));
        bookList.add(mt.save(b4));

        Book b5 = new Book("Собака Баскервилей", authorList.get(7), genreList.get(2));
        bookList.add(mt.save(b5));

        Book b6 = new Book("Долина ужасов", authorList.get(7), genreList.get(2));
        bookList.add(mt.save(b6));

        Book b7 = new Book("Убийство в Восточном экспрессе", authorList.get(6), genreList.get(2));
        bookList.add(mt.save(b7));

        Book b8 = new Book("Кража в миллион долларов", authorList.get(6), genreList.get(2));
        bookList.add(mt.save(b8));

        Book b9 = new Book("Корнуолльская тайна", authorList.get(6), genreList.get(2));
        bookList.add(mt.save(b9));

        Book b10 = new Book("Немезида", authorList.get(6), genreList.get(2));
        bookList.add(mt.save(b10));

        Book b11 = new Book("Птицы, звери и родственники", singletonList(authorList.get(4)), Arrays.asList(genreList.get(3), genreList.get(8)));
        bookList.add(mt.save(b11));

        Book b12 = new Book("Под пологом пьяного леса", singletonList(authorList.get(4)), Arrays.asList(genreList.get(3), genreList.get(8)));
        bookList.add(mt.save(b12));

        Book b13 = new Book("Финансист", authorList.get(2), genreList.get(4));
        bookList.add(mt.save(b13));

        Book b14 = new Book("Титан", authorList.get(2), genreList.get(4));
        bookList.add(mt.save(b14));

        Book b15 = new Book("Стоик", authorList.get(2), genreList.get(4));
        bookList.add(mt.save(b15));

        Book b16 = new Book("Братья Карамазовы", authorList.get(5), genreList.get(4));
        bookList.add(mt.save(b16));

        Book b17 = new Book("Бесы", authorList.get(5), genreList.get(4));
        bookList.add(mt.save(b17));

        Book b18 = new Book("Идиот", authorList.get(5), genreList.get(4));
        bookList.add(mt.save(b18));

        Book b19 = new Book("Граф Монте-Кристо", authorList.get(8), genreList.get(9));
        bookList.add(mt.save(b19));

        Book b20 = new Book("Гиперион", authorList.get(3), genreList.get(1));
        bookList.add(mt.save(b20));

        Book b21 = new Book("Падение Гипериона", authorList.get(3), genreList.get(1));
        bookList.add(mt.save(b21));

        Book b22 = new Book("Эндемион", authorList.get(3), genreList.get(1));
        bookList.add(mt.save(b22));

        Book b23 = new Book("Восход Эндемиона", authorList.get(3), genreList.get(1));
        bookList.add(mt.save(b23));

        Book b24 = new Book("Последнее желание", authorList.get(9), genreList.get(0));
        bookList.add(mt.save(b24));

        Book b25 = new Book("Меч Предназначения", authorList.get(9), genreList.get(0));
        bookList.add(mt.save(b25));

        Book b26 = new Book("Час Презрения", authorList.get(9), genreList.get(0));
        bookList.add(mt.save(b26));

        Book b27 = new Book("Крещение огнем", authorList.get(9), genreList.get(0));
        bookList.add(mt.save(b27));

        Book b28 = new Book("Башня Ласточки", authorList.get(9), genreList.get(0));
        bookList.add(mt.save(b28));

        Book b29 = new Book("Владычица Озера", authorList.get(9), genreList.get(0));
        bookList.add(mt.save(b29));

        Book b30 = new Book("Сезон гроз", authorList.get(9), genreList.get(0));
        bookList.add(mt.save(b30));

        Book b31 = new Book("Божественная комедия", authorList.get(10), genreList.get(5));
        bookList.add(mt.save(b31));

        Book b32 = new Book("First Head Java", Arrays.asList(authorList.get(11), authorList.get(12)), Arrays.asList(genreList.get(6), genreList.get(7)));
        bookList.add(mt.save(b32));
    }

    @ChangeSet(order = "004", id = "insertComments", author = "tyomakr", runAlways = true)
    public void insertComments(MongoTemplate mt) {
        mt.save(new Comment("Sample comment 1", bookList.get(0)));
        mt.save(new Comment("Comment 2", bookList.get(0)));
        mt.save(new Comment("Comment 3", bookList.get(0)));
        mt.save(new Comment("Comment 4444", bookList.get(31)));
        mt.save(new Comment("Comment Five", bookList.get(31)));
        mt.save(new Comment("Sample comment 6", bookList.get(19)));
        mt.save(new Comment("777 comment", bookList.get(19)));
        mt.save(new Comment("Sample comment 8", bookList.get(19)));
        mt.save(new Comment("Sample comment 9", bookList.get(19)));
        mt.save(new Comment("Last init comment", bookList.get(19)));

    }
}