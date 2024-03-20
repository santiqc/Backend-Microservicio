package com.backend.clienteinfoservice.repository;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.entity.Cliente;

public interface IClienteRepository {


    Cliente consultarPorDocumento(ClienteRequestDTO requestDTO);
}
