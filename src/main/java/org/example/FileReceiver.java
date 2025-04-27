package org.example;

import java.io.*;
import java.net.Socket;

public class FileReceiver implements Runnable {
    private Socket socket;

    public FileReceiver(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()))) {
            String fileName = dis.readUTF();
            long fileSize = dis.readLong();

            File receivedFile = new File("Received_" + fileName);
            try (FileOutputStream fos = new FileOutputStream(receivedFile)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                long totalRead = 0;

                while ((bytesRead = dis.read(buffer, 0, Math.min(buffer.length, (int)(fileSize - totalRead)))) > 0) {
                    fos.write(buffer, 0, bytesRead);
                    totalRead += bytesRead;
                    if (totalRead >= fileSize) break;
                }
            }

            System.out.println("File received: " + receivedFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
