package br.com.bridge.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bridge.domain.entity.enums.AreaInteresse;
import lombok.ToString;

@Entity
@Table(name = "tb_cursos")
@ToString
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long idCurso;

	@NotBlank
	@Size(max = 100)
	@Column(name = "nome_curso")
	private String nomeCurso;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "duracao")
	private String duracao;
	
	@NotNull
	@Column(name = "area_interesse")
	private Integer areaInteresse;
	
	@NotBlank
	@Size(max = 255)
	@Column(name = "sobre_curso")
	private String sobreCurso;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "escolaridade_minima")
	private String escolaridadeMinima;
	
	@NotBlank
	@Size(max = 150)
	@Column(name = "link_cadastro")
	private String linkCadastro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public Curso() {
	}

	public Curso(Long idCurso, String nomeCurso, String duracao, AreaInteresse areaInteresse, String sobreCurso,
			String escolaridadeMinima, String linkCadastro) {
		super();
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
		this.duracao = duracao;
		setAreaInteresse(areaInteresse);
		this.sobreCurso = sobreCurso;
		this.escolaridadeMinima = escolaridadeMinima;
		this.linkCadastro = linkCadastro;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public AreaInteresse getAreaInteresse() {
		return AreaInteresse.valueOf(areaInteresse);
	}

	public void setAreaInteresse(AreaInteresse areaInteresse) {
		if (areaInteresse != null) {
			this.areaInteresse = areaInteresse.getArea();
		}
	}

	public String getSobreCurso() {
		return sobreCurso;
	}

	public void setSobreCurso(String sobreCurso) {
		this.sobreCurso = sobreCurso;
	}

	public String getEscolaridadeMinima() {
		return escolaridadeMinima;
	}

	public void setEscolaridadeMinima(String escolaridadeMinima) {
		this.escolaridadeMinima = escolaridadeMinima;
	}

	public String getLinkCadastro() {
		return linkCadastro;
	}

	public void setLinkCadastro(String linkCadastro) {
		this.linkCadastro = linkCadastro;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(areaInteresse, duracao, escolaridadeMinima, idCurso, linkCadastro, nomeCurso, sobreCurso,
				turmas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(areaInteresse, other.areaInteresse) && Objects.equals(duracao, other.duracao)
				&& Objects.equals(escolaridadeMinima, other.escolaridadeMinima)
				&& Objects.equals(idCurso, other.idCurso) && Objects.equals(linkCadastro, other.linkCadastro)
				&& Objects.equals(nomeCurso, other.nomeCurso) && Objects.equals(sobreCurso, other.sobreCurso)
				&& Objects.equals(turmas, other.turmas);
	}
		
}
