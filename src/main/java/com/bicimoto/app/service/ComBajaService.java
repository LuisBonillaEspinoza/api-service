package com.bicimoto.app.service;

import com.bicimoto.app.response.DatosComBajaResponse;

public interface ComBajaService {
    DatosComBajaResponse getDatosComBaja(String ruc, String serie, String numero, String doc, String almacen,String id,String ndoc);
}
