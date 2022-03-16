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
        // типДанных имяПеременной = new вызовКонструктора();
        Author author1 = new Author();
        // обращение к свойствам осуществляется через .
        // но при таком подходе в значение свойства можно записать все, что угодно.
        // Это может навредить программе
        // Например, author1.name = ""; или author1.surname = null; и тд
        // поэтому лучше ограничить свободный доступ к свойствам и
        // использовать методы, в которых можно будет реализовать проверку входящих данных
        author1.name = "Tom"; // свойству name объекта author1 присвоили значение Tom
        author1.surname = "Crowed"; // свойству surname объекта author1 присвоили значение Crowed

        Author author2 = new Author();
        author2.name = "Mike"; // свойству name объекта author2 присвоили значение Mike
        author2.surname = "Thompson"; // свойству surname объекта author2 присвоили значение Thompson

        // вызов методов
        author1.printFullName(); // вызвали метод printFullName объекта author1
        author2.printFullName(); // вызвали метод printFullName объекта author2

        // вызвали метод getFullName объекта author1,
        // результат работы метода присвоили переменной fullName
        String fullName = author1.getFullName();
        System.out.println(fullName);

        // типДанных имяПеременной = new вызовКонструктора(аргументы);
        Book book1 = new Book(author2); // в конструктор передали ссылку на экземпляр класса Author
        book1.setTitle("Книга"); // вызвали метод setTitle объекта book1, метод проверит валидность данных,
        // установит значение свойства title
        System.out.println(book1.getTitle()); // метод getTitle вернет значение свойства title объекта book1
        book1.setPageCount(22); // вызвали метод setPageCount объекта book1, метод проверит валидность данных,
        // установит значение свойства pageCount

        Book book2 = new Book(author2);
        book2.setTitle("Java 17");
        book2.setPageCount(3700);

        Book book3 = new Book(author1);
        book3.setTitle("Строки в Java");
        book3.setPageCount(1200);

        Book book4 = new Book(author1);
        book4.setTitle("Коллекции в Java");
        book4.setPageCount(300);

        Book book5 = new Book(author2);
        book5.setTitle("Многопоточность в Java");
        book5.setPageCount(2600);

        // типДанных имяПеременной = new вызовКонструктора();
        Shelf shelf = new Shelf();
        // метод addBook перегружен
        shelf.addBook(book1); // вызов метода addBook(Book book) {}
        shelf.addBook(book5); // вызов метода addBook(Book book) {}
        shelf.addBook(book2, book3, book4); // вызов метода addBook(Book... books) {}


        // вывод имени автора первой книги на полке
        System.out.println(shelf.getBooks()[0].getAuthor().name);
        // 1. shelf - экземпляр класса Shelf
        // 2. shelf.getBooks() метод вернет ссылку на значение свойства books объекта shelf - массив книг
        // 3. shelf.getBooks()[0] обратились к элементу массива с индексом 0 - экземпляр класса Book
        // 4. shelf.getBooks()[0].getAuthor() метод вернет ссылку на значение свойства author книги
        // 5. shelf.getBooks()[0].getAuthor().name получили значение свойства name автора

        // класс - способ описания сущности,
        // определяющий ее состояние и поведение
        // класс - набор свойств и методов будущих объектов

        // На основе класса создаются объекты
        // (экземпляры данного класса) - представители
        // данного класса, имеющие конкретное состояние и
        // поведение, определенное в классе

    }
}
