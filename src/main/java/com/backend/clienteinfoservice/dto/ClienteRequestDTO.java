package com.backend.clienteinfoservice.dto;

import com.backend.clienteinfoservice.utils.TipoEnum;

public class ClienteRequestDTO {
    private TipoEnum tipoDocumento;
    private String numeroDocumento;


    public ClienteRequestDTO() {

    }

    public ClienteRequestDTO(TipoEnum tipoDocumento, String numeroDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public TipoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public String toString() {
        return "ClienteRequestDTO{" +
                "tipoDocumento=" + tipoDocumento +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                '}';
    }
}
