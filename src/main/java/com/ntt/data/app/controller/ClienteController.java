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
    public ResponseEntity<Cliente> obtenerCliente(@RequestParam String tipoDocumento, @RequestParam String numeroDocumento){
        if (!tipoDocumento.matches("^[CP]$")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!numeroDocumento.matches("^\\d+$") && !tipoDocumento.equals("P")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            Cliente cliente = new Cliente();
            cliente.setPrimerNombre("Ares");
            cliente.setSegundoNombre("Rio");
            cliente.setPrimerApellido("Garcia");
            cliente.setSegundoApellido("Guerra");
            cliente.setTelefono("3001234567");
            cliente.setDireccion("Calle 123 #45-67");
            cliente.setCiudad("Medellín");

            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else if (tipoDocumento.equals("P") && numeroDocumento.equals("P123456789")) {
            Cliente cliente = new Cliente();
            cliente.setPrimerNombre("Maria");
            cliente.setSegundoNombre("Fernanda");
            cliente.setPrimerApellido("Rodríguez");
            cliente.setSegundoApellido("López");
            cliente.setTelefono("3129876543");
            cliente.setDireccion("Avenida 456 #78-90");
            cliente.setCiudad("Medellín");

            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
