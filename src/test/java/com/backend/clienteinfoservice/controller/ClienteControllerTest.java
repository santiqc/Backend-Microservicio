package com.backend.clienteinfoservice.controller;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.dto.ResponseDTO;
import com.backend.clienteinfoservice.entity.Cliente;
import com.backend.clienteinfoservice.exception.ClienteException;
import com.backend.clienteinfoservice.service.IClienteService;
import com.backend.clienteinfoservice.utils.TipoDocumentoEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ClienteControllerTest {
    @Mock
    private IClienteService clienteService;


    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consultarClientePorDocumentoTest() throws ClienteException {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.C);
        requestDTO.setNumeroDocumento("10121314");
        Cliente cliente = new Cliente(1L,TipoDocumentoEnum.C, "10121314", "Juan", "Carlos", "Pérez", "Gómez", "123456789", "Calle 123", "Ciudad A");
        ResponseDTO responseDTO = new ResponseDTO("Datos Encontrados", HttpStatus.OK.value(), cliente);

        when(clienteService.consultarCliente(requestDTO)).thenReturn(responseDTO);

        ResponseEntity<ResponseDTO> response = clienteController.consultarCliente(requestDTO);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(clienteService, times(1)).consultarCliente(requestDTO);
    }
}
