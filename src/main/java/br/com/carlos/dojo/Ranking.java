package br.com.carlos.dojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Carlos
 * 
 */
public class Ranking {

	private final Partida partida;
	private final List<Jogador> jogadorList;

	public Ranking(Partida partida, Set<Jogador> jogadorSet) {
		this.partida = partida;
		this.jogadorList = new ArrayList<>(jogadorSet);
		Collections.sort(this.jogadorList, new JogadorComparator());
	}

	/**
	 * Imprime o Ranking a partir da lista de jogadores já ordenada.
	 */
	public void mostrarRanking() {
		System.out.println("\n Classificão da Partida " + partida.getCodigo()
				+ ":");
		System.out.println("Posição  |   Nome     |   Matou  |   Morreu");
		for (int i = 0; i < this.jogadorList.size(); i++) {
			Jogador jogador = this.jogadorList.get(i);
			System.out.println("" + (i + 1) + "      |   " + jogador.getNome()
					+ "   |   " + jogador.getQuantidadeMatou() + "     |     "
					+ jogador.getQuantidadeMorreu());
		}
	}
}
