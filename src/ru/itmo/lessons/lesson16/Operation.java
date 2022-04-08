package ru.itmo.lessons.lesson16;

@FunctionalInterface //функциональный интерфейс содержит один абстрактный метод
// и любое количество default или static методов с реализацией
public interface Operation {
    /* public */ double execute(double a, double b);
}

/*
public interface Operation {
   интерфейс - маркер не содержит методов
}
*/
