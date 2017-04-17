package ru.ematveev;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Matveev Evgeny.
 */
public class Server {

    public static void main(String[] args) throws IOException{
        int port = 4000;

            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            System.out.println("Сервер ждет подключения юзера");

        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String ask;
            do {
                ask = in.readUTF();//ожидаем пока клиент пришлет строку текста.
                System.out.println(ask);
                if (ask.equals("hello")) {
                    out.writeUTF("Hello, dear friend, I'm a oracle.");
                    out.flush();
                    } else {
                        out.writeUTF("5555555");// отсылаем клиенту.
                        out.flush();// заставляем поток закончить передачу данных.
                    }
                    System.out.println("Waiting for the next line...");
            } while (ask.equals("exit")) ;


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


