package com.bicimoto.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tblarticulos database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tblarticulos")
public class Tblarticulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblarticuloPK id;

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

	@Temporal(TemporalType.TIMESTAMP)
	private Date FCompra;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecModi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date FVenta;

	private String genStock;

	@Lob
	private byte[] image;

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

	private String userModi;

	private String ventaMin;

}