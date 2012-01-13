package br.com.trevisantecnologia.theatertickets.bean;

import java.util.Calendar;

public class DiaDaSemana {

	private Calendar data;
	private Boolean feriado;

	DiaDaSemana() {// Package para garantir que só seja criado pela factory
	}

	public Calendar getData() {
		return data;
	}

	void setData(Calendar data) {
		this.data = data;
	}

	public Boolean isFeriado() {
		return feriado;
	}

	void setFeriado(Boolean feriado) {
		this.feriado = feriado;
	}
}