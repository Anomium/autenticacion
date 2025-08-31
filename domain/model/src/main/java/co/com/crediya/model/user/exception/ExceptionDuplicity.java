package co.com.crediya.model.user.exception;

public class ExceptionDuplicity extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionDuplicity(String mensaje) {
        super(mensaje);
    }
}
