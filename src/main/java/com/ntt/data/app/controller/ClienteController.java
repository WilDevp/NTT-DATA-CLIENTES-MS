package com.ntt.data.app.controller;

import com.ntt.data.app.exception.InvalidDocumentException;
import com.ntt.data.app.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v01/clientes")
public class ClienteController {
    public static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);
    @GetMapping
    public ResponseEntity<Cliente> obtenerCliente(@RequestParam String tipoDocumento, @RequestParam String numeroDocumento) {
        LOGGER.info("Solicitud recibida para obtener cliente con tipoDocumento: {} y numeroDocumento: {}", tipoDocumento, numeroDocumento);

        if (!tipoDocumento.matches("^[CP]$")) {
            throw new InvalidDocumentException("Tipo de documento inválido");
        }
        if (!numeroDocumento.matches("^\\d+$") && !tipoDocumento.equals("P")) {
            throw new InvalidDocumentException("Número de documento inválido");
        }
        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            Cliente cliente = crearCliente("Juan", "Carlos", "Pérez", "García", "3001234567", "Calle 123 #45-67", "Bogotá");
            LOGGER.info("Cliente encontrado: {}", cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            LOGGER.warn("Cliente no encontrado para tipoDocumento: {} y numeroDocumento: {}", tipoDocumento, numeroDocumento);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        private Cliente crearCliente(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
                String telefono, String direccion, String ciudad) {
            Cliente cliente = new Cliente();
            cliente.setPrimerNombre(primerNombre);
            cliente.setSegundoNombre(segundoNombre);
            cliente.setPrimerApellido(primerApellido);
            cliente.setSegundoApellido(segundoApellido);
            cliente.setTelefono(telefono);
            cliente.setDireccion(direccion);
            cliente.setCiudad(ciudad);
            return cliente;
        }
}
