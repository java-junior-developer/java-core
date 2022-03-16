package ru.itmo.lessons.lesson6.books;

import java.util.Arrays;

public class Shelf {
    private String color = "белый"; // цвет полки
    private Book[] books = new Book[4]; // книги

    public Book[] getBooks() {
        return books;
    }


    public void setColor(String color) {
        if (color == null || color.length() < 4) {
            throw new IllegalArgumentException("В названии цвета должно быть не менее 4 символов");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // метод добавления одной книги на полку
    public void addBook(Book book){
        for (int i = 0; i < books.length; i += 1) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("Книге '" + book.getTitle() + "' автора " + book.getAuthor().getFullName() + " не хватило места на полке ");
    }
    // метод добавления нескольких книг на полку
    public void addBook(Book... books){ //  books - массив, состоящий из элементов, переданных в метод через запятую
        System.out.println(Arrays.toString(books));
        for (Book book : books) {
            addBook(book); // вызов метода addBook(Book book)
        }
    }

}
