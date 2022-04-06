package ru.itmo.lessons.lesson15;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapLesson {

    public static void main(String[] args) {
        // Map хранят данные в парах ключ - значение
        // Особенности map:
        // 1. ключи мапы должны быть уникальны
        // 2. каждому ключу соответствует только одно значение
        // 3. Map не являются коллекциями

        // наиболее популярные HashMap<K, V>, TreeMap<K, V>, EnumMap<K, V>, LinkedHashMap<K, V>

        // Особенности HashMap:
        // 1. хранит ключи в hash таблице (на основе hash кода)
        // 2. обладает хорошей производительностью
        // 3. в качестве ключа можно использовать null
        // 4. порядок хранения элементов может отличаться от порядка добавления

        // создание экземпляра HashMap:
        // в <> сначала указываем типа данных ключей, затем тип данных значений
        HashMap<String, Integer> hashMap = new HashMap<>();

        // добавление элементов
        hashMap.put("Москва", 790);
        hashMap.put("Ростов", 270);
        hashMap.put("Великий Новгород", 75);
        hashMap.put("Тверь", 12);
        hashMap.put(null, null);
        System.out.println(hashMap);

        // удаление пары
        hashMap.remove(null); // по ключу
        hashMap.remove("Москва", 5); // по ключу и значению
        hashMap.remove("Ростов", 270); // по ключу и значению
        System.out.println(hashMap);

        // замена
        hashMap.replace("Великий Новгород", 100); // по ключу
        hashMap.replace("Тверь", 12, 22); // по ключу и значению
        System.out.println(hashMap);

        // получение
        System.out.println(hashMap.get("Тверь"));
        System.out.println(hashMap.get("Москва"));
        // если ключ не найден, вернет значение по умолчанию
        System.out.println(hashMap.getOrDefault("Санкт-Петербург", 0));
        System.out.println(hashMap.getOrDefault("Великий Новгород", 0));

        // проверить, содержится ли в мапе ключ
        System.out.println(hashMap.containsKey("Санкт-Петербург"));
        // проверить, содержится ли в мапе значение
        System.out.println(hashMap.containsValue(1000));

        System.out.println("---Перебор мап---");
        for (Map.Entry<String, Integer> pair: hashMap.entrySet()){
            System.out.println("город (ключ): " + pair.getKey());
            System.out.println("количество покупателей (значение): " + pair.getValue());
        }

        // TODO: ЗАДАЧИ
        //  1. Создать несколько экземпляров класса User с повторяющимися значениями свойства age
        //  2. Создать HashMap, где ключи - логины пользователей,
        //  значения - экзкпляры класса User
        //  3. Добавить данные
        //  4. Логины всех пользователей, стрше 20 лет скопировать в отдельный List
        //  5. Вывести логины и пароли пользователей с ролью ADMIN
        //  6. На основе существующей мапы создать новую, где ключи - возраст пользователей
        //  значеня - списки пользователей соответствуйщего возраста

        // LinkedHashMap аналогична HashMap, но позволяет сохранять
        //порядок элементов (из-за чего менее производительна, чем HashMap)

        // Особенности EnumMap:
        // 1. использует перечисления (enum) в качестве ключей
        // 2. нельзя использовать null в качестве ключа
        // 3. все ключи должны быть одного типа перечисления
        // 4. все значения содержит в массиве (размер массива - количество элементов перечисления)
        // 5. порядок хранения элементов соответствует порядку элементов enum
        // 6. для извлечения значений использует индекс ключа: vals[key.ordinal()]

        // при создании объекта в конструктор необходимо передать ссылку на класс перечисления,
        // например, Role.class

        // TODO: ЗАДАЧИ
        //  1. Создать несколько экземпляров класса User
        //  2. Создать EnumMap, где ключи - роли, значения - списки пользователей
        //  3. Добавить данные
        //  4. Вывести в консоль логины всех пользователей с ролью USER
        //  5. Создать еще один экземпляр класса User, добавить его в мапу,
        //  представляя, что роль пользователя Вам неизвестна

        // Особенности TreeMap:
        // 1. хранит элементы в отсортированном по ключам порядке
        // 2. основан на красно-черном дереве
        // 3. null нельзя использовать в качестве ключей
        // 4. класс, объекты которого будут использоваться в качестве ключей
        // должен реализовывать интерфейс Comparable
        // или в конструктор мапы необходимо передать Comparator

        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        treeMap.put("Анапа", 45);

        System.out.println(treeMap);

    }
}
