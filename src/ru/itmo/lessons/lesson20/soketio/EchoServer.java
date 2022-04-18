package ru.itmo.lessons.lesson20.soketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private int port;
    private Connection connection;

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                printMessage(connection.readMessage());
                connection.sendMessage(SimpleMessage.getMessage("server", "сообщение получено"));
            }
        }
    }

    private void printMessage(SimpleMessage message){
        System.out.println("получено сообщение: " + message);
    }

    public static void main(String[] args) {
        int port = 8090;
        EchoServer messageServer = new EchoServer(port);
        try {
            messageServer.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}