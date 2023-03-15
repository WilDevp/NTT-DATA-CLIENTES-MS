package com.ntt.data.app.model;

import lombok.Data;

@Data
public class Cliente {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudad;

}
