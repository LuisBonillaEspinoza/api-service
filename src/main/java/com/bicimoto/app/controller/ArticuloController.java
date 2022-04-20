package com.bicimoto.app.controller;

import com.bicimoto.app.response.ArticuloStockResponse;
import com.bicimoto.app.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/consulta/stock")
    public ResponseEntity<?> consultaStock(@RequestParam Map<String, String> params) {

        ArticuloStockResponse response = null;

        try {

            response = articuloService.findConsultaSotck(
                    (params.get("codigo") != null ? params.get("codigo") : null),
                    (params.get("almacen") != null ? params.get("almacen") : null),
                    (params.get("empresa") != null ? params.get("empresa") : null)
            );

        } catch (Exception e) {
            return buildResponseError("Error en consulta, no pueden obetener los datos", e);
        }

        if (response == null) {
            return buildResponseError("No se encontraron datos en la base de datos", null);
        }

        return new ResponseEntity<ArticuloStockResponse>(response, HttpStatus.OK);
    }

    private ResponseEntity<Map<String, Object>> buildResponseError(String error, Exception exception) {
        Map<String, Object> response = new HashMap<>();

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        if (exception != null) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            if (exception.getMessage() != null) {
                error = exception.getMessage();
            }
        }
        response.put("Mensaje", error);
        return new ResponseEntity<Map<String, Object>>(response, httpStatus);
    }
}
