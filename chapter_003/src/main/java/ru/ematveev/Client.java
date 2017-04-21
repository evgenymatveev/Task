package ru.ematveev;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class Client for query answers from the server.
 */
public class Client {
    private static final int PORT = 7667;
    private static final String IP = "127.0.0.1";
    private final Socket socket;

    private Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * The method for send the request for server.
      */
    private void clientBot() {
        try (InputStream sin = socket.getInputStream();
             OutputStream sout = socket.getOutputStream();
             DataInputStream in = new DataInputStream(sin);
             DataOutputStream out = new DataOutputStream(sout)) {

            Scanner console = new Scanner(System.in);

            String str;
            String cons;
            do {
                cons = console.next();
                out.writeUTF(cons);
                out.flush();
                do {
                    str = in.readUTF();
                    System.out.println(str);
                } while (!str.equals(""));
            } while (!cons.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * The method for start the Client.
     * @param args String argements.
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(InetAddress.getByName(IP), PORT)) {
            new Client(socket).clientBot();
        }
    }
}


