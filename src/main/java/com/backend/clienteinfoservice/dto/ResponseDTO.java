package com.backend.clienteinfoservice.dto;

import java.io.Serial;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2116568911643824350L;

    private String mensaje;
    private int codigoRespuesta;
    private transient Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(String mensaje, int codigoRespuesta, Object data) {
        this.mensaje = mensaje;
        this.codigoRespuesta = codigoRespuesta;
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "mensaje='" + mensaje + '\'' +
                ", codigoRespuesta=" + codigoRespuesta +
                ", data=" + data +
                '}';
    }
}
