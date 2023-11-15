package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosResponse {
    private EmpresaResponse empresa;
    private ClienteResponse cliente;
    private VentaResponse venta;
    private List<DetalleVentaResponse> detalleVenta;
}
