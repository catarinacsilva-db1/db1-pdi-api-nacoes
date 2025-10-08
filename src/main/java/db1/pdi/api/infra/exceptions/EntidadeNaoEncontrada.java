package db1.pdi.api.infra.exceptions;

public class EntidadeNaoEncontrada extends RuntimeException {

    public EntidadeNaoEncontrada(String message) {
        super(message);
    }

    public EntidadeNaoEncontrada(String message, Throwable cause) {
        super(message, cause);
    }
}

