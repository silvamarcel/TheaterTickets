package br.com.trevisantecnologia.theatertickets.bean.ingresso;

public enum TipoIngresso {
	CRIANCA(5.50), IDOSO(6.0), ESTUDANTE(8.0);

	private Double valor;

	private TipoIngresso(Double valor) {
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}
}