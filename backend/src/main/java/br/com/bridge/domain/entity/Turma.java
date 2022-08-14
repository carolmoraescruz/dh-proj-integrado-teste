package br.com.bridge.domain.entity;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.bridge.domain.entity.enums.StatusTurma;
import br.com.bridge.domain.entity.enums.TipoTurma;
import lombok.ToString;

@Entity
@Table(name = "tb_turmas")
@ToString
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long idTurma;

	@NotBlank
	@Size(max = 50)
	@Column(name = "horario")
	private String horario;

	@NotNull
	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@NotNull
	@Column(name = "data_termino")
	private LocalDate dataTermino;
	
	@NotNull
	@Column(name = "status_turma")
	private int statusTurma;
	
	@NotNull
	@Column(name = "tipo_turma")
	private int tipoTurma;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

//	@ManyToMany
//	@JoinTable(name = "tb_turma_aluno", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
//	private Set<PessoaFisica> alunos = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "tb_turma_empresa", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	private Set<PessoaJuridica> empresas = new HashSet<>();
	
	public Turma() {
	}

	public Turma(Long idTurma, String horario, LocalDate dataInicio, LocalDate dataTermino, 
			StatusTurma statusTurma, TipoTurma tipoTurma, Curso curso) {
		super();
		this.idTurma = idTurma;
		this.horario = horario;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		setStatusTurma(statusTurma);
		setTipoTurma(tipoTurma);
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
	
	public StatusTurma getStatusTurma() {
		return StatusTurma.valueOf(statusTurma);
	}

	public void setStatusTurma(StatusTurma statusTurma) {
		if (statusTurma != null) {
			this.statusTurma = statusTurma.getCodigo();
		}
	}
	
	public TipoTurma getTipoTurma() {
		return TipoTurma.valueOf(tipoTurma);
	}

	public void setTipoTurma(TipoTurma tipoTurma) {
		if (tipoTurma != null) {
			this.tipoTurma = tipoTurma.getCodigo();
		}
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

//	public Set<PessoaFisica> getAlunos() {
//		return alunos;
//	}
//	
	public Set<PessoaJuridica> getEmpresas() {
		return empresas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, dataInicio, dataTermino, empresas, horario, idTurma, statusTurma, tipoTurma);
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
		return Objects.equals(curso, other.curso) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(dataTermino, other.dataTermino) && Objects.equals(empresas, other.empresas)
				&& Objects.equals(horario, other.horario) && Objects.equals(idTurma, other.idTurma)
				&& statusTurma == other.statusTurma && tipoTurma == other.tipoTurma;
	}
		
}
