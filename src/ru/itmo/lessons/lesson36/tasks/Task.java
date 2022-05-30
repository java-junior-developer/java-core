package ru.itmo.lessons.lesson36.tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import ru.itmo.lessons.lesson20.ArgsAndProps;
import ru.itmo.lessons.lesson36.annotation.Cat;
import ru.itmo.lessons.lesson36.annotation.ClassConfig;
import ru.itmo.lessons.lesson36.annotation.Required;
import ru.itmo.lessons.lesson6.books.Author;
import ru.itmo.lessons.lesson6.books.Book;
import ru.itmo.lessons.lesson6.books.Shelf;

public class Task {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IOException, IllegalAccessException {
        Author author = new Author();
        author.name = "Имя автора";
        author.surname = "Фамилия автора";
        toString(author);

        Book book = new Book(author);
        book.setTitle("КНИГА");
        book.setPageCount(1000);
        toString(book);

        Shelf shelf = new Shelf();
        toString(shelf);

        toString(344);
        toString(null);
        toString("lesson 37");

        Cat object = (Cat) getInstance(Cat.class);
    }

    public static void toString(Object obj){
        if (obj == null) {
            System.out.println("null");
            return;
        }

        Class<?> cls = obj.getClass();

        if (isSimple(cls)) {
            System.out.println(obj);
            return;
        }

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Excluded.class) || field.getType().isArray()) continue;
            if (isSimple(field.getType())) {
                try {
                    System.out.println(field.getName() + ": " + field.get(obj));
                } catch (IllegalAccessException e) {
                    System.out.println();
                }
            } else {
                try {
                    toString(field.get(obj));
                } catch (IllegalAccessException e) {
                    System.out.println();
                }
            }
        }

    }

    public static boolean isSimple(Class<?> type) {
        return type.isPrimitive() ||
                type.isEnum() ||
                type == String.class ||
                type == Byte.class ||
                type == Short.class ||
                type == Integer.class ||
                type == Long.class ||
                type == Float.class ||
                type == Double.class ||
                type == Boolean.class ||
                type == Character.class;
    }


    public static Object getInstance(Class<?> cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        if (!cls.isAnnotationPresent(ClassConfig.class)) return null;
        ClassConfig classConfig = cls.getDeclaredAnnotation(ClassConfig.class);

        String propFile = classConfig.configFile();
        String propPrefix = classConfig.prefix();

        Constructor<?> constructor = cls.getDeclaredConstructor();
        Object object = constructor.newInstance();

        Properties properties = new Properties();
        try (InputStream input = ArgsAndProps.class
                .getClassLoader()
                .getResourceAsStream(propFile)){
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Required.class)) continue;
            String setterName = "set" + field.getName().substring(0,1).toUpperCase() +
                    field.getName().substring(1);
            Method setter = cls.getDeclaredMethod(setterName, field.getType());

            String propValue = properties.getProperty(propPrefix + "." + field.getName());

            Object fieldValue = propValue;

            if (field.getType() == int.class || field.getType() == Integer.class) {
                fieldValue = Integer.valueOf(propValue);
            }

            setter.invoke(object, fieldValue);
        }

        Method toString = cls.getDeclaredMethod("toString");
        System.out.println(toString.invoke(object));

        return object;
    }

}
