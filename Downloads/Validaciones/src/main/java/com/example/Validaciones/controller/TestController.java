package com.example.Validaciones.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class TestController {


    @GetMapping("/recurso")
    public String obtenerRecurso(@RequestParam(required = false) String id)  {
        if (id == null) {
        }
        return "Recurso encontrado con ID: " + id;
    }

    @GetMapping("/validar")
    public String validar(@RequestParam String valor)  {
        if (valor.length() < 3) {
           return  ("El valor debe tener más caracteres.");
        }
        return "Valor válido: " + valor;
    }

    @GetMapping("/error")
    public String errorInterno() {
        throw new RuntimeException("Simulación de error interno.");
    }

    @GetMapping("/division-cero")
    public String divisionPorCero() {
        int resultado = 10 / 0;
        return "Resultado: " + resultado;
    }

    @GetMapping("/estado-ilegal")
    public String estadoIlegal() {
        throw new IllegalStateException();
    }

    @GetMapping("/operacion-no-soportada")
    public String operacionNoSoportada() {
        throw new UnsupportedOperationException();
    }
}
