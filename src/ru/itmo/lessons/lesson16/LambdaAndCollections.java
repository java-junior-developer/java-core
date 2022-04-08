package ru.itmo.lessons.lesson16;

import ru.itmo.lessons.lesson16.education.Course;
import ru.itmo.lessons.lesson16.education.University;

public class LambdaAndCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));

        // TODO:: увеличить стоимость каждого курса на 10%

        // TODO:: вывести названия каждого курса

        // TODO:: удалить из коллекции курсы, если их стоимость меньше 15000

        // TODO:: написать реализацию метода getFilteredCourses, который принимает на вход Predicate<Course>
        //  и возвращает список отфильтрованных данным предикатом курсов университета

        // TODO::написать предикаты, которые возвращают true, если:
        //  1) курс дешевле 20000
        //  2) продолжительность курса 3 месяца или меньше
        //  3) название курса JJD

        // TODO:: Отфильтровать
        //  1) дешевле 20000
        //  2) дешевле 20000 и меньше 3х месяцев
        //  3) JJD или дешевле 20000
        
    }
}