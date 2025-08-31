package co.com.crediya.api.error;

public class ExceptionTechnical extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionTechnical(String message) {
        super(message);
    }
	
	public ExceptionTechnical(String message, Exception e) {
		super(message,e);
	}
}
