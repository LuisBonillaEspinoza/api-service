package com.bicimoto.app.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosScheduleRequest {
    private String TipoDocumento;
    private String Numero;
    private String Serie;
    private String Ruc;
    private String Almacen;
}
