package br.com.bridge.domain.vo.v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.bridge.domain.entity.enums.TipoPCD;

public class PessoaFisicaVO extends RepresentationModel<PessoaFisicaVO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Mapping("idPessoa")
	private Long key;
	private String nome;
	private String email;
	private String endereco;
	private String sobrenome;
	private String nomeSocial;
	private String cpf;
	private LocalDate dataNascimento;
	private TipoPCD tipoPcd;
	private String cvLinkedin;
//	private Set<Turma> turmas = new HashSet<>();
	
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
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getNomeSocial() {
		return nomeSocial;
	}
	
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public TipoPCD getTipoPcd() {
		return tipoPcd;
	}
	
	public void setTipoPcd(TipoPCD tipoPcd) {
		this.tipoPcd = tipoPcd;
	}
	
	public String getCvLinkedin() {
		return cvLinkedin;
	}
	
	public void setCvLinkedin(String cvLinkedin) {
		this.cvLinkedin = cvLinkedin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, cvLinkedin, dataNascimento, email, endereco, key, nome, nomeSocial,
				sobrenome, tipoPcd);
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
		PessoaFisicaVO other = (PessoaFisicaVO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(cvLinkedin, other.cvLinkedin)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(key, other.key)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomeSocial, other.nomeSocial)
				&& Objects.equals(sobrenome, other.sobrenome) && tipoPcd == other.tipoPcd;
	}
	
//	public Set<Turma> getTurmas() {
//		return turmas;
//	}
	
	

}
