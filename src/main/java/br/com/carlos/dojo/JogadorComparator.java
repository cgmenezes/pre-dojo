package br.com.carlos.dojo;

import java.util.Comparator;

/**
 * Compara os Jogadores da Lista da Partida utilizando a quantidade de
 * assassinatos como critério de comparação.
 * 
 * @author Carlos
 * 
 */
public class JogadorComparator implements Comparator<Jogador> {

	@Override
	public int compare(Jogador jogador1, Jogador jogador2) {
		if (jogador1.getQuantidadeMatou() > jogador2.getQuantidadeMatou()) {
			return -1;
		} else if (jogador1.getQuantidadeMatou() < jogador2
				.getQuantidadeMatou()) {
			return 1;
		}
		return 0;
	}

}
