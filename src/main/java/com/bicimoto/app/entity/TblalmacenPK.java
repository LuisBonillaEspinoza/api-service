package com.bicimoto.app.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tblalmacen database table.
 * 
 */
@Embeddable
public class TblalmacenPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String codAlmacen;

	private String rucEmpresa;

	public TblalmacenPK() {
	}
	public String getCodAlmacen() {
		return this.codAlmacen;
	}
	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}
	public String getRucEmpresa() {
		return this.rucEmpresa;
	}
	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblalmacenPK)) {
			return false;
		}
		TblalmacenPK castOther = (TblalmacenPK)other;
		return 
			this.codAlmacen.equals(castOther.codAlmacen)
			&& this.rucEmpresa.equals(castOther.rucEmpresa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codAlmacen.hashCode();
		hash = hash * prime + this.rucEmpresa.hashCode();
		
		return hash;
	}
}