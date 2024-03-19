package com.backend.clienteinfoservice.service;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.dto.ResponseDTO;
import com.backend.clienteinfoservice.exception.ClienteException;

public interface IClienteService {

    ResponseDTO consultarCliente(ClienteRequestDTO requestDTO) throws ClienteException;


}
