package com.bicimoto.app.service;

import com.bicimoto.app.response.ArticuloStockResponse;

public interface ArticuloService {

    ArticuloStockResponse findConsultaSotck(String codArti, String codAlmacen, String codEmpresa) throws Exception;

}
