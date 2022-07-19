package co.edu.udea.arquitectura.exception;

/**
 * Exception when any resource or data is not found.
 */
public class DataNotFoundException extends co.edu.udea.arquitectura.exception.GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }

}
