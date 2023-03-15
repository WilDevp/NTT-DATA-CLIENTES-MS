package com.ntt.data.app.controller;

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
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!numeroDocumento.matches("^\\d+$") && !tipoDocumento.equals("P")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cliente cliente = obtenerClientePorDocumento(tipoDocumento, numeroDocumento);

        if (cliente != null) {
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
    private Cliente obtenerClientePorDocumento(String tipoDocumento, String numeroDocumento) {
        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            return crearCliente("Juan", "Carlos", "Pérez", "García", "3001234567", "Calle 123 #45-67", "Bogotá");
        } else if (tipoDocumento.equals("P") && numeroDocumento.equals("P123456789")) {
            return crearCliente("Maria", "Fernanda", "Rodríguez", "López", "3129876543", "Avenida 456 #78-90", "Medellín");
        }
        return null;
    }


}
