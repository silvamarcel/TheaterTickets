package br.com.trevisantecnologia.theatertickets.service.ingresso;

import br.com.trevisantecnologia.theatertickets.bean.DiaDaSemana;
import br.com.trevisantecnologia.theatertickets.bean.ingresso.Ingresso;
import br.com.trevisantecnologia.theatertickets.bean.ingresso.IngressoFactory;
import br.com.trevisantecnologia.theatertickets.bean.ingresso.TipoIngresso;

public class ComprarIngressoServiceBean implements ComprarIngressoService {

	@Override
	public Ingresso compraIngresso(TipoIngresso tipoIngresso, DiaDaSemana diaDaSemana) {
		return IngressoFactory.create(tipoIngresso, diaDaSemana);
	}
}