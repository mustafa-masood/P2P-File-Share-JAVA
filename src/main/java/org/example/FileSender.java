package org.example;

import java.io.*;
import java.net.Socket;

public class FileSender {

    public static void sendFile(File file, Peer peer) {
        try (Socket socket = new Socket(peer.getAddress(), 5000);
             FileInputStream fis = new FileInputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
             DataOutputStream dos = new DataOutputStream(bos)) {

            dos.writeUTF(file.getName());
            dos.writeLong(file.length());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
            dos.flush();
            System.out.println("File sent successfully to " + peer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
