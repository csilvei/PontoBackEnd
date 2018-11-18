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
	private String empregado;
	
	@NotNull
	private String empresa;
		
	@NotNull
	private BigDecimal pos;
	
	@NotNull
	private BigDecimal neg;
    @NotNull
    private BigDecimal total;
    
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getuser() {
		return empregado;
	}

	public void setuser(String iduser) {
		this.empregado = iduser;
	}

	public String getempresa() {
		return empresa;
	}

	public void setempresa(String idempresa) {
		this.empresa = idempresa;
	}

	public BigDecimal getPos() {
		return pos;
	}

	public void setPos(BigDecimal pos) {
		this.pos = pos;
	}

	public BigDecimal getNeg() {
		return neg;
	}

	public void setNeg(BigDecimal neg) {
		this.neg = neg;
	}


	
}