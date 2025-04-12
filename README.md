# P2P File Sharing System in Java

## Project Overview
The **P2P File Sharing System** is a decentralized file sharing application built using Java’s socket programming. It allows users to share files directly with each other, without relying on a central server. The system enables **peer discovery** and **reliable file transfer** over a local network.

### Features:
- **Peer Discovery**: Automatically detect active peers on the network using UDP multicast.
- **File Sharing**: Share files by selecting them from your local system.
- **Reliable File Transfer**: Files are split into chunks for transmission, with error handling and retransmission mechanisms to ensure integrity.
- **Peer List**: View all active peers currently available on the network.
- **User Interface**: A simple text-based or GUI interface for managing file transfers and peer connections.

## Getting Started

### Prerequisites
Make sure you have the following installed:
- **Java 8+** (Java Development Kit - JDK)
- **Maven** or **Gradle** (optional for dependency management)
- A **text editor** or **IDE** (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code)
- **Git** (for version control)

### Clone the Repository
```bash
git clone https://github.com/yourusername/P2P-File-Sharing-System.git
cd P2P-File-Sharing-System
```

### Setup and Installation

1. **Download and Install JDK 8 or later**:
   - Follow the installation instructions [here](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Install Dependencies** (if using Maven/Gradle):
   - For Maven, run:
     ```bash
     mvn install
     ```
   - For Gradle, run:
     ```bash
     gradle build
     ```

3. **Compile the Code**:
   - If using an IDE, simply build the project using the IDE's build option.
   - For command line, run:
     ```bash
     javac -d bin src/*.java
     ```

### Running the Application
- **Start a Peer**: Launch the application using the `Peer` class.
    - If using **command line**, run:
      ```bash
      java Peer
      ```
    - If using **IDE**, run the `Peer` class directly from the IDE.

- **Send/Receive Files**:
    - Once the program starts, you will see a list of available peers. Choose a peer to send a file to or wait for someone to send you a file.

- **Peer Discovery**:
    - The peer discovery works using **UDP** multicast to find active peers on the network. Make sure the machine is connected to a local network (LAN) for this to work.

### Example Usage

1. **Starting Peer 1**:
    - The first peer starts the program, discovers other peers, and waits for file transfer requests.

2. **Starting Peer 2**:
    - The second peer starts the program, discovers Peer 1, and sends a file.

3. **Transfer Status**:
    - During the transfer, the user can view the progress (e.g., "Sending: 50% complete").
    - If the transfer is interrupted, the system will automatically retry the failed chunks.

### Stopping the Application
To exit the program, simply close the terminal window or press `Ctrl+C`.

## Code Structure

- **`Peer.java`**: Entry point of the application. Handles peer discovery and the main program logic.
- **`PeerDiscovery.java`**: Responsible for broadcasting and listening for peers using UDP.
- **`FileTransferManager.java`**: Manages file splitting, chunking, and transfer.
- **`SocketHandler.java`**: Manages socket connections between peers for file transfers.
- **`UIManager.java`**: Provides user interface logic (console or GUI).
- **`PeerHandler.java`**: Handles individual peer connections.

## Contribution Guidelines

If you'd like to contribute to this project, feel free to fork the repository, create a branch for your feature or bugfix, and submit a pull request.

### Steps to contribute:
1. Fork this repository.
2. Clone your forked repository:
   ```bash
   git clone https://github.com/yourusername/P2P-File-Sharing-System.git
   ```
3. Create a new branch:
   ```bash
   git checkout -b feature-name
   ```
4. Make your changes.
5. Commit your changes:
   ```bash
   git commit -m "Add a feature"
   ```
6. Push to your branch:
   ```bash
   git push origin feature-name
   ```
7. Open a pull request and describe your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## References

- [Java Sockets Documentation](https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html)
- [Peer-to-Peer Network Protocols Overview](https://www.geeksforgeeks.org/peer-to-peer-architecture/)
- [File Transfer Protocols in Java](https://www.geeksforgeeks.org/implementation-of-file-transfer-in-java/)
- [Java Networking and Sockets Tutorials](https://www.tutorialspoint.com/java/java_networking.htm)

## Acknowledgments

- Thanks to the authors of online tutorials and documentation which were used to develop this project.
- Special thanks to the project team for their collaboration and hard work!
