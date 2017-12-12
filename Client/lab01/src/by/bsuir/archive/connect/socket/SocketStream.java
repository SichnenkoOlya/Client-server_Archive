package by.bsuir.archive.connect.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import by.bsuir.archive.connect.Message;
import by.bsuir.archive.connect.socket.exception.SocketStreamException;

public class SocketStream {

    protected Socket socket;
    protected ObjectInputStream input;
    protected ObjectOutputStream output;

    public SocketStream(InetAddress acceptorHost, int acceptorPort) throws SocketStreamException {
        try {
			socket = new Socket(acceptorHost, acceptorPort);
	        setStreams();
		} catch (IOException e) {
			throw new SocketStreamException(e);
		}
    }

    public SocketStream(Socket socket) throws SocketStreamException{
        this.socket = socket;
        try {
			setStreams();
		} catch (IOException e) {
			throw new SocketStreamException(e);
		}
    }

    private  void setStreams() throws IOException {
    	OutputStream os=socket.getOutputStream();
        output = new ObjectOutputStream(os);
    	InputStream is=socket.getInputStream();
        input = new ObjectInputStream(is);
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
        Message message=null;
		try {
			message = (Message) input.readObject();
		} catch (ClassNotFoundException | IOException e) {
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