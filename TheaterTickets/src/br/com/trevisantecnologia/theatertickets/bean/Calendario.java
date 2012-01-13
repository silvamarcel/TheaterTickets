package br.com.trevisantecnologia.theatertickets.bean;

import java.util.Calendar;
import java.util.Random;

public class Calendario {

	/**
	 * Pesquisa em banco se a data cai em um feriado
	 * 
	 * @param data
	 * @return Boolean
	 */
	public static Boolean ehFeriado(Calendar data) {
		// simula a pesquisa em banco
		Random r = new Random();
		return r.nextBoolean();
	}
}