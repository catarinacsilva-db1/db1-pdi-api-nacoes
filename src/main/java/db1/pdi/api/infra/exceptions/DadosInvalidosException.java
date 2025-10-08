package db1.pdi.api.infra.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class DadosInvalidosException extends DataIntegrityViolationException {

    public DadosInvalidosException(String message) {
        super(message);
    }

    public DadosInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
}
