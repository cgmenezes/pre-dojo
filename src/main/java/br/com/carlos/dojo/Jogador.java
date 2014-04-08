package br.com.carlos.dojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Carlos
 * 
 */
public class Jogador {

	private String nome;
	private Set<ArmaEnum> armas;

	private int quantidadeMorreu;
	private int quantidadeMatou;
	private boolean morto;

	public Jogador(String nome) {
		this.nome = nome;
		this.armas = new HashSet<>();
	}

	/**
	 * Responsável por matar um outro jogador.
	 * 
	 * @param arma
	 * @param jogador
	 */
	public void matarJogador(String arma, Jogador jogador) {
		jogador.setQuantidadeMorreu(jogador.getQuantidadeMorreu() + 1);
		jogador.setMorto(true);
		jogador.getArmas().add(ArmaEnum.getArma(arma));
		this.setQuantidadeMatou(this.getQuantidadeMatou() + 1);
	}

	/**
	 * Responsável por matar o jogador por suicídio.
	 */
	public void cometerSuicidio() {
		this.setQuantidadeMorreu(this.getQuantidadeMorreu() + 1);
		this.setMorto(true);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isMorto() {
		return morto;
	}

	public void setMorto(boolean morto) {
		this.morto = morto;
	}

	public int getQuantidadeMorreu() {
		return quantidadeMorreu;
	}

	public void setQuantidadeMorreu(int quantidadeMorreu) {
		this.quantidadeMorreu = quantidadeMorreu;
	}

	public int getQuantidadeMatou() {
		return quantidadeMatou;
	}

	public void setQuantidadeMatou(int quantidadeMatou) {
		this.quantidadeMatou = quantidadeMatou;
	}

	public Set<ArmaEnum> getArmas() {
		return armas;
	}

	public void setArmas(Set<ArmaEnum> armas) {
		this.armas = armas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
