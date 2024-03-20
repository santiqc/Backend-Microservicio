package com.backend.clienteinfoservice.repository;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.entity.Cliente;
import com.backend.clienteinfoservice.utils.TipoDocumentoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements IClienteRepository {
    private final Logger LOGGER = LoggerFactory.getLogger(ClienteRepository.class);

    @Override
    public Cliente consultarPorDocumento(ClienteRequestDTO requestDTO) {
        LOGGER.info("Este es el cliente a consultar en la persistencia: {}", requestDTO);
        if ("10121314".equals(requestDTO.getNumeroDocumento()) && requestDTO.getTipoDocumento().name().equals("C")) {
            return new Cliente(TipoDocumentoEnum.C, "10121314", "Juan", "Carlos", "Pérez", "Gómez", "123456789", "Calle 123", "Ciudad A");
        }
        return null;
    }


}
