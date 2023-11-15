package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaResponse {
    private String razon;
    private String nombreLegal;
    private String ubigeo;
    private String direccion;
    private String urbanizacion;
    private String telefono;
    private String celular;
    private String representante;
    private String email;
    private String telefono2;
    private String nombreRegion;
    private String nombreProvincia;
    private String nombreDistrito;
}
