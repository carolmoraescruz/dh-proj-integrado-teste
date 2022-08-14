package br.com.bridge.domain.vo.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.bridge.domain.entity.Turma;
import br.com.bridge.domain.entity.enums.AreaInteresse;

public class CursoVO extends RepresentationModel<CursoVO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Mapping("idCurso")
	private Long key;
	private String nomeCurso;
	private String duracao;
	private AreaInteresse areaInteresse;
	private String sobreCurso;
	private String escolaridadeMinima;
	private String linkCadastro;
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public Long getKey() {
		return key;
	}
	
	public void setKey(Long key) {
		this.key = key;
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
		return areaInteresse;
	}
	
	public void setAreaInteresse(AreaInteresse areaInteresse) {
		this.areaInteresse = areaInteresse;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(areaInteresse, duracao, escolaridadeMinima, key, linkCadastro, nomeCurso, sobreCurso);
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
		CursoVO other = (CursoVO) obj;
		return areaInteresse == other.areaInteresse && Objects.equals(duracao, other.duracao)
				&& Objects.equals(escolaridadeMinima, other.escolaridadeMinima) && Objects.equals(key, other.key)
				&& Objects.equals(linkCadastro, other.linkCadastro) && Objects.equals(nomeCurso, other.nomeCurso)
				&& Objects.equals(sobreCurso, other.sobreCurso);
	}

}
