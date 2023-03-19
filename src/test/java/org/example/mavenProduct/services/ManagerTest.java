package org.example.mavenProduct.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void addTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, " Running Man", 200, "King");
        Book book2 = new Book(2, "  It", 200, "King");
        Book book3 = new Book(3, "   Mangler", 200, "King");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTest2() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, " Potter1", 200, "King");
        Book book2 = new Book(2, "  It", 200, "King");
        Book book3 = new Book(3, "    Potter2", 200, "King");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Potter");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTest3() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, " Potter1", 200, "King");
        Book book2 = new Book(2, "  It", 200, "King");
        Book book3 = new Book(3, "    Potter2", 200, "King");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Terminator");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTest4() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, " Potter1", 200, "King");
        Book book2 = new Book(2, "  It", 200, "King");
        Book book3 = new Book(3, "    Potter2", 200, "King");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Potter");

        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTestRun() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, " Potter1", 200, "King");
        Book book2 = new Book(2, "  It", 200, "King");
        Book book3 = new Book(3, "    Potter2", 200, "King");
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(4));
    }

    @Test
    public void addTestRun2() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, " Potter1", 200, "King");
        Book book2 = new Book(2, "  It", 200, "King");
        Book book3 = new Book(3, "    Potter2", 200, "King");
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(3);
         Product[] actual=repo.findAll();
         Product[] expected ={book1,book2};
        Assertions.assertArrayEquals(expected, actual);

    }
}