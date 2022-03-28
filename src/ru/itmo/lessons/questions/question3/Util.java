package ru.itmo.lessons.questions.question3;

public class Util {
    public static int max;
    public static int min;
    public final static double PI;
    // статический блок для инициализации статических свойств (переменных)
    // инструкции выполняются один раз при загрузке класса
    static {
        PI = 3.14;
    }

    // private Util(){}

    // static метод нельзя переопределить в дочернем классе
    public /* final */ static int random(int min, int max) {
        // нельзя обратиться к не static свойствам и методам
        // нельзя обратиться к this
        return (int) (min + Math.random() * (max - min));
    }
}