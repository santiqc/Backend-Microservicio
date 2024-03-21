package com.backend.clienteinfoservice.repository;


import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.entity.Cliente;
import com.backend.clienteinfoservice.utils.TipoDocumentoEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ClienteRepositoryTest {

    @Mock
    private IClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consultarClientePorDocumentoTest() {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.C);
        requestDTO.setNumeroDocumento("10121314");
        Cliente cliente = new Cliente(1L, TipoDocumentoEnum.C, "10121314", "Juan", "Carlos", "Pérez", "Gómez", "123456789", "Calle 123", "Ciudad A");
        when(clienteRepository.findByTipoDocumentoAndNumeroDocumento(requestDTO.getTipoDocumento(), requestDTO.getNumeroDocumento())).thenReturn(cliente);
        Cliente result = clienteRepository.findByTipoDocumentoAndNumeroDocumento(requestDTO.getTipoDocumento(), requestDTO.getNumeroDocumento());
        assertNotNull(result);
        assertEquals(result.getNumeroDocumento(), requestDTO.getNumeroDocumento());
    }

    @Test
    void consultarClientePorDocumentoNullTest() {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.P);
        requestDTO.setNumeroDocumento("10121314");

        Cliente result = clienteRepository.findByTipoDocumentoAndNumeroDocumento(requestDTO.getTipoDocumento(), requestDTO.getNumeroDocumento());
        assertNull(result);
    }
}
