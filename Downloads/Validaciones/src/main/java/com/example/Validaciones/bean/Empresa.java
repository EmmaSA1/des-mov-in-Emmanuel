package com.example.Validaciones.bean;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String uuid;

    @Column(nullable = false)
    private String razonSocial;

    @Column(nullable = false, unique = true)
    private String rfc;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String nombreContacto;

    @Column(nullable = false, unique = true)
    private String correo;

    // Constructor vacío requerido por JPA
    public Empresa() {
        // Aquí no inicializamos los valores porque JPA se encarga de eso
    }


    // Getters y setters adecuados

    @PrePersist
    public void generarUUID() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
