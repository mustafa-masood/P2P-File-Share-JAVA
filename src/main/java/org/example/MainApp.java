package org.example;

import javax.swing.*;


public class MainApp {
    public static void main(String[] args) {
        // Start the server to listen for incoming files
        new Thread(new ServerListener()).start();

        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });
    }
}
