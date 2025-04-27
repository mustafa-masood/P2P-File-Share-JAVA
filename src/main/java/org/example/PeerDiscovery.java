package org.example;

import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class PeerDiscovery {
    private static final int DISCOVERY_PORT = 8888;
    private static final String DISCOVERY_MESSAGE = "DISCOVER_P2P_PEER";
    private Set<Peer> peers = new HashSet<>();
    private DatagramSocket socket;

    public void broadcastPresence() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer = DISCOVERY_MESSAGE.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), DISCOVERY_PORT);
        socket.setBroadcast(true);
        socket.send(packet);
        socket.close();
    }

    public Set<Peer> listenForPeers() throws Exception {
        DatagramSocket socket = new DatagramSocket(DISCOVERY_PORT, InetAddress.getByName("0.0.0.0"));
        socket.setBroadcast(true);

        while (true) {
            byte[] buffer = new byte[15000];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String message = new String(packet.getData()).trim();
            if (message.equals(DISCOVERY_MESSAGE)) {
                peers.add(new Peer(packet.getAddress(), packet.getPort()));
            }
        }
    }

    public Set<Peer> getPeers() {
        return peers;
    }
}
