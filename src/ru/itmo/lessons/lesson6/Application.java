package ru.itmo.lessons.lesson6;

//import ru.itmo.lessons.lesson6.books.Author;

import ru.itmo.lessons.lesson6.books.Author;
import ru.itmo.lessons.lesson6.books.Book;
import ru.itmo.lessons.lesson6.books.Shelf;

// полное имя класса: имя пакета + имя класса, например
// ru.itmo.lessons.lesson6.Application
public class Application {
    public static void main(String[] args) {
        // объект, экземпляр класса Author
        Author author1 = new Author();
        // обращение к свойствам осушествляется через .
        author1.name = "Tom";
        author1.surname = "Crowed";

        Author author2 = new Author();
        author2.name = "Mike";
        author2.surname = "Thompson";

        // вызов методов
        author1.printFullName();
        author2.printFullName();

        String fullName = author1.getFullName();
        System.out.println(fullName);

        Book book1 = new Book(author2);
        book1.setTitle("Книга"); // от 3 символов
        System.out.println(book1.getTitle());
        book1.setPageCount(22);

        Shelf shelf = new Shelf();
        shelf.addBook(book1);
        shelf.addBook(book1, book1, book1);
        // вывод имени автора первой книги на полке
        System.out.println(shelf.getBooks()[0].getAuthor().name);

        // book1.title = "";
        // book1.pageCount = -34;

        // класс - способ описания сущности,
        // определяющий ее состояние и поведение
        // класс - набор свойст и методов будущих объектов

        // На основе класса создаются объекты
        // (экземпляры данного класса) - представители
        // данного класса, имеющие конкретное состояние и
        // поведение, определенное в классе


    }
}
