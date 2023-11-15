package com.bicimoto.app.service;

import com.bicimoto.app.response.DatosResumenResponse;

public interface ResumenService {
    DatosResumenResponse getDatosResumen(String ruc, String serie, String numero, String doc, String almacen,String id,String ndoc);
}
