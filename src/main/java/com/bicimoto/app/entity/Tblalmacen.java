package com.bicimoto.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tblalmacen database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblalmacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblalmacenPK id;

	private String est;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecModi;

	private String nombre;

	private String predeterminar;

	private String userCreacion;

	private String userModi;

}