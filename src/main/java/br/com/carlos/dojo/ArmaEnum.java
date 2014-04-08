package br.com.carlos.dojo;

public enum ArmaEnum {

	DROWN("DROWN", 0), KNIFE("KNIFE", 1), AK("AK", 5), M16("M16", 10);

	private String nome;
	private int poder;

	private ArmaEnum(String nome, int poder) {
		this.nome = nome;
		this.poder = poder;
	}

	public String getNome() {
		return nome;
	}

	public int getPoder() {
		return poder;
	}

	public static ArmaEnum getArma(String arma) {
		for (ArmaEnum armaEnum : ArmaEnum.values()) {
			if (arma.equals(armaEnum.getNome())) {
				return armaEnum;
			}
		}
		return null;
	}

}
