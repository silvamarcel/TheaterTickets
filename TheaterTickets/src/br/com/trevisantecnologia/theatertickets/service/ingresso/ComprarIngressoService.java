package br.com.trevisantecnologia.theatertickets.service.ingresso;

import br.com.trevisantecnologia.theatertickets.bean.DiaDaSemana;
import br.com.trevisantecnologia.theatertickets.bean.ingresso.Ingresso;
import br.com.trevisantecnologia.theatertickets.bean.ingresso.TipoIngresso;

public interface ComprarIngressoService {

	public Ingresso compraIngresso(TipoIngresso tipoIngresso, DiaDaSemana diaDaSemana);
}