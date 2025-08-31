package co.com.crediya.model.user.exception;

public class ExceptionWithoutData extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExceptionWithoutData(String message) {
        super(message);
    }
}
