DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    authorName VARCHAR(255)
                     );

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    genreName VARCHAR(255)
                    );

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    bookName VARCHAR(255),
    authorId INT,
    genreId INT
);

ALTER TABLE BOOKS
ADD FOREIGN KEY (authorId)
REFERENCES AUTHORS(id);

ALTER TABLE BOOKS
ADD FOREIGN KEY (genreId)
REFERENCES GENRES(id);
