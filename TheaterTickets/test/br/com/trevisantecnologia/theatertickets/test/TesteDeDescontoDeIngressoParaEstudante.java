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

public class TesteDeDescontoDeIngressoParaEstudante extends BaseTest {

	@Test
	public void TestarSeAoComprarIngressoEstudanteNaSegundaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.MONDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.20;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoEstudanteNaTercaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.TUESDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.20;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoEstudanteNaQuartaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.WEDNESDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.20;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoEstudanteNaQuintaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.THURSDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.20;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoEstudanteNaSextaFeiraDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.FRIDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 5.20;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoEstudanteNoSabadoDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.SATURDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 8.00;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoEstudanteNoDomingoDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.FALSE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(buscaProximoDiaDaSemana(Calendar.SUNDAY), feriado);

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 8.00;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	@Test
	public void TestarSeAoComprarIngressoEstudanteNoFeriadoDescontoEstaSendoRealizado() {
		Boolean feriado = Boolean.TRUE;
		DiaDaSemana diaDaSemana = DiaDaSemanaFactory.create(Calendar.getInstance(), feriado); // Não importa o dia da semana, por isso pega a data atual

		Ingresso ingresso = efetuaCompraIngressoPassandoDiaDaSemana(diaDaSemana);

		Double valorFinalIngresso = 8.00;
		Assert.assertEquals(valorFinalIngresso, ingresso.getValor());
	}

	private Ingresso efetuaCompraIngressoPassandoDiaDaSemana(DiaDaSemana diaDaSemana) {
		ComprarIngressoService comprarIngressoService = new ComprarIngressoServiceBean(); // Aqui eu colocaria um serviço de IoC
		Ingresso ingresso = comprarIngressoService.compraIngresso(TipoIngresso.ESTUDANTE, diaDaSemana);
		return ingresso;
	}
}