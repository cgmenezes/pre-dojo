package br.com.carlos.dojo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Classe principal. Responsável por começar o Jogo.
 * 
 * @author Carlos
 * 
 */
public class Principal {

	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yyyy HH:MM:ss");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("log.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bufferedReader = new BufferedReader(isr);

			for (Partida partida : getPartidas(bufferedReader)) {
				new Ranking(partida, partida.getJogadores()).mostrarRanking();
			}

			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna uma lista de Partidas a partir das linhas encontradas no arquivo
	 * de log.
	 * 
	 * @param bufferedReader
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	private static List<Partida> getPartidas(BufferedReader bufferedReader)
			throws ParseException, IOException {
		List<Partida> partidaList = new ArrayList<>();
		Partida partida = null;

		String linha = bufferedReader.readLine();
		String[] arrayLinha;
		while (linha != null) {
			arrayLinha = linha.split(" ");

			if (linha.contains("has started")) {
				partida = new Partida(new Long(arrayLinha[5]),
						getCalendarFromString(arrayLinha[0] + " "
								+ arrayLinha[1]));
			}

			if (linha.contains("killed")) {
				processarMortes(partida, arrayLinha);
			}

			if (linha.contains("has ended")) {
				partida.finalizaPartida(getCalendarFromString(arrayLinha[0]
						+ " " + arrayLinha[1]));
				partidaList.add(partida);
			}

			linha = bufferedReader.readLine();
		}
		return partidaList;
	}

	/**
	 * Transforma uma String num Calendar.
	 * 
	 * @param string
	 * @return
	 * @throws ParseException
	 */
	private static Calendar getCalendarFromString(String string)
			throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(SIMPLE_DATE_FORMAT.parse(string));
		return calendar;
	}

	/**
	 * Recupera os dois Jogadores e processa a Morte.
	 * 
	 * @param partida
	 * @param stringArray
	 */
	private static void processarMortes(Partida partida, String[] stringArray) {
		Jogador jogadorMatador = partida.adicionarJogador(stringArray[3]);
		Jogador jogadorMorto = partida.adicionarJogador(stringArray[5]);

		if (jogadorMatador != null) {
			jogadorMatador.matarJogador(stringArray[5], jogadorMorto);
		} else {
			jogadorMorto.cometerSuicidio();
		}
	}

}
