package ru.itmo.lessons.lesson9.questions.question1;

public interface IAuthorization {
    default void enterInfo() {
        System.out.println("Авторизация прошла успешно");
    }

    String getToken();
}