package com.backend.clienteinfoservice.repository;


import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.entity.Cliente;
import com.backend.clienteinfoservice.utils.TipoDocumentoEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteRepositoryTest {

    @InjectMocks
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consultarClientePorDocumentoTest() {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.C);
        requestDTO.setNumeroDocumento("10121314");
        Cliente result = clienteRepository.consultarPorDocumento(requestDTO);
        assertNotNull(result);
        assertEquals(result.getNumeroDocumento(), requestDTO.getNumeroDocumento());
    }

    @Test
    void consultarClientePorDocumentoNullTest() {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.P);
        requestDTO.setNumeroDocumento("10121314");

        Cliente result = clienteRepository.consultarPorDocumento(requestDTO);
        assertNull(result);
    }
}
