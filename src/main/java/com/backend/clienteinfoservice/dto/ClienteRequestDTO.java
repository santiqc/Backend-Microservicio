package com.backend.clienteinfoservice.dto;

import com.backend.clienteinfoservice.utils.TipoDocumentoEnum;

public class ClienteRequestDTO {
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;


    public ClienteRequestDTO() {

    }

    public ClienteRequestDTO(TipoDocumentoEnum tipoDocumento, String numeroDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public TipoDocumentoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
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
