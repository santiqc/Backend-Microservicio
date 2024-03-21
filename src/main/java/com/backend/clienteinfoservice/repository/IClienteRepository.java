package com.backend.clienteinfoservice.repository;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.entity.Cliente;
import com.backend.clienteinfoservice.utils.TipoDocumentoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByTipoDocumentoAndNumeroDocumento(TipoDocumentoEnum tipoDocumentoEnum, String numeroDocumento);
}
