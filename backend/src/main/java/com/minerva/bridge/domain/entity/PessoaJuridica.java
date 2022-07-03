package com.minerva.bridge.domain.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pessoa_juridica")
public class PessoaJuridica extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "sobre_instituicao")
	private String sobreInstituicao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "empresas")
	private Set<Turma> turmasOfertadas = new HashSet<>();
	
	public PessoaJuridica() {
	}

	public PessoaJuridica(Long idPessoa, String nome, String email, String endereco, String cnpj, String sobreInstituicao) {
		super(idPessoa, nome, email, endereco);
		this.cnpj = cnpj;
		this.sobreInstituicao = sobreInstituicao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSobreInstituicao() {
		return sobreInstituicao;
	}

	public void setSobreInstituicao(String sobreInstituicao) {
		this.sobreInstituicao = sobreInstituicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

}
