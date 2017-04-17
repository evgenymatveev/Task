package ru.ematveev;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Matveev Evgeny.
 */
public class Client {
    public static void main(String[] args) {
        int port = 4000;
        String ip = "127.0.0.1";
    try {
        InetAddress inetAddress = InetAddress.getByName(ip);
        Socket socket = new Socket(inetAddress, port);

        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();
        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);
        Scanner console = new Scanner(System.in);

        String str;
        String cons;
            do {
                cons = console.next();
                out.writeUTF(cons);
                out.flush();
                str = in.readUTF();
                System.out.println(str);

            } while (cons.equals("exit"));
    } catch (Exception e) {
        e.printStackTrace();
    }

    }
}


