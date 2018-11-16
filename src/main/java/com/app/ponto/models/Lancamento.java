package com.app.ponto.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
	private BigDecimal horaspos;
	
	@NotNull
	private BigDecimal horasneg;

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

	public BigDecimal getHoraspos() {
		return horaspos;
	}

	public void setHoraspos(BigDecimal horaspos) {
		this.horaspos = horaspos;
	}

	public BigDecimal getHorasneg() {
		return horasneg;
	}

	public void setHorasneg(BigDecimal horasneg) {
		this.horasneg = horasneg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}