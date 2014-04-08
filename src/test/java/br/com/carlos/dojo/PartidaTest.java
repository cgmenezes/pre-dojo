package br.com.carlos.dojo;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class PartidaTest {

	@Test
	public void verificaSePartidaFoiCriada() {
		Partida partida = new Partida(1L, Calendar.getInstance());
		assertNotNull("A data de começo deve estar preenchida",
				partida.getDataHoraComeco());
	}

	@Test
	public void verificaSeAdicionouJogadorNaPartida() {
		Partida partida = new Partida(1L, Calendar.getInstance());
		partida.adicionarJogador("Carlos");
		assertNotNull("Existem jogadores na Partida", partida.getJogadores());
	}

	@Test
	public void verificaSeNomeDoJogadorExisteNaListaDeJogadores() {
		Partida partida = new Partida(1L, Calendar.getInstance());
		partida.adicionarJogador("Carlos");
		assertNotNull("Verifica se existe o jogador",
				partida.procuraJogador("Carlos"));
	}

	@Test
	public void procuraPorJogadorInexistenteNaListaDeJogadores() {
		Partida partida = new Partida(1L, Calendar.getInstance());
		assertNull("Procura Jogador que não existe",
				partida.procuraJogador("Pedro"));
	}

	@Test
	public void tentaAdicionarWorldNaListaDeJogadores() {
		Partida partida = new Partida(1L, Calendar.getInstance());
		partida.adicionarJogador("<WORLD>");
		assertNull("Procura pelo jogador <WORLD>",
				partida.procuraJogador("<WORLD>"));
	}

	@Test
	public void verificaSePartidaFoiFinalizada() {
		Partida partida = new Partida(1L, Calendar.getInstance());
		partida.finalizaPartida(Calendar.getInstance());
		assertNotNull("A data de fim deve estar preenchida",
				partida.getDataHoraFim());
	}
}
