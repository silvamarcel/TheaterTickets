package br.com.trevisantecnologia.theatertickets.bean.ingresso;

import br.com.trevisantecnologia.theatertickets.bean.DiaDaSemana;

public class IngressoFactory {

	public static Ingresso create(TipoIngresso tipoIngresso, DiaDaSemana diaDaSemana) {
		Ingresso ingresso = new Ingresso();
		ingresso.setTipoIngresso(tipoIngresso);
		ingresso.setDiaDaSemana(diaDaSemana);
		return ingresso;
	}
}