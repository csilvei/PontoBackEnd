package com.app.ponto.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Banco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	@NotNull
	private long   id;
	
	@NotNull
	private long iduser;
	
	@NotNull
	private long idempresa;
		
	@NotNull
	private double TotalPositivas;
	
	@NotNull
	private double TotalNegativas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public long getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(long idempresa) {
		this.idempresa = idempresa;
	}


	public double getTotalPositivas() {
		return TotalPositivas;
	}

	public void setTotalPositivas(double totalPositivas) {
		TotalPositivas = totalPositivas;
	}

	public double getTotalNegativas() {
		return TotalNegativas;
	}

	public void setTotalNegativas(double totalNegativas) {
		TotalNegativas = totalNegativas;
	}

	
	
}