package br.com.carlos.dojo;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Partida {

	private Long codigo;
	private Calendar dataHoraComeco;
	private Calendar dataHoraFim;

	private Set<Jogador> jogadores;

	public Partida() {
	}

	public Partida(Long codigo, Calendar dataHoraComeco) {
		this.codigo = codigo;
		this.jogadores = new HashSet<>();
		this.dataHoraComeco = dataHoraComeco;
	}

	public void finalizaPartida(Calendar dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	/**
	 * Adiciona um novo jogador se o mesmo não existe e se não é WORLD.
	 * 
	 * @param nomeJogador
	 * @return
	 */
	public Jogador adicionarJogador(String nomeJogador) {
		Jogador jogador = procuraJogador(nomeJogador);
		if (jogador == null && !nomeJogador.equals("<WORLD>")) {
			jogador = new Jogador(nomeJogador);
			jogadores.add(jogador);
		}
		return jogador;
	}

	/**
	 * Procura um jogador pelo seu nome.
	 * 
	 * @param nomeJogador
	 * @return
	 */
	public Jogador procuraJogador(String nomeJogador) {
		for (Jogador jogador : this.getJogadores()) {
			if (jogador.getNome().equals(nomeJogador)) {
				return jogador;
			}
		}
		return null;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataHoraComeco() {
		return dataHoraComeco;
	}

	public void setDataHoraComeco(Calendar dataHoraComeco) {
		this.dataHoraComeco = dataHoraComeco;
	}

	public Calendar getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Calendar dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public Set<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(Set<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Partida other = (Partida) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
