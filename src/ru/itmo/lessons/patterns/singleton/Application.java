package ru.itmo.lessons.patterns.singleton;

public class Application {
    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();
    }

}
