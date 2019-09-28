DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    authorName VARCHAR(255)
                     );

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    genreName VARCHAR(255)
                    );

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bookName VARCHAR(255),
    authorId INT,
    genreId INT
);
