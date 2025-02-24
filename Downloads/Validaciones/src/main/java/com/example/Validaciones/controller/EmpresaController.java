package com.example.Validaciones.controller;

import com.example.Validaciones.bean.Empresa;
import com.example.Validaciones.DTO.EmpresaDto;
import com.example.Validaciones.services.EmpresaService;
import com.example.Validaciones.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarEmpresa(@RequestBody EmpresaDto empresaDto) {
        try {
            Empresa nuevaEmpresa = empresaService.registrarEmpresa(empresaDto);
            return ResponseEntity.ok(nuevaEmpresa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar la empresa: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Empresa>> obtenerEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(empresas);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> obtenerEmpresaPorUuid(@PathVariable String uuid) {
        Optional<Empresa> empresaOpt = empresaRepository.findByUuid(uuid);

        if (empresaOpt.isPresent()) {
            Empresa empresa = empresaOpt.get();
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada con UUID: " + uuid);
        }
    }

    @GetMapping("/activo")
    public ResponseEntity<String> getActiveProfile() {
        return ResponseEntity.ok("Perfil activo: " + activeProfile);
    }
}
