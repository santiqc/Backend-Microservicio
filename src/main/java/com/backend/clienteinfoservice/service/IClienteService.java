package com.backend.clienteinfoservice.service;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.dto.ClienteResponseDTO;
import com.backend.clienteinfoservice.dto.ResponseDTO;

public interface IClienteService {

    ResponseDTO consultarCliente(ClienteRequestDTO requestDTO) throws Exception;


}
