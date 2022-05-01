package com.example.bibliotekbackend.Books;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    Book book;

    ArrayList<Book> books;

    /**
     * Sends information to DAO class for inserting one new book.
     */
    public void insertBook(String book_title, int book_qty, String book_author, String book_genre) {
        bookDao.insertBook(book_title, book_qty, book_author, book_genre);
    }

    /**
     * Sends information to DAO class for updating one book.
     */
    public void updateBook(int ID_book, String book_title, int book_qty, String book_author, String book_genre) {
        bookDao.updateBook(ID_book, book_title, book_qty, book_author, book_genre);
    }

    /**
     * Sends information to DAO class for deleting one book using ID_book
     */
    public void deleteBook(int ID_book) {
        bookDao.deleteBook(ID_book);
    }

    /**
     * @param ID_book
     * @return gson String regarding info about one book, based on ID, sends it to DAO class.
     */
    public String downloadOneBook(int ID_book) {
        Gson gson = new Gson();
        book = bookDao.downloadOneBookByID(ID_book);
        String bookString = gson.toJson(book);
        return bookString;
    }

    /**
     * @return gson String with information regarding all books, sends it to DAO class.
     */
    public String downloadAllBooks() {
        books = bookDao.downloadAllBooks();
        Gson gson = new Gson();
        String bookListString = gson.toJson(books);
        return bookListString;
    }

    /**
     * assigns to 'book' object, the book with highest ID, by using the newlyAddedBook() method, then...
     * returns a gson String with information regarding this most recently added book to the DAO class.
     *
     * @return please see above.
     */
    public String downloadMostRecentBook() {
        book = bookDao.newlyAddedBook();
        Gson gson = new Gson();
        return gson.toJson(book);
    }

    public String downloadBookByTitle(String book_title) {
        return bookDao.downloadBookByTitle(book_title);
    }

}