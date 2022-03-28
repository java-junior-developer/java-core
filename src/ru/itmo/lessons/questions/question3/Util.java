package ru.itmo.lessons.questions.question3;

public class Util {
    public static int max;
    public static int min;
    public final static double PI;
    static {
        PI = 3.14;
    }
    public static int random(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }
}