package ru.itmo.lessons.lesson6.books;

public class Shelf {
    private String color = "белый"; // цвет полки
    // книги
    private Book[] books = new Book[10];

    // метод добавления одной книги на полку
    public void addBook(Book book){
        // [book, null, null, null, ...]
        for (int i = 0; i < books.length; i += 1) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("Нет места");
    }
    // метод добавления нескольких книг на полку
    public void addBook(Book... books){ // [book1, book1, book1]

    }

    public Book[] getBooks() {
        return books;
    }
}
