package br.com.trevisantecnologia.theatertickets.test;

import java.util.Calendar;

import org.junit.Ignore;

@Ignore
public class BaseTest {

	public Calendar buscaProximoDiaDaSemana(int diaDaSemana) {
		Calendar cal = Calendar.getInstance();
		while (cal.get(Calendar.DAY_OF_WEEK) != diaDaSemana) {
			cal.add(Calendar.DAY_OF_MONTH, 1); // verifica o proximo dia da semana passado
		}
		return cal;
	}
}