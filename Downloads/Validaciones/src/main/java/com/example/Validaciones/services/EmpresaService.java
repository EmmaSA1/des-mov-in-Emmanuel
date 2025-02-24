package com.example.Validaciones.services;

import com.example.Validaciones.DTO.EmpresaDto;
import com.example.Validaciones.bean.Empresa;
import com.example.Validaciones.repository.EmpresaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class EmpresaService {

    private static final Logger logger = LogManager.getLogger(EmpresaService.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    private final Environment environment;

    @Value("${spring.profiles.active:default}") // Obtiene el perfil activo, si no hay, usa "default"
    private String perfilActivo;

    @Autowired
    public EmpresaService(Environment environment) {
        this.environment = environment;
    }
    public Empresa registrarEmpresa(EmpresaDto empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setRazonSocial(empresaDTO.getRazonSocial());
        empresa.setRfc(empresaDTO.getRfc());
        empresa.setTelefono(empresaDTO.getTelefono());
        empresa.setNombreContacto(empresaDTO.getNombreContacto());
        empresa.setCorreo(empresaDTO.getCorreo());

        // Generar UUID y asignarlo
        String uuid = UUID.randomUUID().toString();
        empresa.setUuid(uuid);

        // Obtener el perfil activo
        String perfil = perfilActivo != null ? perfilActivo : "default";

        // Loguear la información
        logger.info("Perfil activo: {}", perfil);
        logger.info("Registrando empresa: {} con UUID: {}", empresa.getRazonSocial(), uuid);

        try {
            Empresa empresaGuardada = empresaRepository.save(empresa);
            logger.debug("Empresa '{}' registrada correctamente con UUID: {}", empresa.getRazonSocial(), uuid);
            return empresaGuardada;
        } catch (Exception e) {
            logger.error("Error al registrar empresa: {}", empresa.getRazonSocial(), e);
            return null;
        }
    }
}