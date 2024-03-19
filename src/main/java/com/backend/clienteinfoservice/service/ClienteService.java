package com.backend.clienteinfoservice.service;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.dto.ClienteResponseDTO;
import com.backend.clienteinfoservice.dto.ResponseDTO;
import com.backend.clienteinfoservice.entity.Cliente;
import com.backend.clienteinfoservice.repository.ClienteRepository;
import com.backend.clienteinfoservice.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(ClienteRepository.class);

    @Override
    public ResponseDTO consultarCliente(ClienteRequestDTO requestDTO) throws Exception {
        LOGGER.info("Consultando información del cliente. Parámetros recibidos: {}", requestDTO);
        try {

            ResponseDTO responseDTO = new ResponseDTO();

            if (requestDTO.getNumeroDocumento() == null || requestDTO.getNumeroDocumento().isBlank()) {
                responseDTO.setCodigoRespuesta(HttpStatus.BAD_REQUEST.value());
                responseDTO.setMensaje("Solicitud Incorrecta");
                return responseDTO;
            }

            Cliente cliente = clienteRepository.consultarPorDocumento(requestDTO);
            LOGGER.info("Cliente encontrado: {}", cliente);
            if (cliente == null) {
                responseDTO.setCodigoRespuesta(HttpStatus.NOT_FOUND.value());
                responseDTO.setMensaje("Datos no encontrados");
                return responseDTO;
            }

            ClienteResponseDTO clienteResponseDTO = getClienteResponseDTO(cliente);


            responseDTO.setData(clienteResponseDTO);
            responseDTO.setCodigoRespuesta(HttpStatus.OK.value());
            responseDTO.setMensaje("Datos encontrados");
            return responseDTO;
        } catch (Exception e) {
            LOGGER.error("Error al consultar cliente: {}", e.getMessage());
            throw new Exception("Error interno del servidor: " + e.getMessage());
        }
    }

    private static ClienteResponseDTO getClienteResponseDTO(Cliente cliente) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setPrimerNombre(cliente.getPrimerNombre());
        clienteResponseDTO.setSegundoNombre(cliente.getSegundoNombre());
        clienteResponseDTO.setPrimerApellido(cliente.getPrimerApellido());
        clienteResponseDTO.setSegundoApellido(cliente.getSegundoApellido());
        clienteResponseDTO.setDireccion(cliente.getDireccion());
        clienteResponseDTO.setTelefono(cliente.getTelefono());
        clienteResponseDTO.setCiudadResidencia(cliente.getCiudadResidencia());
        return clienteResponseDTO;
    }
}
