package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.Executors;

public class MainGUI extends JFrame {
    private DefaultListModel<Peer> peerListModel;
    private JList<Peer> peerJList;
    private JLabel selectedFileLabel;
    private File selectedFile;
    private PeerDiscovery discovery;

    public MainGUI() {
        setTitle("P2P File Sharing");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        peerListModel = new DefaultListModel<>();
        peerJList = new JList<>(peerListModel);
        selectedFileLabel = new JLabel("No file selected.");

        JButton selectFileButton = new JButton("Select File");
        JButton refreshPeersButton = new JButton("Refresh Peers");
        JButton sendFileButton = new JButton("Send File");

        selectFileButton.addActionListener(e -> selectFile());
        refreshPeersButton.addActionListener(e -> refreshPeers());
        sendFileButton.addActionListener(e -> sendFile());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(selectFileButton);
        topPanel.add(refreshPeersButton);
        topPanel.add(sendFileButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(peerJList), BorderLayout.CENTER);
        panel.add(selectedFileLabel, BorderLayout.SOUTH);

        add(panel);

        discovery = new PeerDiscovery();
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                discovery.listenForPeers();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    private void selectFile() {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            selectedFileLabel.setText("Selected: " + selectedFile.getName());
        }
    }

    private void refreshPeers() {
        try {
            discovery.broadcastPresence();
            Set<Peer> peers = discovery.getPeers();
            peerListModel.clear();
            for (Peer peer : peers) {
                peerListModel.addElement(peer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void sendFile() {
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "Please select a file first!");
            return;
        }
        Peer selectedPeer = peerJList.getSelectedValue();
        if (selectedPeer == null) {
            JOptionPane.showMessageDialog(this, "Please select a peer!");
            return;
        }

        Executors.newSingleThreadExecutor().submit(() -> FileSender.sendFile(selectedFile, selectedPeer));
    }
}
