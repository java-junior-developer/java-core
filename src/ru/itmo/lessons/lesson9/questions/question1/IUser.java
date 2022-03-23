package ru.itmo.lessons.lesson9.questions.question1;

public interface IUser {
    default void enterInfo() {
        System.out.println("Пользователь авторизован");
    }
    String getUserName();
}