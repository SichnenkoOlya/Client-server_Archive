package by.bsuir.archive.connect;

import by.bsuir.archive.connect.socket.SocketStream;
import by.bsuir.archive.connect.socket.exception.SocketStreamException;
import by.bsuir.archive.controller.Controller;

public class ClientThread extends Thread {

	private SocketStream clientSocket = null;
	private Controller controller = new Controller();

	public ClientThread(SocketStream clientSocket) {
		this.clientSocket = clientSocket;
		this.start();
	}

	public void run() {
		try {
			while (true) {
				Message message = clientSocket.receiveMessage();
				if (message.getCommand().equals("BYE")) {
					break;
				}
				String response = controller.doAction(message);
				message = new Message("ANSWER");
				message.setAnswer(response);
				clientSocket.sendMessage(message);
			}
		} catch (SocketStreamException e) {
			e.printStackTrace();
		}
	}
}