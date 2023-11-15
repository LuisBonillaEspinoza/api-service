package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleResumenResponse {
    private String numId;
    private String serie;
    private String inicio;
    private String cliente;
    private String total;
    private String tBruto;
    private String tInafecta;
    private String tGratuita;
    private String dcto;
    private String prefijoSerie;
    private String codDetCat;
    private String moneda;
    private String estadoItem;
}
