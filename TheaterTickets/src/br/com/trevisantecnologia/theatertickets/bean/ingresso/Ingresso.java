package br.com.trevisantecnologia.theatertickets.bean.ingresso;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.trevisantecnologia.theatertickets.bean.DiaDaSemana;

public class Ingresso {

	private TipoIngresso tipoIngresso;
	private Double valor;
	private DiaDaSemana diaDaSemana;

	Ingresso() {// Package para garantir que só seja criado pela factory
	}

	public TipoIngresso getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(TipoIngresso tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

	public Double getValor() {
		switch (this.tipoIngresso) {
			case CRIANCA:
				this.valor = round(TipoIngresso.CRIANCA.getValor() - (TipoIngresso.CRIANCA.getValor() * (getDescontoCrianca() / 100)));
				break;
			case ESTUDANTE:
				this.valor = round(TipoIngresso.ESTUDANTE.getValor() - (TipoIngresso.ESTUDANTE.getValor() * (getDescontoEstudante() / 100)));
				break;
			case IDOSO:
				this.valor = round(TipoIngresso.IDOSO.getValor() - (TipoIngresso.IDOSO.getValor() * (getDescontoIdoso() / 100)));
				break;
		}
		return valor;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	private Double getDescontoCrianca() {
		if (this.diaDaSemana.isFeriado()) {
			return 0.0;
		}
		switch (this.diaDaSemana.getData().get(Calendar.DAY_OF_WEEK)) {
			case Calendar.MONDAY:
				return 10.0;
			case Calendar.TUESDAY:
				return 15.0;
			case Calendar.WEDNESDAY:
				return 30.0;
			case Calendar.THURSDAY:
				return 0.0;
			case Calendar.FRIDAY:
				return 11.0;
			case Calendar.SATURDAY:
				return 0.0;
			case Calendar.SUNDAY:
				return 0.0;
		}
		return 0.0;
	}

	private Double getDescontoEstudante() {
		if (this.diaDaSemana.isFeriado()) {
			return 0.0;
		}
		switch (this.diaDaSemana.getData().get(Calendar.DAY_OF_WEEK)) {
			case Calendar.MONDAY:
				return 35.0;
			case Calendar.TUESDAY:
				return 35.0;
			case Calendar.WEDNESDAY:
				return 35.0;
			case Calendar.THURSDAY:
				return 35.0;
			case Calendar.FRIDAY:
				return 35.0;
			case Calendar.SATURDAY:
				return 0.0;
			case Calendar.SUNDAY:
				return 0.0;
		}
		return 0.0;
	}

	private Double getDescontoIdoso() {
		if (this.diaDaSemana.isFeriado()) {
			return 5.0;
		}
		switch (this.diaDaSemana.getData().get(Calendar.DAY_OF_WEEK)) {
			case Calendar.MONDAY:
				return 10.0;
			case Calendar.TUESDAY:
				return 15.0;
			case Calendar.WEDNESDAY:
				return 40.0;
			case Calendar.THURSDAY:
				return 30.0;
			case Calendar.FRIDAY:
				return 0.0;
			case Calendar.SATURDAY:
				return 5.0;
			case Calendar.SUNDAY:
				return 5.0;
		}
		return 0.0;
	}

	private Double round(Double d) {
		int decimalPlace = 2;
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_DOWN);
		d = bd.doubleValue();
		return d;
	}
}