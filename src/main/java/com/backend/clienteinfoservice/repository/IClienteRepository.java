package com.backend.clienteinfoservice.repository;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.entity.Cliente;
import com.backend.clienteinfoservice.utils.TipoEnum;

public interface IClienteRepository {


    Cliente consultarPorDocumento(ClienteRequestDTO requestDTO);
}
