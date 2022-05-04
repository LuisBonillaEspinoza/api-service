package com.bicimoto.app.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloRequest {

    private String codArt;

    private String rucEmpresa;

    private String almacen;

    private double cantPrecioVolum;

    private String codFamilia;

    private String codInternac;

    private String codLinea;

    private String codMarca;

    private String codModelo;

    private String codProced;

    private String codUnidad;

    @Lob
    private String descricpcion;

    private String est;

    private Date fecCreacion;

    private String genStock;

    private String isVehiculo;

    private String nombre;

    private String PAraNac;

    private String parNab;

    private double pcif;

    private double PCosto;

    private double pfob;

    private double PMayorista;

    private String promedioVenta;

    private String proveedor;

    private double PVenta;

    private double PVolumen;

    private double stockMin;

    private String stockReal;

    private String tipMoneda;

    private String tipProducto;

    private String TSerie;

    private String ubicacion;

    private String userCreacion;

    private String ventaMin;

}
