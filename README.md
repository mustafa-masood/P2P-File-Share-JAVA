# 📂 Peer-to-Peer (P2P) File Sharing System

A **Java-based** decentralized application for secure and efficient **file sharing directly between peers**, using **Java Sockets** and a **Swing GUI**.

---

## 📋 Features
- 🔎 **Peer Discovery** via UDP broadcasts
- 📤 **File Upload/Download** without a central server
- 🔁 **Reliable TCP File Transfer**
- 🖥️ **Simple Swing GUI** for file management
- 🧩 **Multithreaded** background server

---

## 🏗️ Project Structure
```
src/main/java/org/example/
├── MainApp.java
├── MainGUI.java
├── Peer.java
├── PeerDiscovery.java
├── FileSender.java
├── FileReceiver.java
├── ServerListener.java
```

---

## 🚀 How to Run

### Requirements
- Java JDK 8+
- IntelliJ IDEA or any Java IDE

### Running Steps
```bash
javac org/example/*.java
java org.example.MainApp
```

✅ To test multiple peers:  
- Use different computers on the same network, or
- Use separate VMs or sessions.

---

## ⚙️ Application Flow
1. Start Application ➔ Open GUI
2. Select a File ➔ Choose file
3. Refresh Peers ➔ Discover peers
4. Select Peer ➔ Choose peer
5. Send File ➔ Transfer initiated

Received files are stored as:
```
Received_<original_filename>
```

---

## 📡 Notes
- Both peers must be on the same Wi-Fi or LAN.
- Allow Java through the firewall if prompted.
- Each device binds to port `5000` by default.

---

## 📚 References
- [Java Networking - Oracle Documentation](https://docs.oracle.com/javase/tutorial/networking/)
- [Peer-to-Peer Architecture Overview - GeeksforGeeks](https://www.geeksforgeeks.org/peer-to-peer-architecture/)

---

## 👩‍💻 Authors
- Laiba Fatima
- Mustafa Masood

---

# 📜 License
Educational use only. 🚀
```
