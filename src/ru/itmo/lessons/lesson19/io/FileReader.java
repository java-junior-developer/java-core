package ru.itmo.lessons.lesson19.io;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;


public class FileReader {

    // java.io
    // java.nio
    // new File(файл или директория)


    // программа        источник
    // InputStream (байты) получение потока байт в программу
    // OutputStream (байты) отправка данных из программы

    // Reader (char) получение потока чар в программу
    // Writer (char) отправка данных из программы


    // FileInputStream / FileOutputStream
    // ObjectInputStream / ObjectOutputStream

    // FileInputStream(CustomStream(ObjectInputStream((объект))))

    public static boolean writeToFile(byte[] data, File file) /*throws FileNotFoundException*/ {
        // Properties
        // как хранит данные
        // как добавить данные
        // как получить данные

        // имя-файла.properties

        // как прочитать данные из properties файла в экземпляр Properties


        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream(file, true)){
            // true - дозапись в файл - new FileOutputStream(file, true)
            // false - перезапись new - FileOutputStream(file)

            // // try with resources (java 7):
            // 1. все инструкции блока try выполнены без ошибок
            // 2. в блоке try произошла ошибка.
            // Ресурсы будут закрыты до перхвата исключения блоком catch

            // Если класс, объект которого создается в try with resources,
            // реализует  AutoCloseable интерфейс
            // и его абстрактынй метод void close()

            // если try with resources не используется,
            // закрывать ресурсы нужно в блоке finally
            fileOutput.write(data);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось использовать файл");
        } catch (IOException e) { // FileNotFoundException - наследник IOException
            System.out.println("Не удалось записать данные в файл");
        }
        return result;
    }

    public static byte[] readFromFile(File file){
        byte[] result = null;
        try (FileInputStream fileInput = new FileInputStream(file)){
            result = fileInput.readAllBytes();
        } catch (FileNotFoundException e) {
            // throw new RuntimeException(e);
            System.out.println("Не удалось использовать файл");
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.out.println("Не удалось прочитать данные из файла");
        }
        return result;
    }

    public static boolean writeFromConsole(File file){
        boolean result = false;
        // основной функционал
        try (FileOutputStream fileOutput = new FileOutputStream(file, true);
             // декоратор
             BufferedOutputStream buffer = new BufferedOutputStream(fileOutput)) {

            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Введите данные или stop для выхода");
                String userInput = scanner.nextLine();
                if ("stop".equalsIgnoreCase(userInput)) break;
                buffer.write(userInput.getBytes());
            }
            result = true;
        } catch (IOException e) {
            System.out.println("Проблемы с записью в файл");
        }
        return result;
    }

    public static String readWithBuffer(File file){
        String result = null;
        try (FileInputStream fileInput = new FileInputStream(file);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream()){

            byte[] buffer = new byte[300];
            int count;

            while ((count = bufferedInput.read(buffer)) != -1) {
                byteArray.write(buffer, 0, count);
            }

            result = byteArray.toString(); // new String(byteArray.toString());

        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }

        return result;
    }

    public static boolean byteArrayToImage(File file, byte[] bytes) throws IOException {
        try (ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes)){
            BufferedImage image = ImageIO.read(byteArray);
            return ImageIO.write(image, "png", file);
        }
    }

    public static byte[] imageToBytes(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream();
        ImageIO.write(image, "png", arrayOutput);
        return  arrayOutput.toByteArray();
    }



    
}