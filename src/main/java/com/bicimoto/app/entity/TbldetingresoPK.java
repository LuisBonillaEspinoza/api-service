package com.bicimoto.app.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tbldetingreso database table.
 * 
 */
@Embeddable
public class TbldetingresoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String id;

	private String codigo;

	private double cantidad;

	private String almacen;

	private String empresa;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecCreacion;

	public TbldetingresoPK() {
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigo() {
		return this.codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getAlmacen() {
		return this.almacen;
	}
	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}
	public String getEmpresa() {
		return this.empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public java.util.Date getFecCreacion() {
		return this.fecCreacion;
	}
	public void setFecCreacion(java.util.Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbldetingresoPK)) {
			return false;
		}
		TbldetingresoPK castOther = (TbldetingresoPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.codigo.equals(castOther.codigo)
			&& (this.cantidad == castOther.cantidad)
			&& this.almacen.equals(castOther.almacen)
			&& this.empresa.equals(castOther.empresa)
			&& this.fecCreacion.equals(castOther.fecCreacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.codigo.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.cantidad) ^ (java.lang.Double.doubleToLongBits(this.cantidad) >>> 32)));
		hash = hash * prime + this.almacen.hashCode();
		hash = hash * prime + this.empresa.hashCode();
		hash = hash * prime + this.fecCreacion.hashCode();
		
		return hash;
	}
}