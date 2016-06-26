package br.com.hack.stream;

/**
 * Classe que implementa a interface {@link Stream}. De maneira geram ela pode ser instanciado de duas maneiras, 
 * usando um array de char[] ou mesmo uma string.
 * Obs.: Não é possível o fluxo de leitura da stream.
 * 
 * @author Anderson
 *
 */
public class StreamImpl implements Stream {

	char[] stream;
	int posicao = 0;
	
	public StreamImpl(char[] stream) {
		this.stream = stream;
	}
	
	public StreamImpl(String stream) {
		this.stream = new char[stream.length()];
		for (int i = 0; i < stream.length(); i++) {
			this.stream[i] = stream.charAt(i);
		}
	}
	
	/**
	 * Uma chamada para {@link #getNext()} irá retornar o próximo caracter a ser processado na stream.
	 * @see br.com.hack.stream.Stream#getNext()
	 */
	@Override
	public char getNext() {
		char caractere = stream[posicao];
		posicao++;
		return caractere;
	}

	/**
	 * Uma chamada para {@link #hasNext()} irá retornar se a stream ainda contem caracteres para processar.
	 * @see br.com.hack.stream.Stream#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (posicao >= stream.length || stream[posicao] == ' ') {
			return false;
		} else {
			return true;
		}
	}
	
}
