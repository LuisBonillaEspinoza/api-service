package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosComBajaResponse {
    EmpresaResponse empresa;
    ComBajaResponse comuBaja;
    List<DetalleComBajaResponse> detallecomubaja;
}
