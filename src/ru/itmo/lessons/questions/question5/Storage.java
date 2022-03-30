package ru.itmo.lessons.questions.question5;

import java.util.Arrays;

public class Storage {
    private String[] strings;

    public Storage(int len) {
        if (len < 1) {
            throw new IllegalArgumentException("Задайте размер массива");
        }
        strings = new String[len];
    }

    public void addString(String newString) { }

    @Override
    public String toString() {
        return "Storage{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}
