package ru.itmo.lessons.questions.question3;

public class App {
    public static void main(String[] args) {
        Util util1 = new Util();
        Util util2 = new Util();

        util1.max = 1200;
        System.out.println(util2.max);

        Util.min = 100;
        Util.min = 200;

        System.out.println(util2.max);
        System.out.println(util1.min);
    }
}
