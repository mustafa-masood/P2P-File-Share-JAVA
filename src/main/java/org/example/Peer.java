package org.example;

import java.net.InetAddress;

public class Peer {
    private InetAddress address;
    private int port;

    public Peer(InetAddress address, int port) {
        this.address = address;
        this.port = port;
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return address.getHostAddress() + ":" + port;
    }
}
