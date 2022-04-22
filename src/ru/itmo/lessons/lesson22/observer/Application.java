package ru.itmo.lessons.lesson22.observer;

public class Application {
    public static void main(String[] args) { // наблюдатель:
        // Реализовать контроллеры, реагирующие на повышение температуры.

        // Класс Sensor повышает/понижает температуру на 40, и на каждое
        // изменение температуры оповещает слушателей (контроллеры):
        // - первый контроллер (green) реагирует на температуру 100 и выше;
        // - второй контроллер (yellow) реагирует на температуру 300 и выше;
        // - третий контроллер (red) реагирует на температуру 600 и выше.

        // Реакция контроллера - вывод в консоль температуры и
        // названия контроллера.

        // Если контроллер сработал, то сообщение не повторяется при
        // дальнейшем повышении температур. Но если температура
        // опустится ниже допусимого порога контроллера и потом
        // начнем подниматься, контроллер снова должен отреагировать.

        Controller green = new Controller("green", 100);
        Controller yellow = new Controller("yellow", 300);
        Controller red = new Controller("red", 600);

        Sensor sensor = new Sensor();
        sensor.addListener(green);
        sensor.addListener(yellow);
        sensor.addListener(red);

        for (int i = 0; i < 700; i++) {
            sensor.changeState();
        }
    }
}
