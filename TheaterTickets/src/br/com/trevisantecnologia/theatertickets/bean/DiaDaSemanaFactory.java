package br.com.trevisantecnologia.theatertickets.bean;

import java.util.Calendar;

public class DiaDaSemanaFactory {

	/**
	 * Recebe a data pois pode ser uma data futura
	 * 
	 * @param data
	 * @return
	 */
	public static DiaDaSemana create(Calendar data, Boolean feriado) {
		DiaDaSemana diaDaSemana = new DiaDaSemana();
		diaDaSemana.setData(data);
		diaDaSemana.setFeriado(feriado);
		return diaDaSemana;
	}
}