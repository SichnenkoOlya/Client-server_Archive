package by.bsuir.archive.connect.socket;

import java.io.*;
import java.net.*;

import by.bsuir.archive.connect.Message;
import by.bsuir.archive.connect.socket.exception.SocketStreamException;

public class SocketStream {

	protected Socket socket;
	protected ObjectInputStream input = null;
	protected ObjectOutputStream output = null;

	SocketStream(InetAddress acceptorHost, int acceptorPort) throws SocketStreamException {
		try {
			socket = new Socket(acceptorHost, acceptorPort);
			setStreams();
		} catch (IOException e) {
			throw new SocketStreamException();
		}
	}

	public SocketStream(Socket socket) throws SocketStreamException {
		this.socket = socket;
		setStreams();
	}

	private void setStreams() throws SocketStreamException {
		try {
			OutputStream os = socket.getOutputStream();
			output = new ObjectOutputStream(os);
			InputStream is = socket.getInputStream();
			input = new ObjectInputStream(is);
		} catch (IOException e) {
			throw new SocketStreamException();
		}
	}

	public void sendMessage(Message message) throws SocketStreamException {

		try {
			output.writeObject(message);
			output.flush();
		} catch (IOException e) {
			throw new SocketStreamException(e);
		}
	}

	public Message receiveMessage() throws SocketStreamException {
		Message message = null;
		try {
			message = (Message) input.readObject();
		} catch (ClassNotFoundException e) {
			throw new SocketStreamException(e);
		} catch (IOException e) {
			throw new SocketStreamException(e);
		}
		return message;
	}

	public void close() throws SocketStreamException {
		try {
			socket.close();
		} catch (IOException e) {
			throw new SocketStreamException(e);
		}
	}

}