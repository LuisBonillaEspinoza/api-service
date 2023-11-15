package com.bicimoto.app.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComBajaRequest {
    private String Ruc;
    private String Serie;
    private String Numero;
    private String Almacen;
    private String Doc;
    private String Id;
    private String NDoc;
}
