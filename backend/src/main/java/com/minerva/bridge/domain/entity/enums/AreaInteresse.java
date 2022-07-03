package com.minerva.bridge.domain.entity.enums;

public enum AreaInteresse {
	
	DESENVOLVIMENTO(1),
	NEGOCIOS(2),
	FINANCAS_CONTABILIDADE(3),
	TI_SOFTWARE(4),
	PRODUTIVIDADE(5),
	DESENVOLVIMENTO_PESSOAL(6),
	DESIGN(7),
	MARKETING(8),
	SAUDE(9);
	
	private int area;
	
	private AreaInteresse(int area) {
		this.area = area;
	}
	
	public int getArea() {
		return area;
	}
	
	public static AreaInteresse valueOf(int area) {
		for (AreaInteresse value : AreaInteresse.values()) {
			if (value.getArea() == area) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de área de interesse inválido.");
	}

}
