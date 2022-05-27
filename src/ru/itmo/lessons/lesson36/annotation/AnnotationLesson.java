package ru.itmo.lessons.lesson36.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationLesson {
    public static void main(String[] args) {
        Class<Cat> catClass = Cat.class;

        // получение ссылок на аннотации класса
        Annotation[] annotations = catClass.getAnnotations();
        System.out.println("ссылки на аннотации класса: " + Arrays.toString(annotations));

        // проверить наличие аннотации
        if (catClass.isAnnotationPresent(ClassConfig.class)){
            System.out.println("ClassConfig");
            // получение ссылки на аннотацию для получения параметров
            ClassConfig classConfig = catClass.getDeclaredAnnotation(ClassConfig.class);
            // получим значения свойств: prefix, version и file
            System.out.println("prefix: " + classConfig.prefix());
            System.out.println("version: " + classConfig.version());
            System.out.println("file: " + classConfig.configFile());
        }

        // получение ссылок на аннотации полей класса
        Field[] fields = catClass.getDeclaredFields();
        for (Field field: fields){
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            System.out.println("ссылки на аннотации поля: " + Arrays.toString(fieldAnnotations));

            // проверка наличия определенной аннотации
            if (field.isAnnotationPresent(Required.class)){
                System.out.println(field.getName() + " - поле с аннотацией Required");
            } else {
                System.out.println(field.getName() + " - поле без аннотации Required");
            }
        }

        // TODO: Задание: реализовать метод, принимающий на вход ссылку на класс и возвращающий экземпляр данного
        //  класса или null
        //  Если класс аннотирован аннотацией ConfigClass, создать объект данного класса (использовать рефлексию),
        //  если аннотации нет, вернуть null.
        //  Если поле отмечено аннотацией @Required,
        //  необходимо установить значение данного поля (любое или из config.properties файла),
        //  значение поля устанавливать через сеттер (name - setName / age - setAge).
        //  У созданного объекта вызвать метод toString(), используя рефлексию.
        //  Вернуть созданный объект.
    }
}
