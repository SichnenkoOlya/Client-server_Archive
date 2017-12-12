package by.bsuir.archive.connect.exception;

public class ConnectionException extends Exception{
	private static final long serialVersionUID = 1L;

	public ConnectionException(){
	}

	public ConnectionException(Exception e){
		super(e);
	}
	
	public ConnectionException(String message){
		super(message);
	}
	
	public ConnectionException(String message, Exception e){
		super(message, e);
	}
}