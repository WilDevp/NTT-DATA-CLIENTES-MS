package com.ntt.data.app.controller;

import com.ntt.data.app.exception.InvalidDocumentException;
import com.ntt.data.app.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v01/clientes")
public class ClienteController {
    @GetMapping
    public ResponseEntity<Cliente> obtenerCliente(@RequestParam String tipoDocumento, @RequestParam String numeroDocumento) {
        if (!tipoDocumento.matches("^[CP]$")) {
            throw new InvalidDocumentException("Tipo de documento inválido");
        }
        if (!numeroDocumento.matches("^\\d+$") && !tipoDocumento.equals("P")) {
            throw new InvalidDocumentException("Número de documento inválido");
        }
        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            Cliente cliente = crearCliente("Juan", "Carlos", "Pérez", "García", "3001234567", "Calle 123 #45-67", "Bogotá");
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
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
