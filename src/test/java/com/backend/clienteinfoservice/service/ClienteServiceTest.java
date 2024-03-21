package com.backend.clienteinfoservice.service;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.dto.ResponseDTO;
import com.backend.clienteinfoservice.entity.Cliente;
import com.backend.clienteinfoservice.exception.ClienteException;
import com.backend.clienteinfoservice.repository.IClienteRepository;
import com.backend.clienteinfoservice.utils.Mensaje;
import com.backend.clienteinfoservice.utils.TipoDocumentoEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {
    @Mock
    private IClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consultarClientePorDocumentoTest() throws ClienteException {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.C);
        requestDTO.setNumeroDocumento("10121314");

        Cliente cliente = new Cliente(1L, TipoDocumentoEnum.C, "10121314", "Juan", "Carlos", "Pérez", "Gómez", "123456789", "Calle 123", "Ciudad A");
        when(clienteRepository.findByTipoDocumentoAndNumeroDocumento(requestDTO.getTipoDocumento(), requestDTO.getNumeroDocumento())).thenReturn(cliente);

        ResponseDTO result = clienteService.consultarCliente(requestDTO);
        assertNotNull(result);
        assertEquals(result.getCodigoRespuesta(), HttpStatus.OK.value());
        verify(clienteRepository, times(1)).findByTipoDocumentoAndNumeroDocumento(requestDTO.getTipoDocumento(), requestDTO.getNumeroDocumento());
    }

    @Test
    void consultarClientePorDocumentoRequestNullTest() throws ClienteException {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.C);
        requestDTO.setNumeroDocumento(null);

        Cliente cliente = new Cliente(1L,TipoDocumentoEnum.C, "10121314", "Juan", "Carlos", "Pérez", "Gómez", "123456789", "Calle 123", "Ciudad A");
        when(clienteRepository.findByTipoDocumentoAndNumeroDocumento(requestDTO.getTipoDocumento(), requestDTO.getNumeroDocumento())).thenReturn(cliente);

        ResponseDTO result = clienteService.consultarCliente(requestDTO);
        assertNotNull(result);
        assertEquals(result.getCodigoRespuesta(), HttpStatus.BAD_REQUEST.value());
        assertEquals(result.getMensaje(), "Solicitud Incorrecta");
    }


    @Test
    void consultarClientePorDocumentoClienteNullTest() throws ClienteException {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.C);
        requestDTO.setNumeroDocumento("12334432");

        String mensaje = String.format(Mensaje.USUARIO_NO_ENCONTRADO, Mensaje.CEDULA_CIUDADANIA, requestDTO.getNumeroDocumento());
        when(clienteRepository.findByTipoDocumentoAndNumeroDocumento(requestDTO.getTipoDocumento(), requestDTO.getNumeroDocumento())).thenReturn(null);

        ResponseDTO result = clienteService.consultarCliente(requestDTO);
        assertNotNull(result);
        assertEquals(result.getCodigoRespuesta(), HttpStatus.NOT_FOUND.value());
        assertEquals(result.getMensaje(), mensaje);
    }

    @Test
    void consultarClientePorDocumentoTestThrowException() throws ClienteException {
        ClienteRequestDTO requestDTO = new ClienteRequestDTO();
        requestDTO.setTipoDocumento(TipoDocumentoEnum.C);
        requestDTO.setNumeroDocumento("12334432");

        when(clienteRepository.findByTipoDocumentoAndNumeroDocumento(any(), any())).thenThrow(new ClienteException("Simulated Exception"));

        ClienteException exception = assertThrows(ClienteException.class, () -> clienteService.consultarCliente(requestDTO));
        assertEquals("Error al consultar cliente por documento: Simulated Exception", exception.getMessage());
    }
}
