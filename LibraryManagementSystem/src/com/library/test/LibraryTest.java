package com.library.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.library.Book;
import com.library.Library;

public class LibraryTest {
    private Library library;
    private Book book1, book2, book3;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Title1", "Author1", "ISBN1", "Genre1", 2001, "Dept1", true);
        book2 = new Book("Title2", "Author2", "ISBN2", "Genre2", 2002, "Dept2", false);
        book3 = new Book("Title1", "Author3", "ISBN3", "Genre3", 2003, "Dept3", true);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    public void testAddBook() {
        Book book4 = new Book("Title4", "Author4", "ISBN4", "Genre4", 2004, "Dept4", true);
        library.addBook(book4);
        assertEquals(4, library.listAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("ISBN2");
        assertEquals(2, library.listAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        List<Book> books = library.findBookByTitle("Title1");
        assertEquals(2, books.size());
    }

    @Test
    public void testFindBookByAuthor() {
        List<Book> books = library.findBookByAuthor("Author2");
        assertEquals(1, books.size());
    }

    @Test
    public void testListAllBooks() {
        List<Book> books = library.listAllBooks();
        assertEquals(3, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        assertEquals(2, books.size());
    }
}

