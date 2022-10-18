package com.bicimoto.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbldetingreso database table.
 * 
 */
@Entity
@NamedQuery(name="Tbldetingreso.findAll", query="SELECT t FROM Tbldetingreso t")
public class Tbldetingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbldetingresoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecModi;

	private String marca;

	private String proced;

	private String unidad;

	private String userCreacion;

	private String userModi;


	public Tbldetingreso() {
	}

	public TbldetingresoPK getId() {
		return this.id;
	}

	public void setId(TbldetingresoPK id) {
		this.id = id;
	}

	public Date getFecModi() {
		return this.fecModi;
	}

	public void setFecModi(Date fecModi) {
		this.fecModi = fecModi;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProced() {
		return this.proced;
	}

	public void setProced(String proced) {
		this.proced = proced;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getUserCreacion() {
		return this.userCreacion;
	}

	public void setUserCreacion(String userCreacion) {
		this.userCreacion = userCreacion;
	}

	public String getUserModi() {
		return this.userModi;
	}

	public void setUserModi(String userModi) {
		this.userModi = userModi;
	}



}