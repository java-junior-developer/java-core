package ru.itmo.lessons.patterns.observer;

public interface EventListener {
    void greenEvent(int code);
    void yellowEvent(int code);
    void redEvent(int code);
}