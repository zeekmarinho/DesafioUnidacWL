package com.desafio.cafe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_opcaocafe")
public class OpcaoCafe implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String opcafe;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "colaborador_cpf")
	private Colaborador colaborador;
	
	public OpcaoCafe() {
		
	}

	public OpcaoCafe(String opcafe, Colaborador colaborador) {
		super();
		this.opcafe = opcafe;
		this.colaborador = colaborador;
	}

	public String getOpcafe() {
		return opcafe;
	}

	public void setOpcafe(String opcafe) {
		this.opcafe = opcafe;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opcafe == null) ? 0 : opcafe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpcaoCafe other = (OpcaoCafe) obj;
		if (opcafe == null) {
			if (other.opcafe != null)
				return false;
		} else if (!opcafe.equals(other.opcafe))
			return false;
		return true;
	}		

}
