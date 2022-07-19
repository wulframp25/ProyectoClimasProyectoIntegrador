package co.edu.udea.arquitectura.exception;

/**
 * Exception for duplicated data in the application
 */
public class BusinessException extends co.edu.udea.arquitectura.exception.GeneralRuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, String translationKey) {
        super(message, translationKey);
    }

}
