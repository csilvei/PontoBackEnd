package com.app.ponto.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	@NotNull
	private long   id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String cnpj;
	@NotNull
	private int regime;
	
	@NotNull
	private BigDecimal valorh;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getRegime() {
		return regime;
	}

	public void setRegime(int regime) {
		this.regime = regime;
	}

	public BigDecimal getValorh() {
		return valorh;
	}

	public void setValorh(BigDecimal valorh) {
		this.valorh = valorh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}