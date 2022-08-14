package br.com.bridge.domain.entity.enums;

public enum StatusTurma {
	
	INSCRICOES_ABERTAS(1),
	INSCRICOES_ENCERRADAS(2),
	EM_ANDAMENTO(3),
	FINALIZADO(4);
	
	private int codigo;
	
	private StatusTurma(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusTurma valueOf(int codigo) {
		for (StatusTurma value : StatusTurma.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de status da turma inválido.");
	}

}
