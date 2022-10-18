package com.bicimoto.app.service;

import com.bicimoto.app.request.ArticuloRequest;
import com.bicimoto.app.response.ProductoResponse;
import com.bicimoto.app.response.ProductoResponseGen;
import com.bicimoto.app.response.ArticuloStockResponse;

import java.text.ParseException;
import java.util.List;

public interface ArticuloService {

	ArticuloStockResponse findConsultaSotck(String codArti, String codAlmacen, String codEmpresa) throws Exception;

	List<ProductoResponseGen> findProductos() throws Exception;

	List<ProductoResponse> findProductosByID(String codigo) throws Exception;

    List<ArticuloRequest> saveDataUpload(List<ArticuloRequest> listaArticulos) throws ParseException;
}
