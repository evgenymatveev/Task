package ru.ematveev;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Class the Server for send the answer for client.
 */
public class Server {
    private final Random random = new Random();
    private static final int port = 7667;
    private final Socket socket;
    private final String[] answer = new String[]{"answer1", "answer2", "answer3", "answer4", "answer5", "answer6"};

    private Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * The method for generate random answers for the client.
     * @param s array answers for client.
     * @return String random answer.
     */
    private String generate(String[] s) {
        int res = random.nextInt(6);
            return answer[res];
    }

    /**
     * The method for receiving the answers and send the requests.
     */
    private void serverBot() {
        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String ask;
            do {
                ask = in.readUTF();
                System.out.println(ask);
                if (ask.equals("hello")) {
                    out.writeUTF("Hello, dear friend, I'm a oracle.");
                    out.writeUTF("");
                    out.flush();
                } else if (!ask.equals("hello")) {
                    //String s = generate(answer);
                    out.writeUTF(generate(answer));
                    out.writeUTF(generate(answer));
                    out.writeUTF(generate(answer));
                    out.writeUTF(generate(answer));
                    out.writeUTF("");
                    out.flush();
                }
                System.out.println("Waiting for the next line...");
            } while (!ask.equals("exit"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method for start the Server.
     * @param args String argements.
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept()) {
            new Server(socket).serverBot();
        }
    }
}


