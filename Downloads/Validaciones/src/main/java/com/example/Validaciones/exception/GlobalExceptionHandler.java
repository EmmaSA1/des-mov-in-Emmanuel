package com.example.Validaciones.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> manejarRecursoNoEncontrado(NoResourceFoundException ex) {
        return new ResponseEntity<>("error 404 recurso no encotrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity< String> manejarValidacion(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("tipo de dato no valido", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity< String> nullPE(NullPointerException ex) {
        return new ResponseEntity<>("tipo de dato no valido", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcionGeneral(Exception ex) {
        return new ResponseEntity<>(" error 500 inesperado contacta soporte", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> manejarErrorAritmetico(ArithmeticException ex) {
        return new ResponseEntity<>("Error 400: operación matemática no válida", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> manejarEstadoIlegal(IllegalStateException ex) {
        return new ResponseEntity<>("Error: operación no permitida en el estado actual", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<String> manejarOperacionNoSoportada(UnsupportedOperationException ex) {
        return new ResponseEntity<>("Error 501 : operación no encontrada o soportada", HttpStatus.NOT_IMPLEMENTED);
    }

}
