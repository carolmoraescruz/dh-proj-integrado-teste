package br.com.bridge.domain.entity.enums;

public enum TipoTurma {
	
	PRESENCIAL(1),
	REMOTO(2);
	
	private int codigo;
	
	private TipoTurma(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static TipoTurma valueOf(int codigo) {
		for (TipoTurma value : TipoTurma.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Tipo de turma inválido.");
	}

}
