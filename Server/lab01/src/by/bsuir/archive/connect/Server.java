package by.bsuir.archive.connect;

import java.io.IOException;
import java.net.ServerSocket;

import by.bsuir.archive.connect.exception.ConnectionException;
import by.bsuir.archive.connect.socket.SocketStream;
import by.bsuir.archive.connect.socket.exception.SocketStreamException;

public class Server {
	private final int PORT_NUMBER = 3353;
	private static final Server server = new Server();

	private Server() {
	}

	public static Server getInstance() {
		return server;
	}

	public void Start() throws ConnectionException {
		ServerSocket socketListener = null;
		SocketStream clientSocket = null;
		try {
			socketListener = new ServerSocket(PORT_NUMBER);
			while (true) {
				clientSocket = new SocketStream(socketListener.accept());
				new ClientThread(clientSocket);
			}
		} catch (IOException e) {
			throw new ConnectionException(e);
		} catch (SocketStreamException e) {
			throw new ConnectionException(e);
		} finally {
			if (socketListener != null) {
				try {
					socketListener.close();
				} catch (IOException e) {
					throw new ConnectionException(e);
				}
			}
		}
	}
}
