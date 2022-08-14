package br.com.bridge.domain.vo.v1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.bridge.domain.entity.Turma;

public class PessoaJuridicaVO extends RepresentationModel<PessoaJuridicaVO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Mapping("idPessoa")
	private Long key;
	private String nome;
	private String email;
	private String endereco;
	private String cnpj;
	private String sobreInstituicao;
	private Set<Turma> turmasOfertadas = new HashSet<>();
	
	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj, email, endereco, key, nome, sobreInstituicao, turmasOfertadas);
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
		PessoaJuridicaVO other = (PessoaJuridicaVO) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(key, other.key)
				&& Objects.equals(nome, other.nome) && Objects.equals(sobreInstituicao, other.sobreInstituicao)
				&& Objects.equals(turmasOfertadas, other.turmasOfertadas);
	}

}
