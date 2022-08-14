package br.com.bridge.domain.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.ToString;

@MappedSuperclass
@ToString
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long idPessoa;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "nome")
	private String nome;
	
	@NotBlank
	@Size(max = 100)
	@Email
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "endereco")
	private String endereco;

	public Pessoa() {
	}

	public Pessoa(Long idPessoa, String nome, String email, String endereco) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
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

	@Override
	public int hashCode() {
		return Objects.hash(email, endereco, idPessoa, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(idPessoa, other.idPessoa) && Objects.equals(nome, other.nome);
	}	

}