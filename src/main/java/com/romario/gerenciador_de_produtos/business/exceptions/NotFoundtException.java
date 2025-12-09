package com.romario.gerenciador_de_produtos.business.exceptions;

public class NotFoundtException extends RuntimeException {
    public NotFoundtException(String message) {
        super(message);
    }

    public NotFoundtException(String message, Throwable cause) {
        super(message, cause);
    }
}
