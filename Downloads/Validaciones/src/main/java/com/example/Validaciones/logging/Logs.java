package com.example.Validaciones.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Logs{

    private static final Logger logger = LogManager.getLogger(Logs.class);

    public static void main(String[] args) {
        SpringApplication.run(Logs.class, args);
        logger.info("Aplicación iniciada correctamente.");
        logger.debug("Este es un mensaje de debug.");
        logger.warn("Este es un mensaje de advertencia.");
        logger.error("Este es un mensaje de error.");
        logger.debug("Este es un mensaje de debug para depuración detallada.");
        logger.fatal("Se ha producido un error fatal, la aplicación se detendrá");
    }
}
