package org.example;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener implements Runnable {
    private static final int SERVER_PORT = 5000;
    private boolean running = true;
    private ServerSocket serverSocket;

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started. Listening for incoming files on port " + SERVER_PORT + "...");

            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Incoming connection from: " + clientSocket.getInetAddress());

                // Handle each incoming connection in a separate thread
                new Thread(new FileReceiver(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        running = false;
    }
}
