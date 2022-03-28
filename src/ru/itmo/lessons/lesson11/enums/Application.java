package ru.itmo.lessons.lesson11.enums;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Article article1 = new Article("Путешествие по Австралии");
        article1.setCountry(Country.AUSTRALIA);
        System.out.println(article1.getCountry()); // AUSTRALIA

        Article article2 = new Article("Путешествие по Британии");
        article2.setCountry(Country.UK);
        System.out.println(article2.getCountry()); // UK

        // методы перечислений
        // получение массива констант
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));
        // [AUSTRALIA, UK, FRANCE]
        // индекс элемента перечисления в массиве
        System.out.println(Country.FRANCE.ordinal()); // 2

        for (Country country : countries) {
            System.out.println("country " + country.name());
        }

        // IllegalArgumentException, если элемент не будет найден
        Country country = Country.valueOf("UK"); // UK
        System.out.println(country); // UK



    }
}
