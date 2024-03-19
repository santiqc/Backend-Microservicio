package com.backend.clienteinfoservice.exception;


public class ClienteException extends RuntimeException {

    private final String mensaje;

    public ClienteException(String message) {
        super(message);
        this.mensaje = message;
    }

    @Override
    public String toString() {
        return "TodoListExc{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }

    public String getMensaje() {
        return mensaje;
    }
}
