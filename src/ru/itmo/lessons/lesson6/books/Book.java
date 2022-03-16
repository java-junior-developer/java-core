package ru.itmo.lessons.lesson6.books;

import java.util.Objects;

// ru.itmo.lessons.lesson6.books.Book
public class Book {
    // свойства:
    private String title; // название
    private int pageCount; // количество страниц
    private Author author; // автор

    // конструктор вызывается в момент создания объекта: new Book()

    // конструктор по умолчанию нужно явно указывать,
    // если есть конструкторы с параметрами и нужен конструктор без них
    public Book(){}

    public Book(Author author) {
        this.author = Objects.requireNonNull(author, "author не мб null");
    }

    public Book(String title, Author author){
        this(author); // вызов конструктора
        setTitle(title); // вызов метода
    }

    // методы, позволяющие установить значения свойств
    // со всеми необходимыми проверками - сеттеры
    public void setTitle(String titleValue){
        if (titleValue == null || titleValue.length() < 3) {
            throw new IllegalArgumentException("Значение title от 3 символов");
        }
        title = titleValue;
    }

    // методы, которые возвращают значения свойств - геттеры
    public String getTitle(){
        return title;
    }

    public void setPageCount(int pageCount){
        if (pageCount < 10) {
            throw new IllegalArgumentException("Значение pageCount дб больше 10");
        }
        // this - ссылка на текущий объект
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }
}

