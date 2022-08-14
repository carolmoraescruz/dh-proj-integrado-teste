package br.com.bridge.domain.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.bridge.domain.entity.enums.TipoPCD;
import lombok.ToString;

@Entity
@Table(name = "tb_alunos")
@ToString
public class PessoaFisica extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Size(max = 35)
	@Column(name = "nomesocial")
	private String nomeSocial;
	
	@NotBlank
	@Size(max = 14)
	@Column(name = "cpf")
	private String cpf;
	
	@NotNull
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@NotNull
	@Column(name = "tipo_pcd")
	private int tipoPcd;
	
	@Size(max = 100)
	@Column(name = "cv_linkedin")
	private String cvLinkedin;
	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "alunos")
//	private Set<Turma> turmas = new HashSet<>();
	
	public PessoaFisica() {
	}

	public PessoaFisica(Long idPessoa, String nome, String email, String endereco, String sobrenome, String nomeSocial, String cpf, LocalDate dataNascimento, TipoPCD tipoPcd, String cvLinkedin) {
		super(idPessoa, nome, email, endereco);
		this.sobrenome = sobrenome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		setTipoPcd(tipoPcd);
		this.cvLinkedin = cvLinkedin;
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
		return TipoPCD.valueOf(tipoPcd);
	}

	public void setTipoPcd(TipoPCD tipoPcd) {
		if (tipoPcd != null) {
			this.tipoPcd = tipoPcd.getCodigo();
		}
	}

	public String getCvLinkedin() {
		return cvLinkedin;
	}

	public void setCvLinkedin(String cvLinkedin) {
		this.cvLinkedin = cvLinkedin;
	}
	
//	public Set<Turma> getTurmas() {
//		return turmas;
//	}

	public int calcularIdade(Date dataNascimento) {
		LocalDate dataNascimentoConvertida = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate dataAtual = LocalDate.now();
		int idade = (Period.between(dataAtual, dataNascimentoConvertida)).getYears();
		return idade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, cvLinkedin, dataNascimento, nomeSocial, sobrenome, tipoPcd);
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
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(cvLinkedin, other.cvLinkedin)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(nomeSocial, other.nomeSocial)
				&& Objects.equals(sobrenome, other.sobrenome) && tipoPcd == other.tipoPcd;
	}	
	
}
