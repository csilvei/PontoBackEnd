package com.app.ponto.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Lancamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	@NotNull
	private long   id;
	
	@NotNull
	private String iduser;
	
	@NotNull
	private String idempresa;
	
	@NotNull
	private Date data;
	
	@NotNull
	private Date entradaA;
	
	@NotNull
	private Date saidaA;
	
	@NotNull
	private Date entradaB;
	
	@NotNull
	private Date saidaB;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getEntradaA() {
		return entradaA;
	}

	public void setEntradaA(Date entradaA) {
		this.entradaA = entradaA;
	}

	public Date getSaidaA() {
		return saidaA;
	}

	public void setSaidaA(Date saidaA) {
		this.saidaA = saidaA;
	}

	public Date getEntradaB() {
		return entradaB;
	}

	public void setEntradaB(Date entradaB) {
		this.entradaB = entradaB;
	}

	public Date getSaidaB() {
		return saidaB;
	}

	public void setSaidaB(Date saidaB) {
		this.saidaB = saidaB;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}