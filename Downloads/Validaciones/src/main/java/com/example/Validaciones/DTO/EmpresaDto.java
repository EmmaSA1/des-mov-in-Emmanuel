package com.example.Validaciones.DTO;

import com.example.Validaciones.bean.Empresa;
import lombok.Data;

import java.util.UUID;

@Data
public class EmpresaDto {
    private String razonSocial;
    private String rfc;
    private String telefono;
    private String nombreContacto;
    private String correo;
    private UUID uuid;
    private UUID uuid_temporal;

    public EmpresaDto(String razonSocial, String rfc, String telefono, String nombreContacto, String correo, UUID uuid, UUID uuid_temporal) {
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        this.correo = correo;
        this.uuid_temporal = UUID.randomUUID();
    }

    public UUID getUuid_temporal() {
        return uuid_temporal;
    }

    public void setUuid_temporal(UUID uuid_temporal) {
        this.uuid_temporal = uuid_temporal;

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public EmpresaDto toEntity(Empresa empresa){
        EmpresaDto empresaDto= new EmpresaDto();
        empresaDto.setRazonSocial(empresa.getRazonSocial());
        empresaDto.setRfc(empresa.getRfc());
        empresaDto.setTelefono(empresa.getTelefono());
        empresaDto.setNombreContacto(empresa.getNombreContacto());
        empresaDto.setCorreo(empresa.getCorreo());
        empresaDto.setUuid_temporal(UUID.randomUUID());
        return empresaDto;
    }

    public EmpresaDto() {
        // Constructor vacío
    }


}
