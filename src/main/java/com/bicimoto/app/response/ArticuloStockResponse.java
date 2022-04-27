package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloStockResponse {

    private String codArti;

    private String nombre;

    private String codAlm;

    private String nomAlm;

    private String rucEmpresa;

    private double stock;

}
