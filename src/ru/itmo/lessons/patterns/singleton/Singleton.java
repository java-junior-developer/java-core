package ru.itmo.lessons.patterns.singleton;

// ленивая (отложенная) инициализация
public class Singleton {
    // все необходимые методы и свойства

    private static Singleton instance; /* new Singleton()*/

    // закрываем возможность создания объекта вне класса
    private Singleton() {}

    public static Singleton getInstance(){
        if (instance == null) { // проверка был ли создан объект
            // создание объекта (если он не был создан ранее)
            instance = new Singleton();
        }
        return instance;
    }
}