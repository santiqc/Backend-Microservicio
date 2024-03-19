package com.backend.clienteinfoservice.controller;

import com.backend.clienteinfoservice.dto.ClienteRequestDTO;
import com.backend.clienteinfoservice.dto.ResponseDTO;
import com.backend.clienteinfoservice.repository.ClienteRepository;
import com.backend.clienteinfoservice.service.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    private final Logger LOGGER = LoggerFactory.getLogger(ClienteRepository.class);

    @PostMapping("/cliente")
    public ResponseEntity<ResponseDTO> consultarCliente(@RequestBody ClienteRequestDTO requestDTO) throws Exception {
        ResponseDTO responseDTO = clienteService.consultarCliente(requestDTO);
        HttpStatus status = HttpStatus.valueOf(responseDTO.getCodigoRespuesta());
        LOGGER.info("Respuesta enviada al cliente: {}", responseDTO);
        return new ResponseEntity<>(responseDTO, status);

    }

}
