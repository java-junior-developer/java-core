package ru.itmo.lessons.lesson6.books;

// ru.itmo.lessons.lesson6.books.Author
public class Author {
    // свойства, характеристики, поля, атрибуты
    public String name;
    public String surname;

    // объявление методов
    public void printFullName() {
        // можно использовать 'return;', чтобы прервать работу метода
        System.out.println(name + " " + surname);
    }

    public String getFullName() {
        // возвращает результат работы метода
        // прерывает работу метода, инструкции после return
        // не будут выполнены
        return name + " " + surname;
    }

    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
