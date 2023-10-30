package com.store.storeDemo.exceptions;

public class PricesException extends RuntimeException{

    public PricesException() {
        super("Producto o precio no encontrado");
    }

    public PricesException(String message) {
        super(message);
    }

    public PricesException(String message, Throwable cause) {
        super(message, cause);
    }
}
