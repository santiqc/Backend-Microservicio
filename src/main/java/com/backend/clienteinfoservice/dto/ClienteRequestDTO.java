package com.backend.clienteinfoservice.dto;

import com.backend.clienteinfoservice.utils.TipoDocumentoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequestDTO {
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
}
