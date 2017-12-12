package by.bsuir.archive.connect.socket.exception;

public class SocketStreamException extends Exception{
	private static final long serialVersionUID = 1L;

	public SocketStreamException(){
	}

	public SocketStreamException(Exception e){
		super(e);
	}
	
	public SocketStreamException(String message){
		super(message);
	}
	
	public SocketStreamException(String message, Exception e){
		super(message, e);
	}
}