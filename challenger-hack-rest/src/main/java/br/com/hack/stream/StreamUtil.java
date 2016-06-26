package br.com.hack.stream;

import java.util.ArrayList;
import java.util.List;

public abstract class StreamUtil {

	/**
	 * Método responsável por encontrar o primeiro caracter que não se repita no resto da stream.
	 * @param input
	 * @return char
	 */
	public static char firstChar(Stream input){
		char caractere = ' ';
		List<Character> chars = new ArrayList<>();
		int qtdOcorrencia;
		while (input.hasNext()) {
			chars.add(input.getNext());
		}
		
		for (Character character : chars) {
			qtdOcorrencia = 0;
			for (Character character2 : chars) {
				if(character == character2) {
					qtdOcorrencia++;
				}
			}
			
			if(qtdOcorrencia == 1) {
				caractere = character;
				break;
			}
		}

		return caractere;
	}
}
