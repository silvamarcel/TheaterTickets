package br.com.trevisantecnologia.theatertickets.test;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import br.com.trevisantecnologia.theatertickets.bean.DiaDaSemana;
import br.com.trevisantecnologia.theatertickets.bean.DiaDaSemanaFactory;
import br.com.trevisantecnologia.theatertickets.bean.ingresso.Ingresso;
import br.com.trevisantecnologia.theatertickets.bean.ingresso.TipoIngresso;
import br.com.trevisantecnologia.theatertickets.service.ingresso.ComprarIngressoService;
import br.com.trevisantecnologia.theatertickets.service.ingresso.ComprarIngressoServiceBean;

public class TesteDeDescontoDeIngressoParaCrianca extends BaseTest {

	@Test
	public void TestarSeAoComprarIngressoCriancaNaSegundaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.MONDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 4.95;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoCriancaNaTercaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.TUESDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 4.67;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoCriancaNaQuartaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.WEDNESDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 3.85;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoCriancaNaQuintaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.THURSDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.50;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoCriancaNaSextaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.FRIDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 4.89;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoCriancaNoSabadoDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.SATURDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.50;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoCriancaNoDomingoDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.SUNDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.50;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoCriancaNoFeriadoDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.TRUE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(Calendar.getInstance(), feriado); //Não importa o dia da semana, por isso pega a data atual

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.50;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	private Ingresso efetuaCompraIngressoPassandoDiaDaSemana(DiaDaSemana diaDaSemana) {
		ComprarIngressoService comprarIngressoService = new ComprarIngressoServiceBean(); // Aqui eu colocaria um serviço de IoC
		Ingresso ingresso = comprarIngressoService.compraIngresso(TipoIngresso.CRIANCA, diaDaSemana);
		return ingresso;
	}
}