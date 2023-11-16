package com.bicimoto.app.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngresoRequest {
    private String id;
    private String fecha;
    private String tipDoc;
    private String concepto;
    private String serie;
    private String numero;
    private String referencia;
    private String responsable;
    private String almacen;
    private String empresa;
    private String userCreacion;
    private String est;

    private List<DetalleIngresoRequest> listaDetalle;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetalleIngresoRequest{
        private String id;
        private String codigo;
        private Double cantidad;
        private String almacen;
        private String empresa;
        private String marca;
        private String proced;
        private String unidad;
        private String userCreacion;
    }
}
