package com.minerva.bridge.domain.entity.enums;

public enum TipoPCD {
	
	DEFICIENCIA_FISICA(1),
	DEFICIENCIA_AUDITIVA(2),
	DEFICIENCIA_VISUAL(3),
	DEFICIENCIA_INTELECTUAL(4),
	DEFICIENCIA_MULTIPLA(5),
	DEFICIENCIA_REDUZIDA(6);
	
	private int codigo;
	
	private TipoPCD(int codigo) {
		this.codigo= codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static TipoPCD valueOf(int codigo) {
		for (TipoPCD value : TipoPCD.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código PCD inválido.");
	}

}
