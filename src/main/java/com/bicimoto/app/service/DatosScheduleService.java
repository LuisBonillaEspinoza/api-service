package com.bicimoto.app.service;

import com.bicimoto.app.response.DatosResponse;

public interface DatosScheduleService {
    DatosResponse getDatosScheduler(String TipoDocumento, String Numero, String Serie, String Ruc, String Almacen);
}
