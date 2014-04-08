package br.com.carlos.dojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogadorTest {

	@Test
	public void verificaSeJogadorFoiCriado() {
		Jogador jogador = new Jogador("Carlos");
		assertNotNull("O Jogador deve existir", jogador.getNome());
	}

	@Test
	public void verificaSeJogadorEstaMorto() {
		Jogador jogador1 = new Jogador("Carlos");
		Jogador jogador2 = new Jogador("Pedro");

		jogador1.matarJogador("KNIFE", jogador2);
		assertTrue("Jogador 2 foi morto", jogador2.isMorto());
	}

	@Test
	public void verificaSeQuantidadeMorteAumentou() {
		Jogador jogador1 = new Jogador("Carlos");
		Jogador jogador2 = new Jogador("Pedro");

		jogador1.matarJogador("KNIFE", jogador2);

		assertEquals("Quantidade de morte igual a 1",
				jogador2.getQuantidadeMorreu(), 1);
	}

	@Test
	public void verificaSeQuantidadeAssassinatoAumentou() {
		Jogador jogador1 = new Jogador("Carlos");
		Jogador jogador2 = new Jogador("Pedro");

		jogador1.matarJogador("KNIFE", jogador2);

		assertEquals("Quantidade de assassinato igual a 1",
				jogador1.getQuantidadeMatou(), 1);
	}

	@Test
	public void verificaSeJogadorCometeuSuicidio() {
		Jogador jogador2 = new Jogador("Pedro");
		jogador2.cometerSuicidio();

		assertEquals("Quantidade de morte por suicídio igual a 1",
				jogador2.getQuantidadeMorreu(), 1);
		assertTrue("Jogador 2 foi morto", jogador2.isMorto());
	}

}
