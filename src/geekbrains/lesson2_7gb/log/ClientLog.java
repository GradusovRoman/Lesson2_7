package geekbrains.lesson2_7gb.log;

import java.io.*;
import java.net.Socket;



public class ClientLog {
    private static final int logShowLimit = 100;
    private String serverHost;
    private int serverPort;
    private Logger logger;

    public ClientLog(String serverHost, int serverPort, Logger logger) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.logger = logger;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             Socket socket = new Socket(serverHost, serverPort)) {

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.printf("Последние %s сообщений от этого пользователя:\n" + logger.getLastMessages(logShowLimit) + "\n",
                    logShowLimit);

            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        logger.addMessage(message);
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("SWW", e);
                }
            }).start();

            String text;
            while ((text = br.readLine()) != null) {
                out.writeUTF(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}