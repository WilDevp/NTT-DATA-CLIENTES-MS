package com.ntt.data.app.controllerTest;

import com.ntt.data.app.controller.ClienteController;
import com.ntt.data.app.exception.InvalidDocumentException;
import com.ntt.data.app.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    @InjectMocks
    private ClienteController clienteController;
    public Cliente cliente;
    @BeforeEach
    void setUp() {
        clienteController = new ClienteController();
        cliente = new Cliente();
        cliente.setPrimerNombre("Juan");
        cliente.setSegundoNombre("Carlos");
        cliente.setPrimerApellido("Pérez");
        cliente.setSegundoApellido("García");
        cliente.setTelefono("3001234567");
        cliente.setDireccion("Calle 123 #45-67");
        cliente.setCiudad("Bogotá");
    }
    @Test
     void testObtenerDocumentoClienteOK() {
        ResponseEntity<Cliente> response = clienteController.obtenerCliente("C", "23445322");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente.getPrimerNombre(), response.getBody().getPrimerNombre());
        assertEquals(cliente.getSegundoNombre(), response.getBody().getSegundoNombre());
        assertEquals(cliente.getPrimerApellido(), response.getBody().getPrimerApellido());
        assertEquals(cliente.getSegundoApellido(), response.getBody().getSegundoApellido());
        assertEquals(cliente.getTelefono(), response.getBody().getTelefono());
        assertEquals(cliente.getDireccion(), response.getBody().getDireccion());
        assertEquals(cliente.getCiudad(), response.getBody().getCiudad());
    }

    @Test
    void testObtenerDocumentoClienteBadRequest() {
        assertThrows(InvalidDocumentException.class, () -> clienteController.obtenerCliente("X", "12345678"));
    }

    @Test
    void testObtenerDocumentoClienteNotFound() {
        ResponseEntity<Cliente> response = clienteController.obtenerCliente("C", "11111111");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());    }
}
