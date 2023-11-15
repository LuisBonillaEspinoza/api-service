package com.bicimoto.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleComBajaResponse {
    String numId;
    String tipDoc;
    String serie;
    String numDoc;
    String motivoBaja;
    String prefijoSerie;
}
