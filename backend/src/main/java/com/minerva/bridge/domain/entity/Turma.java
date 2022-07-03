package com.minerva.bridge.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_turmas")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long idTurma;

	@Column(name = "horario")
	private String horario;

	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@Column(name = "data_termino")
	private LocalDate dataTermino;

	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

	@ManyToMany
	@JoinTable(name = "tb_turma_aluno", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	private Set<PessoaFisica> alunos = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_turma_empresa", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	private Set<PessoaJuridica> empresas = new HashSet<>();

	public Turma() {
	}

	public Turma(Long idTurma, String horario, LocalDate dataInicio, LocalDate dataTermino, Curso curso) {
		super();
		this.idTurma = idTurma;
		this.horario = horario;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.curso = curso;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Set<PessoaFisica> getAlunos() {
		return alunos;
	}
	
	public Set<PessoaJuridica> getEmpresas() {
		return empresas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTurma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(idTurma, other.idTurma);
	}

}
