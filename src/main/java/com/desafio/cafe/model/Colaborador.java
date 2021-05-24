package com.desafio.cafe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_colaborador")
public class Colaborador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cpf;
	private String nome;	
		
	@OneToMany(mappedBy = "colaborador")
	private List<OpcaoCafe> opcoesdecafe = new ArrayList<>();
	
	public Colaborador() {
		
	}

	public Colaborador(String cpf, String nome, List<OpcaoCafe> opcoesdecafe) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.opcoesdecafe = opcoesdecafe;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<OpcaoCafe> getOpcoesdecafe() {
		return opcoesdecafe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Colaborador other = (Colaborador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	

}
