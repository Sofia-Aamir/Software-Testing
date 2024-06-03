package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BookServiceTest {

    private BookService bookService;
    private FakeRepositoryForTest fakeRepository;

    @BeforeEach
    public void setUp() {
        fakeRepository = new FakeRepositoryForTest();
        bookService = new BookService(fakeRepository);
    }

    @Test
    public void testGetBooksByAuthor() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler")
        );
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler")
        );
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler")
        );
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Robert C. Martin", books.get(0).getAuthor());
    }

    @Test
    public void testGetBooksByTitle_NoBooksFound() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler")
        );
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler")
        );
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "Test Driven Development");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("1", books.get(0).getId());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NoBooksFound() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler")
        );
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NoBooksFoundForAuthor() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler")
        );
        List<Book> books = bookService.getBooksByAuthorAndTitle("Unknown Author", "Test Driven Development");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_MultipleBooks() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("5", "Test Driven Development", "Kent Beck"),
                new Book("6", "Extreme Programming Explained", "Kent Beck")
        );
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(2, books.size());
    }

    @Test
    public void testGetBooksByTitle_MultipleBooks() {
        FakeRepositoryForTest.booksList = Arrays.asList(
                new Book("7", "Clean Code", "Robert C. Martin"),
                new Book("8", "Clean Code", "John Doe")
        );
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        Assertions.assertEquals(2, books.size());
    }
}
