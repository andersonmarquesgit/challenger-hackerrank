package br.com.hack.rest.stream;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.hack.stream.Stream;
import br.com.hack.stream.StreamImpl;
import br.com.hack.stream.StreamUtil;

public class StreamTest {

	@Test
	public void testFirstChar() {
		char[] chars01 = {'a','A','b','B','A','B','a','c'};
		String charsString01 = "aAbBABac";
		
		//Cria uma stream a partir de um array e verifica o primeiro caracter que não se repete
		Stream stream01 = new StreamImpl(chars01);
		char char01 = StreamUtil.firstChar(stream01);
		
		//Cria uma stream a partir de uma string e verifica o primeiro caracter que não se repete
		Stream stream02 = new StreamImpl(charsString01);
		char char02 = StreamUtil.firstChar(stream02);
		
		//Verifica se o resultado é o mesmo para as duas situações
		assertEquals(char01, char02);
		
		//Cria uma stream a partir de uma string sem um caracter único
		String charsString02 = "aAbBABab";
		Stream stream03 = new StreamImpl(charsString02);
		char char03 = StreamUtil.firstChar(stream03);
		
		//Verifica se o resultado é vazio, pois não foi encontrado um caracter único
		assertEquals(char03, ' ');
		
	}
}
