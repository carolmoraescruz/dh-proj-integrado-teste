package br.com.bridge.domain.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.ToString;

@Entity
@Table(name = "tb_empresas")
@ToString
public class PessoaJuridica extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Size(max = 18)
	@Column(name = "cnpj")
	private String cnpj;
	
	@NotBlank
	@Size(max = 255)
	@Column(name = "sobre_instituicao")
	private String sobreInstituicao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "empresas")
	private Set<Turma> turmasOfertadas = new HashSet<>();

	public PessoaJuridica() {
	}

	public PessoaJuridica(Long idPessoa, String nome, String email, String endereco, String cnpj, String sobreInstituicao, Set<Turma> turmasOfertadas) {
		super(idPessoa, nome, email, endereco);
		this.cnpj = cnpj;
		this.sobreInstituicao = sobreInstituicao;
		this.turmasOfertadas = turmasOfertadas;
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

	public Set<Turma> getTurmasOfertadas() {
		return turmasOfertadas;
	}

//	public void setTurmasOfertadas(Set<Turma> turmasOfertadas) {
//		this.turmasOfertadas = turmasOfertadas;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj, sobreInstituicao, turmasOfertadas);
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
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(sobreInstituicao, other.sobreInstituicao)
				&& Objects.equals(turmasOfertadas, other.turmasOfertadas);
	}
		
}
