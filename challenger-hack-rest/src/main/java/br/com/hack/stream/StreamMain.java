package br.com.hack.stream;

/**
 * Apenas uma classe de teste contendo um main exemplificando o uso do Stream.
 * 
 * @author Anderson
 *
 */
public class StreamMain {
	public static void main(String[] args) {
//		char[] chars = {'a','A','b','B','A','B','a','c'};
		String chars = "aAcBABab";
		System.out.print("Input: ");
		System.out.print(chars);
		Stream stream = new StreamImpl(chars);
		System.out.println();
		System.out.print("Output: ");
		System.out.print(StreamUtil.firstChar(stream));
	}
}
