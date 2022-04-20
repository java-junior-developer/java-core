package ru.itmo.lessons.lesson21;

public class User {
    private Level level;
    private String login;

    public User(Level level, String login) {
        this.level = level;
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "level=" + level +
                ", login='" + login + '\'' +
                '}';
    }

    // внутренний класс
    // 1. область видимости - согласно модификаторам доступа
    // 2. нельзя создать объект внутреннего класса без
    // создания объекта внешнего класса
    public class Account {
        // 3. не может содержать статических методов и свойств,
        // только если статическое свойство не final
        // private static final int MAX_BALANCE = 500;
        private float balance;

        public Account(float balance) {
            // возможен доступ к приватным методам и свойствам
            // внешнего класса
            this.balance = balance + User.this.level.getCount();
        }

        public User getUser(){
            // доступ к экземпляру внешнего класса
            return User.this; // ссылка на экземпляр внешнего класса
        }

    }

    // доступ к перечислению вне класса - согласно
    // модификатору доступа: User.Level.элемент
    public enum Level { // вложенный класс (static класс)
        HIGH(10), MEDIUM(5), LOW(0);
        private int count;
        Level(int count) {
            this.count = count;
        }
        public int getCount() {
            return count;
        }
    }

}
