package com.bicimoto.app.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tblstarticulo database table.
 * 
 */
@Embeddable
public class TblstarticuloPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String ruc;

	private String codAlm;

	private String codArti;

	public TblstarticuloPK() {
	}
	public String getRuc() {
		return this.ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getCodAlm() {
		return this.codAlm;
	}
	public void setCodAlm(String codAlm) {
		this.codAlm = codAlm;
	}
	public String getCodArti() {
		return this.codArti;
	}
	public void setCodArti(String codArti) {
		this.codArti = codArti;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblstarticuloPK)) {
			return false;
		}
		TblstarticuloPK castOther = (TblstarticuloPK)other;
		return 
			this.ruc.equals(castOther.ruc)
			&& this.codAlm.equals(castOther.codAlm)
			&& this.codArti.equals(castOther.codArti);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ruc.hashCode();
		hash = hash * prime + this.codAlm.hashCode();
		hash = hash * prime + this.codArti.hashCode();
		
		return hash;
	}
}