package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaResponse {
    private String id;
    private String codArt;
    private String descripcion;
    private String pUnitario;
    private String pReferencial;
    private String tipPrecio;
    private String dcto;
    private String cantidad;
    private String igv;
    private String tipoImpuesto;
    private String importe;
    private String unidadMedida;
    private String totalVenta;
}
