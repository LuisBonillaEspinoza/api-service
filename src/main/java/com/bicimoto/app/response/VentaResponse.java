package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponse{
    private String nombreMoneda;
    private String idventa;
    private String fecha;
    private String nombredoc;
    private String codDoc;
    private String nomArchXml;
    private String archXml;
    private String usuario;
    private String tipoDocCliente;
    private String tipoCompra;
    private String dcto;
    private String tBruto;
    private String tExonerada;
    private String tInafectada;
    private String tGratuita;
    private String tIgv;
    private String eGratuita;
    private String total;
    private String tventa;
    private String serie;
    private String prefijoSerie;
    private String numero;
    private String codtcomp;
}
