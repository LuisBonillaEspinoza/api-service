package com.bicimoto.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tblstarticulo database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblstarticulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblstarticuloPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecModi;

	private double stock;

	private String userCreacion;

	private String userModi;

}