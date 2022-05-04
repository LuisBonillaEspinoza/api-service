package com.bicimoto.app.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tblarticulos database table.
 *
 */
@Embeddable
public class TblarticuloPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CodArt")
	private String codArt;

	@Column(name="RucEmpresa")
	private String rucEmpresa;

	@Column(name="Almacen")
	private String almacen;

	public TblarticuloPK() {
	}

	public String getCodArt() {
		return codArt;
	}

	public void setCod_art(String codArt) {
		this.codArt = codArt;
	}

	public String getRucEmpresa() {
		return rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public String getAlmacen() {
		return this.almacen;
	}
	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblarticuloPK)) {
			return false;
		}
		TblarticuloPK castOther = (TblarticuloPK)other;
		return
				this.codArt.equals(castOther.codArt)
						&& this.rucEmpresa.equals(castOther.rucEmpresa)
						&& this.almacen.equals(castOther.almacen);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codArt.hashCode();
		hash = hash * prime + this.rucEmpresa.hashCode();
		hash = hash * prime + this.almacen.hashCode();

		return hash;
	}
}