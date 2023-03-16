# NTT-DATA-CLIENTES-MS
# Prueba Práctica - Backend Microservicio
Este documento detalla cómo crear un microservicio REST en Java utilizando Spring Boot y Maven. También cubre cómo realizar pruebas unitarias y cómo probar el microservicio.

## Contenido

1.  Crear el proyecto con Spring Initializr
2.  Configurar la aplicación
3.  Crear el modelo de datos
4.  Implementar el controlador
5.  Probar el microservicio
6.  Crear pruebas unitarias

### 1. Crear el proyecto con Spring Initializr

Utiliza Spring Initializr para generar un nuevo proyecto Maven con las siguientes configuraciones:

-   Group: com.ntt.data
-   Artifact: NTT-DATA-CLIENTES-MS
-   Packaging: Jar
-   Java version: 11
-   Dependencies: Spring Web

## Requisitos

1.  JDK 8 o superior
2.  Maven
3.  IDE (Eclipse, IntelliJ IDEA, etc.)

## Pasos

### 1. Crear el proyecto Spring Boot

Utiliza [Spring Initializr](https://start.spring.io/) para crear un proyecto Spring Boot con las siguientes opciones:

-   Tipo de Proyecto: Maven
-   Lenguaje: Java
-   Empaquetado: Jar
-   Versión de Java: 8 o superior
-   Dependencias: Spring Web, Lombok

Descarga y extrae el archivo ZIP generado.

### 2. Configurar la aplicación

Agrega la siguiente propiedad en el archivo `application.properties` para establecer el puerto en el que la aplicación debe iniciarse:

Copy code

`server.port=8090` 

### 3. Crear el modelo de datos

Crea una nueva clase `Cliente` en el paquete `com.ntt.data.app.model` y agrega los atributos y métodos correspondientes.

### 4. Implementar el controlador

Crea una nueva clase `ClienteController` en el paquete `com.ntt.data.app.controller`. Implementa un método `obtenerClientePorDocumento` para manejar las solicitudes GET a la ruta `/api/clientes/{tipoDocumento}/{numeroDocumento}`. Asegúrate de manejar los códigos de respuesta HTTP (200, 400, 404 y 500) de acuerdo con los requisitos del proyecto.

### 5. Probar el microservicio

Ejecuta la aplicación y utiliza una herramienta como Postman para realizar solicitudes al microservicio. Verifica que las respuestas sean las esperadas.

### 6. Crear pruebas unitarias

Crea una nueva clase de prueba `ClienteControllerTest` en el paquete `com.ntt.data.app.controllerTest`. Implementa pruebas unitarias para los diferentes casos posibles y verifica que todas las pruebas pasen.
