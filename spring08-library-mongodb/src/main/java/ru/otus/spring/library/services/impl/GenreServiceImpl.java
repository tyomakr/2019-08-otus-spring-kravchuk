package ru.otus.spring.library.services.impl;

import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.library.model.Genre;
import ru.otus.spring.library.repository.GenreRepository;
import ru.otus.spring.library.services.GenreService;
import ru.otus.spring.library.services.IOService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final IOService ioService;


    @Override
    public void findAll() {
        List<Genre> genreList = genreRepository.findAll();
        String tableFormatter = "%-26s %-60s %n";
        ioService.printItemsList(tableFormatter, ioService.getMsg("gs.head.g.id"), ioService.getMsg("bs.head.b.genre"));

        for(Genre genre : genreList) {
            ioService.printItemsList(tableFormatter, genre.getId(), genre.getGenreTitle());
        }
    }

    @Override
    public void insertGenre(String genreTitle) {
        if (!genreRepository.existsByGenreTitleEqualsIgnoreCase(genreTitle)) {
            Genre genre = new Genre(genreTitle);
            genreRepository.save(genre);
        }
        else {
            ioService.printMsg("gs.err.g.exists");
        }
    }

    @Override
    public void updateGenre(String oldGenreTitle, String newGenreTitle) {

        Optional<Genre> optionalGenre = genreRepository.findGenreByGenreTitle(oldGenreTitle);

        ioService.printMsg(optionalGenre.map(genre -> {
            genre.setGenreTitle(newGenreTitle);
            genreRepository.save(genre);
            UpdateResult result = genreRepository.updateAllGenresInBooks(oldGenreTitle, newGenreTitle);
            ioService.printMsgWithValues("gs.u.found", String.valueOf(result.getMatchedCount()), String.valueOf(result.getModifiedCount()));
            return "gs.u.done";
        }).orElse("gs.err.g.not.exists"));
    }
}
