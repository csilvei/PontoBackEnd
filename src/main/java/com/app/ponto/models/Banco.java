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
public class Banco implements Serializable{

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
	private BigDecimal totalpos;
	
	@NotNull
	private BigDecimal totalneg;

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

	public BigDecimal getTotalpos() {
		return totalpos;
	}

	public void setTotalpos(BigDecimal totalpos) {
		this.totalpos = totalpos;
	}

	public BigDecimal getTotalneg() {
		return totalneg;
	}

	public void setTotalneg(BigDecimal totalneg) {
		this.totalneg = totalneg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}